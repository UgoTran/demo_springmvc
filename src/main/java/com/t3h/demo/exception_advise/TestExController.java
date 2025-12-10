package com.t3h.demo.exception_advise;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestExController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/ex")
    public ResponseEntity ex() {

        //đầu vào là ai
        //Security Context Holder - lưu trữ user đang theo req


        Integer.parseInt("xx");

        return ResponseEntity.ok("OK");
    }
}
