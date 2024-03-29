package com.group.libraryapp.contoller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 userSerivce;

    public UserController(UserServiceV2 userSerivce) {

        this.userSerivce = userSerivce;
    }

    @PostMapping("/user") //Post /user
    public void saverUser(@RequestBody UserCreateRequest request) {
        userSerivce.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userSerivce.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){

        userSerivce.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userSerivce.deleteUser(name);

    }

    @GetMapping("/user/error-test")
    public void errorTest() {
        throw new IllegalArgumentException();
    }

}
