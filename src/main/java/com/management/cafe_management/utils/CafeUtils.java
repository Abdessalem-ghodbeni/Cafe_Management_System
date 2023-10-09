package com.management.cafe_management.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils {
//    ici nous allons mettre les methodes qui seront utilisés dans n'importe quelle classe ou bien endroit de ce projet
    private  CafeUtils(){

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return  new ResponseEntity<String>("{\"Message\":\""+responseMessage+"\"}",httpStatus);
    }
}
