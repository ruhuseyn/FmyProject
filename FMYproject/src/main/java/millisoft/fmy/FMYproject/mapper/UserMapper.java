package millisoft.fmy.FMYproject.mapper;

import millisoft.fmy.FMYproject.dto.RegisterDto;
import millisoft.fmy.FMYproject.dto.UserDto;
import millisoft.fmy.FMYproject.entity.User;
import millisoft.fmy.FMYproject.security.MyUserDetails;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> user);

    User toUser(UserDto userDto);

    MyUserDetails toUserDetails(User user);

    User toUserFromRegisterDto(RegisterDto registerDto);

}
