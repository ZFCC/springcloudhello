package com.sn.springcloudhellocomsumer.feign;

import com.sn.springcloudhelloprovider.Fegin.FeignService;
import com.sn.springcloudhelloprovider.Fegin.User;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Copyright (C), 2002-2019, 苏宁易购电子商务有限公司
 * FileName: FeignConsumerService
 * Author:  18075555
 * Date: 2019/4/6 12:06.
 * Description: //描述当前类所属模块
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
@FeignClient(value = "eureka-provider")
public interface FeignConsumerService extends FeignService {

}
