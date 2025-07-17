package com.ostad.sendbox.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceObj {
    private String name;
    private String type;
    private String brand;
    private String cpu;
}
