package com.heyufei.gateway.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author HeYuFei
 * @since 2023-04-06  15:56
 */
@RestController
@CrossOrigin
@RequestMapping("/")
public class Test {
    @GetMapping(value = "/service")
    public Object service() {

        Object obj=null;
        return obj;
    }
}
