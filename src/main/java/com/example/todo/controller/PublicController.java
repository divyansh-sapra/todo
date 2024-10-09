package com.example.todo.controller;

import com.example.todo.entity.UsersEntity;
import com.example.todo.service.UserDetailsServiceImpl;
import com.example.todo.service.UsersService;
import com.example.todo.utils.ApiResponse;
import com.example.todo.utils.JwtUtils;
import com.example.todo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/signup")
    public ApiResponse<String> signUp(@RequestBody UsersEntity users) {
        boolean user = usersService.createUser(users);
        return user?ResponseUtil.successResponse():ResponseUtil.errorResponse("User not created, Please try again later");
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UsersEntity users) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(users.getUserName(), users.getPassword())
            );
            userDetailsService.loadUserByUsername(users.getUserName());
            String jwt = jwtUtils.generateToken(users.getUserName());
            return new ResponseEntity<>(jwt, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.BAD_REQUEST);
        }
    }
}
