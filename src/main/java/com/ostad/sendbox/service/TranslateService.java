package com.ostad.sendbox.service;

import com.ostad.sendbox.payload.DetectLanRequest;
import com.ostad.sendbox.payload.DetectionLanResponse;
import kong.unirest.UnirestException;

public interface TranslateService {
    public DetectionLanResponse detectLanguage(DetectLanRequest request) throws UnirestException;
}
