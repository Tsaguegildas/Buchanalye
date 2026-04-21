package com.pm.backend_buchanalyse.service;
import com.pm.backend_buchanalyse.dto.UserRequest;
import com.pm.backend_buchanalyse.dto.UserResponse;
import com.pm.backend_buchanalyse.models.User;
import com.pm.backend_buchanalyse.repository.UserRepository;
import com.pm.backend_buchanalyse.wrapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class UserService {
private UserRepository userRepository;

    public UserResponse getUser(int userId) {
       // UserResponse userResponse = new UserResponse();
        User userdb = this.userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User nicht gefunden "));

//        userResponse.setId(userdb.getId());
//        userResponse.setUserRole(userdb.getUserRole());
//        userResponse.setEmail(userdb.getEmail());
//        userResponse.setPassword(userdb.getPassword());
//        userResponse.setFirstName(userdb.getFirstName());
//        userResponse.setLastName(userdb.getLastName());
//        userResponse.setCreatedAt(userdb.getCreatedAt());
//        userResponse.setUpdatedAt(userdb.getUpdatedAt());
//        userResponse.setCreatedAt(userdb.getCreatedAt());
//        return userResponse;
        return UserMapper.toResponse(userdb);


    }

    public UserResponse addUser(UserRequest userRequest) {
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new RuntimeException("Email already exist");
        }
        User user= new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        User userSaved =  this.userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userSaved.getId());
        userResponse.setEmail(userSaved.getEmail());
        userResponse.setPassword(userSaved.getPassword());
        userResponse.setLastName(userSaved.getLastName());
        userResponse.setFirstName(userSaved.getFirstName());
        userResponse.setCreatedAt(userSaved.getCreatedAt());
        userResponse.setUpdatedAt(userSaved.getUpdatedAt());

    return userResponse;

    }


    public List<UserResponse> getUsers() {

//        return this.userRepository.findAll()
//                .stream()
//                .map(userdb -> {
//                    UserResponse userResponse = new UserResponse();
//
//                    userResponse.setId(userdb.getId());
//                    userResponse.setUserRole(userdb.getUserRole());
//                    userResponse.setEmail(userdb.getEmail());
//                    userResponse.setPassword(userdb.getPassword());
//                    userResponse.setFirstName(userdb.getFirstName());
//                    userResponse.setLastName(userdb.getLastName());
//                    userResponse.setCreatedAt(userdb.getCreatedAt());
//                    userResponse.setUpdatedAt(userdb.getUpdatedAt());
//
//                    return userResponse;
//                })
//                .toList();

//  das hier ist noch besser für die Lessbarbeit. es gibt alle users der DB zurück
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }


    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User nicht gefunden ");
        }
        userRepository.deleteById(id);
    }

    public UserResponse updateUser(User user, int id) {
        User userdb = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User zu update nicht gefunden"));

        userdb.setEmail(user.getEmail());
        userdb.setLastName(user.getLastName());
        userdb.setFirstName(user.getFirstName());
        userdb.setPassword(user.getPassword());
        userdb.setUserRole(user.getUserRole());

        User savedUser = userRepository.save(userdb);

        // Mapping zu UserResponse
        return UserMapper.toResponse(savedUser);
    }
}
