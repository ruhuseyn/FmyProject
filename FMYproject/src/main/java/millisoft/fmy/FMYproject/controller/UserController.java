package millisoft.fmy.FMYproject.controller;




import lombok.extern.slf4j.Slf4j;
import millisoft.fmy.FMYproject.dto.RegisterDto;
import millisoft.fmy.FMYproject.dto.UserDto;
import millisoft.fmy.FMYproject.serviceImpl.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserServiceImpl userServiceImpl;

    Logger logger =  LoggerFactory.getLogger(UserController.class);

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/getall")
    public List<UserDto> getAll(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count){
        logger.info("get all");
        return userServiceImpl.getAll(page,count);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Integer id){
        return userServiceImpl.getById(id);
    }


    @PostMapping("/save")
    public void save(@RequestBody UserDto user){
        userServiceImpl.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        userServiceImpl.deleteById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void register(@RequestBody RegisterDto request) {
        userServiceImpl.register(request);
    }
}
