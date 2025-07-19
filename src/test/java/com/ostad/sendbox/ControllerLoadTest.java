package com.ostad.sendbox;

import com.ostad.sendbox.controller.IpGeoLocationController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerLoadTest {
    @Autowired
    private IpGeoLocationController ipGeoLocationController;

    @Test
    void controllerIsLoaded() {
        Assertions.assertThat(ipGeoLocationController).isNotNull();
    }
}
