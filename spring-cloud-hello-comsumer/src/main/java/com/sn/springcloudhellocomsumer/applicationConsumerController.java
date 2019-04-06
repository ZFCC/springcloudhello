package com.sn.springcloudhellocomsumer;

import com.sn.springcloudhellocomsumer.feign.FeignConsumerService;
import com.sn.springcloudhelloprovider.Fegin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class applicationConsumerController {

    @Autowired
    FeignConsumerService feignConsumerService;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    //添加负载均衡配置
    @Bean
    @LoadBalanced
    public org.springframework.web.client.RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/consumer/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String testConsumer(@PathVariable String id, HttpServletRequest request) {

        List<ServiceInstance> list = discoveryClient.getInstances("STORES");
        System.out.println(discoveryClient.description());
        System.out.println("discoveryClient.getServices().size()+" + discoveryClient.getServices().size());
//打印EurekaProvider客户端的服务信息
        for (String str : discoveryClient.getServices()) {
            System.out.println("services " + str);
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(str);
            for (ServiceInstance si : serviceInstances) {
                System.out.println("    services:" + str + ":getHost()=" + si.getHost());
                System.out.println("    services:" + str + ":getPort()=" + si.getPort());
                System.out.println("    services:" + str + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + str + ":getUrl()=" + si.getUri());
                System.out.println("    services:" + str + ":getMetadata()=" + si.getMetadata());
            }
        }
        String string = "";


        System.out.println(id);
        String flag =id;
        if (id.equals("A")) {
            System.out.println(id);
            RestTemplate rt = new RestTemplate();

            string= rt.getForObject("http://localhost:8080/search/A", String.class);
            return string;
//        return rt.getForObject("http://EUREKA-PROVIDER/search/A", String.class);
        }
        if (id.equals("B")) {
            System.out.println(id);
            RestTemplate rt = new RestTemplate();

            string= rt.getForObject("http://localhost:8081/search/B", String.class);
            return string;
        }
        //            RestTemplate rt = getRestTemplate();
//            return rt1.getForObject("http://localhost:8081/search/A", String.class);
        return string;
    }

//http://localhost:8887/add?a=1&b=2
    @GetMapping("/add")
    public String add(Integer a, Integer b){
        Long strTime = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://eureka-provider/add?a="+a+"&b="+b, String.class);
        Long endTime = System.currentTimeMillis();
        System.out.println(result+","+String.valueOf(endTime-strTime));
        return result;
    }

    /**
    *
    * 功能描述: <br>
    * [功能描述]：feign测试demo
    * [应用场景]：
    * 创建人：18075555
    * 创建时间：2019/4/6 9:30
    * 修改记录：工号(姓名)-修改内容
    * @see [相关类/方法](可选)
    * @since [产品/模块版本](可选)
    */
    @RequestMapping("/helloUser")
    public User findUser(){

        return feignConsumerService.hello("");

    }
}
