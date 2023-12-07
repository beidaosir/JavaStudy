package com.hnu.controller;

import com.hnu.po.Pcas;
import com.hnu.query.PcasQuery;
import com.hnu.service.PcasService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    PcasService pcasService;

    @PostMapping("/children")
    public ResponseObj getChildren(@RequestBody PcasQuery query){
        List<Pcas> children = pcasService.getChildren(query);
        return ResponseObj.SUCCESS(children);
    }

}
