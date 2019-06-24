package com.btp.api;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.btp.models.User;
import com.btp.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    UserService userService;
    
    @PostMapping(value="/registerUser", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> registerUser(@RequestBody User userInfo) {
        LOG.info("userInfoObj: " + userInfo);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            userService.registerUser(userInfo);
            returnMap.put("response", "");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            returnMap.put("response", "Email already exists");
        }

        return returnMap;
    }

    @PostMapping(value="/loginUser", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> loginUser(@RequestBody User userInfo) {
        LOG.info("userInfoObj: " + userInfo);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        User user = null;
        try {
            //LOGIN SERVICE CALL
            user = userService.loginUser(userInfo.getEmail(), userInfo.getPassword());
            if (user == null) {
                returnMap.put("response", "User does not exist");
                returnMap.put("user", user);
            } else {
                userService.loadUserByUsername(userInfo.getEmail());
                returnMap.put("response", "");
                returnMap.put("user", user);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            returnMap.put("response", "Error in fetching user");
            returnMap.put("user", user);
        }

        return returnMap;
    }
}