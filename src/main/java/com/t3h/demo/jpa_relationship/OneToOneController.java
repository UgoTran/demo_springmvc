package com.t3h.demo.jpa_relationship;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class OneToOneController {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private OrgRepo orgRepo;

    @GetMapping("/org")
    public ResponseEntity org() {
        List<Org> orgs = orgRepo.findAll();
        for (Org org : orgs) {
            log.info("{} -> {}", org.getId(), org);
        }
        return ResponseEntity.ok(orgs);
    }
}
