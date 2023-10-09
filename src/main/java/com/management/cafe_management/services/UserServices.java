package com.management.cafe_management.services;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserServices {
ResponseEntity<String> signUp(Map<String,String> requesMap);
}
