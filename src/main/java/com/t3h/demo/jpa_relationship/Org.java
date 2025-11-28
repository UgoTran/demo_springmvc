package com.t3h.demo.jpa_relationship;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "org")
@ToString
public class Org {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String orgId;
    /**
     * Cascade
     * 1. Case Update
     * empty: update > filed thay đổi theo gtrị mới
     * ALL: update > filed thay đổi theo gtrị mới
     * PERSIST: update > filed thay đổi theo gtrị mới
     * MERGE: update > filed thay đổi theo gtrị mới
     * DETACH: update > filed thay đổi theo gtrị mới
     * REMOVE: update > filed thay đổi theo gtrị mới
     * 2. Case Delete: delete(org)
     * DETACH: xoạ org, ko xóa address
     * REMOVE:  xoạ org, xóa address
     */
    @OneToOne(cascade = CascadeType.REMOVE)
    private Address address;
}
