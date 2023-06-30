package millisoft.fmy.FMYproject.security;

import lombok.RequiredArgsConstructor;
import millisoft.fmy.FMYproject.mapper.UserMapper;
import millisoft.fmy.FMYproject.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {


    private final UserService userService;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toUserDetails(userService.getByEmail(username));
    }
}
