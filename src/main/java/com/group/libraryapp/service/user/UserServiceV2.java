package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.group.libraryapp.repository.user.UserRepository;

import javax.naming.Name;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

  private final UserRepository userRepository;

  public UserServiceV2(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void saveUser(UserCreateRequest request) {
    userRepository.save(new User(request.getName(), request.getAge()));
  }

  public List<UserResponse> getUsers() {
    return userRepository.findAll().stream()
            .map(UserResponse::new)
            .collect(Collectors.toList());
  }

  public void updateUser(UserUpdateRequest request) {
    User user = userRepository.findById(request.getId())
            .orElseThrow(IllegalArgumentException::new);

    user.updateName(request.getName());
  }

  public void deleteUser(String name) {
    //
   User user = userRepository.findByName(name);
    if (user == null){
      throw new IllegalArgumentException();
    }

   /* if (!userRepository.existsByName(name)) {
      throw new IllegalArgumentException();
    }*/

  }
}
