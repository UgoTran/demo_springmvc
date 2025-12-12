package com.t3h.demo.one_to_many;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @Column(name = "tuirials_id")
    private Long tutirialId;

    // mqh 2 chiều bị n+1 query
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Tutirials tuirials;
}
