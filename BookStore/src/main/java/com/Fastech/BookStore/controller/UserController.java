package com.Fastech.BookStore.controller;

import com.Fastech.BookStore.dto.UserDto;
import com.Fastech.BookStore.model.User;
import com.Fastech.BookStore.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    public static boolean isValidEmail(String email) {
        int atIndex = email.indexOf("@");
        int dotComIndex = email.lastIndexOf(".com");

        return (atIndex > 0 && dotComIndex > (atIndex + 1) && dotComIndex == (email.length() - 4));
    }
    @PostMapping("/createuser")
    public ResponseEntity<UserDto> create(@RequestBody User user)
    {
        if(user.getPassword().length()<8 || !isValidEmail(user.getEmail()))
        {
         return ResponseEntity.badRequest().build();
        }
        else {
        userRepository.save(user);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return ResponseEntity.ok(userDto);
    }
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username){
        User user= userRepository.findByUsername(username);
        if(user!=null)
        {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user,userDto);
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();

    }



}
