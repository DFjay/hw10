package com.example.hw10.controller;

import com.example.hw10.UserObject;
import com.example.hw10.service.MyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MyController {

    MyService myService;

    @GetMapping(value = "/public/api")
    public ResponseEntity<String> getPublicResponse() {
        return new ResponseEntity<>("Открытый доступ", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('support')")
    @GetMapping(value = "/admin/api")
    public ResponseEntity<UserObject> getAdminResponse(HttpServletRequest request) {
        return new ResponseEntity<>(myService.getUser(request), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('support')")
    @GetMapping(value = "/support/api")
    public ResponseEntity<UserObject> getSupportResponse(HttpServletRequest request) {
        return new ResponseEntity<>(myService.getUser(request), HttpStatus.OK);
    }
}
