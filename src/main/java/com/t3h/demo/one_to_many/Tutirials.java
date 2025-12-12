package com.t3h.demo.one_to_many;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
@Table(name = "Tutirials")
public class Tutirials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String pblished;

    /**
     * mappedBy: trỏ đến cột của Comments, ánh xạ ko cần FK
     * targetEntity: trỏ đến entity
     */
    @OneToMany(targetEntity = Comments.class, mappedBy = "tutirialId")
    List<Comments> comments;

}
