package com.ostad.sendbox.serviceImpl;

import com.ostad.sendbox.payload.DetectLanRequest;
import com.ostad.sendbox.payload.DetectionLanResponse;
import com.ostad.sendbox.service.TranslateService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TranslateServiceImpl implements TranslateService {
    @Value("${downstream.rapid.host}")
    private String RAPID_API_HOST;
    @Value("${downstream.rapid.key}")
    private String RAPID_API_KEY;
    @Override
    public DetectionLanResponse detectLanguage(DetectLanRequest request) throws UnirestException {
        DetectionLanResponse detectionObj = new DetectionLanResponse();
        try {
            HttpResponse<String> response = Unirest.post("https://"+RAPID_API_HOST+"/language/translate/v2/detect")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .header("Accept-Encoding", "application/gzip")
                    .header("X-RapidAPI-Key", RAPID_API_KEY)
                    .header("X-RapidAPI-Host", RAPID_API_HOST)
                    .field("q", request.getQuestion())
                    .asString();

            JSONObject resJsonObj = new JSONObject(response.getBody());
            JSONArray detections = resJsonObj.getJSONObject("data")
                    .getJSONArray("detections").getJSONArray(0);

            double confidence = detections.getJSONObject(0).getDouble("confidence");
            String language = detections.getJSONObject(0).getString("language");
            boolean isReliable = detections.getJSONObject(0).getBoolean("isReliable");

            detectionObj.setLanguage(language);
            detectionObj.setConfidence(confidence);
            detectionObj.setReliable(isReliable);

            return detectionObj;

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
