package com.hobeom.shop.shop_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/product")
public class ProductController {
    @RequestMapping("/list")
    public String list() {
        return "product/list";
    }
}
