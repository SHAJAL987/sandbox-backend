package com.ostad.sendbox.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeZoneObj {
    private String name;
    private int offset;
    private int offsetWithDst;
    private String currentTime;
    private Double currentTimeUnix;
    private Boolean isDst;
    private int dst_savings;
}
