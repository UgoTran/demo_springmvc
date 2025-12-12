package com.t3h.demo.one_to_many;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OneToManyTestController {

    @Autowired
    TutRepo tutRepo;

    @Autowired
    ComRepo comRepo;

    @GetMapping("/onetomany")
    public ResponseEntity onetomany() {
        log.info("\n {} ", tutRepo.findAll());

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/manytoone")
    public ResponseEntity manytoone(@RequestParam Long id) {
        var com = comRepo.findById(id).orElse(null);
        log.info("\n {} ", com);

        return ResponseEntity.ok(com);
    }
}
