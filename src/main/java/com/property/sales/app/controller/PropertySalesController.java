package com.property.sales.app.controller;

import com.property.sales.app.model.request.UserRequestData;
import com.property.sales.app.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales-v1")
public class PropertySalesController {
    @Autowired
    UserDataService userDataService;

    @RequestMapping(method = RequestMethod.POST, value = "/addUserData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUserData(@RequestBody UserRequestData userRequestData) {
        userDataService.addUserdata(userRequestData);
        return new ResponseEntity<>("User Added Successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/status")
    public ResponseEntity<String> status(){
        return new ResponseEntity<>("Live", HttpStatus.OK);
    }
}
