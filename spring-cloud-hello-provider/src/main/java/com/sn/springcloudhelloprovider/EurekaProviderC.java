package com.sn.springcloudhelloprovider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * FileName: EurekaProviderC
 * Author:  18075555
 * Date: 2019/2/16 16:28.
 * Description: //描述当前类所属模块
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderC {
    public static void main(String[] args) {
//		SpringApplication.run(EurekaProviderA.class, args);

        new SpringApplicationBuilder(EurekaProviderC.class).properties("server.port="+8082).run(args);
    }
}
