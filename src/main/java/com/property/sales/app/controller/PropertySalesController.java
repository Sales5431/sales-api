package com.property.sales.app.controller;

import com.property.sales.app.model.entity.User;
import com.property.sales.app.model.request.UserRequestData;
import com.property.sales.app.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales-v1")
public class PropertySalesController {
    @Autowired
    UserDataService userDataService;

    @PostMapping(value = "/addUserData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUserData(@RequestBody UserRequestData userRequestData) {
        userDataService.addUserdata(userRequestData);
        return new ResponseEntity<>("User Added Successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/retrieveAllUsers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> retrieveAllUserData(){
        List<User> users = userDataService.retrieveAllUserData();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/retrieveFilteredUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> retrieveFilteredUser(@RequestParam("searchParam") String searchParam, @RequestParam("searchBy") String searchBy){
        Optional<User> optUser = userDataService.retrieveFilteredUser(searchParam, searchBy);
        User user = optUser.orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/status")
    public ResponseEntity<String> status(){
        return new ResponseEntity<>("Live", HttpStatus.OK);
    }
}
