package com.ssn.configclientseller.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SellerController {

    @Value("${my.common.propoerties}")
    private String serverAppProperty;

    @Value("${my.different.common.propoerty}")
    private String commondiffProperty;

    @Value("${my.seller.propoerty}")
    private String sellerProperty;


    @GetMapping("/properties")
    public List<String> getProperties(){
        List<String> res = new ArrayList<>();
        res.add(serverAppProperty);
        res.add(commondiffProperty);
        res.add(sellerProperty);
        return res;
    }
}
