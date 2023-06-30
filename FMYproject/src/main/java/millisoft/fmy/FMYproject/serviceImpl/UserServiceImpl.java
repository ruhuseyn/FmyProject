package millisoft.fmy.FMYproject.serviceImpl;

import lombok.AllArgsConstructor;
import millisoft.fmy.FMYproject.config.PasswordConfig;
import millisoft.fmy.FMYproject.dto.RegisterDto;
import millisoft.fmy.FMYproject.dto.UserDto;
import millisoft.fmy.FMYproject.entity.User;
import millisoft.fmy.FMYproject.exception.UserNotFoundException;
import millisoft.fmy.FMYproject.mapper.UserMapper;
import millisoft.fmy.FMYproject.repository.UserRepository;
import millisoft.fmy.FMYproject.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordConfig passwordConfig;

    @Override
    public List<UserDto> getAll(int page, int count) {

        Page<User> all = userRepository.findAll(PageRequest.of(page, count));

        return userMapper.toUserDtoList(all.getContent());
    }


    @Override
    public UserDto getById(Integer id) {

        return userMapper.toUserDto(userRepository.findById(id).get());
    }

    @Override
    public void saveUser(UserDto userDto) {

        userRepository.save(userMapper.toUser(userDto));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFoundException("Email tapilmadi"));
    }

    @Override
    public void register(RegisterDto registerDto) {
        User user = userMapper.toUserFromRegisterDto(registerDto);
        user.setPassword(passwordConfig.passwordEncoder().encode(registerDto.password()));
        userRepository.save(user);
    }


}
