package millisoft.fmy.FMYproject.service;

import millisoft.fmy.FMYproject.dto.RegisterDto;
import millisoft.fmy.FMYproject.dto.UserDto;
import millisoft.fmy.FMYproject.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll(int page, int count);

    UserDto getById(Integer id);

    void saveUser(UserDto user);

    void deleteById(Integer id);

    User getByEmail(String email);

    void register(RegisterDto registerDto);
}
