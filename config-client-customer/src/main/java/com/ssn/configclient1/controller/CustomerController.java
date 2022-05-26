package com.ssn.configclient1.controller;

import com.ssn.configclient1.dto.Item;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    @Value("${my.common.propoerties}")
    private String serverAppProperty;

    @Value("${my.different.common.propoerty}")
    private String commondiffProperty;

    @Value("${my.customer.propoerty}")
    private String customerProperty;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustFeignClient custFeignClient;

    @GetMapping("/properties")
    public List<String> getProperties(){
        List<String> res = new ArrayList<>();
        res.add(serverAppProperty);
        res.add(commondiffProperty);
        res.add(customerProperty);
        return res;
    }

    @GetMapping("/customer/inventory/{custId}")
    @CircuitBreaker(name = "customerService1", fallbackMethod = "getCustomerInventoryFallback")
    public List<Item> getCustomerInventory(@PathVariable("custId") String custId){
        System.out.println(">>>>>>>>> in controller method <<<<<<<<<<<<<<<");
        // in case of rest template
//        ResponseEntity<List> response = restTemplate.getForEntity("http://inventory/inventory/"+custId, List.class);
        List<Item> inventoryItems = custFeignClient.getCustInventory(custId);
        return  inventoryItems;

    }

    public List<Item> getCustomerInventoryFallback(String custId, Throwable throwable){
        System.out.println(">>>>>>>>> in fallback <<<<<<<<<<<<<<<");
        return Collections.emptyList();
    }
}
