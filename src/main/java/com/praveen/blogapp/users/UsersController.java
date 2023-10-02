package com.praveen.blogapp.users;

import com.praveen.blogapp.users.dtos.CreateUserRequest;
import com.praveen.blogapp.users.dtos.CreateUserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final ModelMapper modelMapper;

    public UsersController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> signup(@RequestBody CreateUserRequest request){
        UserEntity savedUser = usersService.createUser(request);
        URI saveUserUri = URI.create("/users/" + savedUser.getId());
        return ResponseEntity.created(saveUserUri).body(modelMapper.map(savedUser, CreateUserResponse.class));

    }
}
