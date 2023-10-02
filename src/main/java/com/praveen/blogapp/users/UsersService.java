package com.praveen.blogapp.users;

import com.praveen.blogapp.users.dtos.CreateUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
   public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
       this.usersRepository = usersRepository;
       this.modelMapper = modelMapper;
   }

   public UserEntity createUser(CreateUserRequest u) {
       UserEntity newUser = modelMapper.map(u, UserEntity.class);
       // TODO Create user and Encrypt it

//          var newUser = UserEntity.builder()
//                  .username(u.getUsername())
//                  .password(u.getPassword())
//                  .email(u.getEmail())
//                    .build();
            return usersRepository.save(newUser);
   }

    public UserEntity getUser(String username) throws UserNotFoundException {
        return usersRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId) throws UserNotFoundException {
        return usersRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

   public Optional<UserEntity> loginUser(String username, String password) throws UserNotFoundException {
       var user = usersRepository.findByUsername(username);
       if(user == null){
           throw new UserNotFoundException(username);
       }
       return user;
   }

   public static class UserNotFoundException extends Exception{
       public UserNotFoundException(String username){
           super("user" + username + " not found");
       }
       public UserNotFoundException(Long userId) {
           super("User with id: " + userId + " not found");
       }
   }
}
