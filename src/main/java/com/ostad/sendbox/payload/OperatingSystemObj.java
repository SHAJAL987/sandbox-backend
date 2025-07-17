package com.ostad.sendbox.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatingSystemObj {
    private String name;
    private String type;
    private String version;
    private String versionMajor;
}
