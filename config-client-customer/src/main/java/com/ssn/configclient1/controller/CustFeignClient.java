package com.ssn.configclient1.controller;

import com.ssn.configclient1.dto.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//name = MS name and url = api gateway location
@FeignClient(name = "inventory", url = "http://localhost:8099")
public interface CustFeignClient {

    @RequestMapping(value = "/inventory/{custId}")
    List<Item> getCustInventory(@PathVariable("custId") String custId);

}
