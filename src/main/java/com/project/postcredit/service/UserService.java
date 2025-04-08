package com.project.postcredit.service;

import com.project.postcredit.dao.UserDataDao;
import com.project.postcredit.model.LoginReq;
import com.project.postcredit.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDataDao userDataDao;


    public ResponseEntity<String> getLoginAuth(LoginReq loginReq) {
        try {
            String dbPassword = userDataDao.findByUserName(loginReq.getUserName());

            if (dbPassword == null) {
                return ResponseEntity.status(404).body("User not found");
            }

            if (loginReq.getPassword().equals(dbPassword)) {
                return ResponseEntity.ok("Login Successful");
            } else {
                return ResponseEntity.status(401).body("Invalid Credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }


    public ResponseEntity<String> signUp(UserData userData) {
        try {
            userDataDao.save(userData);
            return ResponseEntity.ok("Signup Successful");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("something went wrong");
        }
    }
}



