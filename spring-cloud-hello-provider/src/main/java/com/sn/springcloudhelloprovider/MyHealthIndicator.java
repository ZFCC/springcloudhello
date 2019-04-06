package com.sn.springcloudhelloprovider;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

public class MyHealthIndicator implements HealthIndicator {

    /**
     * Actuator健康端点检测，自定义健康 提示器
     * @return
     */
    @Override
    public Health health() {

        if (ApplicationProviderController.isCanLinkDb){
            return new Health.Builder(Status.UP).build();
        }else {
            return new Health.Builder(Status.DOWN).build();

        }

    }
}
