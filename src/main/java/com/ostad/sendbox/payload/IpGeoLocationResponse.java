package com.ostad.sendbox.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpGeoLocationResponse {
    private String ip;
    private String continentCode;
    private String continentName;
    private String countryCode2;
    private String countryCode3;
    private String countryName;
    private String countryCapital;
    private String stateProv;
    private String stateCode;
    private String district;
    private String city;
    private String zipcode;
    private String latitude;
    private String longitude;
    private Boolean isEu;
    private String callingCode;
    private String countryTld;
    private String languages;
    private String countryFlag;
    private String geonameId;
    private String isp;
    private String connectionType;
    private String organization;
    private CurrencyObj currency;
    private TimeZoneObj timeZone;
    private UserAgentResponse userAgent;
}
