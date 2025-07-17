package com.ostad.sendbox.controller;

import com.ostad.sendbox.common.ResponseHandler;
import com.ostad.sendbox.payload.IpGeoLocationResponse;
import com.ostad.sendbox.service.IpGeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dev0/geo/v1")
public class IpGeoLocationController {
    @Autowired
    IpGeoLocationService ipGeoLocationService;

    @GetMapping("/location")
    public ResponseEntity<Object> getGeoLocation(){
        Map<String, Object> resData = new HashMap<>();
        IpGeoLocationResponse response = ipGeoLocationService.getGeoLocation();
        resData.put("data",resData);
        if (resData.put("data",resData) != null){
            return ResponseHandler.responseBuilder("Operation Successful", "ERR-100", response);
        }else {
            return ResponseHandler.responseBuilder("Operation Not Successful", "ERR-000", response);
        }

    }
}
