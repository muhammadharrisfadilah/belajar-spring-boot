package com.example.belajar_resfullapi_batch9_enigmacamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(value = "hello")
    public String hello(){
        return "<h1>hello world <h1>";
    }

    @GetMapping(value = "hobbies")
    public String[] hobbies(){
        return new String[]{"makan","tidur"};
    }
    @GetMapping("/request-param{key}")
    public String getRequestParam(@RequestParam String key){
        return key;
    }

    @GetMapping("/person/{id}")
    public String getPersonByid(@PathVariable String id){

        return "person" + id;
    }

    @GetMapping("/person")
    public Map<String, Object> getPerson(){
        Map<String, Object> person = new HashMap<>();

        person.put("nama", "haris");
        person.put("age", "20");
        person.put("status", "single");

        String[] dataHobbi = new String[]{"bola","futsal"};
        person.put("hobbi", dataHobbi);

        return person;
    }
}
