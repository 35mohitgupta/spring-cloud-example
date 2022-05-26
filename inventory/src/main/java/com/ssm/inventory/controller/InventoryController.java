package com.ssm.inventory.controller;

import com.ssm.inventory.dto.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    @GetMapping("/inventory/{custId}")
    public List<Item> getInventory(@PathVariable String custId){
        System.out.println("Inventory controller called ... ");
        if(custId.equals("123"))
            throw new RuntimeException();
        List<Item> res = new ArrayList<>();
        res.add(new Item("i1", 3333));
        res.add(new Item("i2", 2312));
        return res;
    }
}
