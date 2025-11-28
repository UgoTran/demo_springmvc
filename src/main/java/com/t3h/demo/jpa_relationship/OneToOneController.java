package com.t3h.demo.jpa_relationship;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping("/org")
    public ResponseEntity updateOrg() {
        Org org = orgRepo.findById(2).orElse(null);
        Address address = org.getAddress();
        address.setStreet(address.getStreet().toUpperCase());
        org.setAddress(address);
        org = orgRepo.save(org);
        log.info("Update -> {}", org);
        return ResponseEntity.ok(org);
    }

    @DeleteMapping("/org")
    public ResponseEntity removeOrg() {
        Org org = orgRepo.findById(3).orElse(null);
        orgRepo.delete(org);
        return ResponseEntity.ok("OK");
    }
}
