package com.ostad.sendbox.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAgentResponse {
    private String userAgentString;
    private String name;
    private String type;
    private String version;
    private String versionMajor;
    private DeviceObj device;
    private EngineObj engine;
    private OperatingSystemObj operatingSystem;
}
