package com.ostad.sendbox.serviceImpl;

import com.ostad.sendbox.mapper.GetGeoLocationMapper;
import com.ostad.sendbox.payload.IpGeoLocationResponse;
import com.ostad.sendbox.service.IpGeoLocationService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IpGeoLocationServiceImpl implements IpGeoLocationService {
    @Value("${downstream.geo.host}")
    private String GIO_API_HOST;
    @Value("${downstream.geo.key}")
    private String GIO_KEY;

    @Override
    public IpGeoLocationResponse getGeoLocation() {
        IpGeoLocationResponse geoLocationResponse = null;
        try{
            HttpResponse<String> response = Unirest.get("https://"+GIO_API_HOST+"/ipgeo?apiKey="+GIO_KEY)
                    .asString();
            geoLocationResponse = GetGeoLocationMapper.mapToIpGeoLocation(response);

            if (response.getStatus() == 200){
                try{
                    HttpResponse<String> agentResponse = Unirest.get("https://"+GIO_API_HOST+"/user-agent?apiKey="+GIO_KEY)
                            .asString();
                    geoLocationResponse = GetGeoLocationMapper.mapToIpGeoLocationWithAgent(response,agentResponse);
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }else {
                geoLocationResponse = GetGeoLocationMapper.mapToIpGeoLocation(response);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        return geoLocationResponse;
    }

}
