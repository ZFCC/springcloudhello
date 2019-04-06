package com.sn.springcloudhelloprovider.Fegin;

import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * FileName: FeignServiceImpl
 * Author:  18075555
 * Date: 2019/4/6 12:02.
 * Description: //描述当前类所属模块
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
@RestController
public class FeignServiceImpl implements FeignService {
    @Override
    public User hello(String userName) {
        User user = new User();
        user.setAge(20);
        user.setId("123");
        user.setUserName("你好");

        System.out.println();
        return user;
    }
}
