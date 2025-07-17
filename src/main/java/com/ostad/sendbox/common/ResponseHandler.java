package com.ostad.sendbox.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(
            String resMessage, String resCode, Object resObject
    ){
        Map<String, Object> response = new HashMap<>();
        response.put("resMessage",resMessage);
        response.put("resCode",resCode);
        response.put("resData",resObject);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
