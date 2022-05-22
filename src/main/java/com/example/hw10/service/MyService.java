package com.example.hw10.service;

import com.example.hw10.UserObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MyService {
    @Value("${roles}")
    List<String> roles;

    public UserObject getUser(HttpServletRequest request) {
        String name = request.getRemoteUser() != null ? request.getRemoteUser() : "no_username";
        String role = "no_role";
        for (String r : roles) {
            if (request.isUserInRole(r))
                role = r;
        }
        return new UserObject(name, role);
    }
}
