package com.sn.springcloudhelloprovider.Fegin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * FileName: FeignService
 * Author:  18075555
 * Date: 2019/4/6 11:59.
 * Description: //描述当前类所属模块
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
public interface FeignService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    User  hello(@RequestParam("userName") String userName);
}
