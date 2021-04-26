package com.example.springredis.controller;

import com.example.springredis.model.Item;
import com.example.springredis.service.ExampleService;
import com.example.springredis.service.OtherExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private OtherExampleService otherExampleService;

    @GetMapping("/example")
    public String exampleApi() {
        return exampleService.someProcessing();
    }

    @PostMapping("/item")
    public void addItem(@RequestBody Item item) {
        otherExampleService.addItemToRedis(item.getName(), item.getName());
    }

    @GetMapping("/item/{key}")
    public void addItem(@PathVariable String key) {
        otherExampleService.getItemFromRedis(key);
    }

    @GetMapping(path = "/list")
    public String getLastFromList() {
        return otherExampleService.getLastItemFromList();
    }

    @PostMapping(path = "/list/{item}")
    public ResponseEntity addToList(@PathVariable String item) {
        otherExampleService.addToList(item);
        return ResponseEntity.ok("nice");
    }


}
