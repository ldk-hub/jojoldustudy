package com.koscom.springboot.web;

import com.koscom.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
        public HelloResponseDto helloDto(@RequestParam("name") String name,
                                         @RequestParam("amount") int amount){

        //리팩터 -> 리팩토링된것임.
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        System.out.println("값:>>"+ dto);
        return dto;
    }


}
