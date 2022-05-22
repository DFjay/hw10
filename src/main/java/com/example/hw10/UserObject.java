package com.example.hw10;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserObject {
    String name;
    String role;
}
