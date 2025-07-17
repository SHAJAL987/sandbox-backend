package com.ostad.sendbox.controller;

import com.ostad.sendbox.common.ResponseHandler;
import com.ostad.sendbox.payload.DetectLanRequest;
import com.ostad.sendbox.payload.DetectionLanResponse;
import com.ostad.sendbox.service.TranslateService;
import kong.unirest.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dev0/translate/v1")
public class TranslateController {
    @Autowired
    private TranslateService translateService;

    /************ API Health Check *****************/
    @GetMapping("/healthCheck")
    public String tst(){
        return "API Health is OK !!";
    }

    /************** Detect Language ****************/
    @PostMapping("/detectlanguage")
    public ResponseEntity<Object> detectLanguage(@RequestBody DetectLanRequest detectLanRequest) {
        DetectionLanResponse res = null;
        Map<String, Object> resData;
        try {
            res = translateService.detectLanguage(detectLanRequest);
            resData = new HashMap<>();
            resData.put("detections", res);
            if (resData.put("data",resData) != null){
                return ResponseHandler.responseBuilder("Operation Successful", "ERR-100", res);
            }else {
                return ResponseHandler.responseBuilder("Operation Not Successful", "ERR-000", res);
            }
        } catch (UnirestException e) {
            return ResponseHandler.responseBuilder("Operation Not Successful", "ERR-000", e.getMessage());
        }
    }

}
