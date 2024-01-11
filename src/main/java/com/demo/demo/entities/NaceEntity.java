package com.demo.demo.entities;


//import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
//import org.springframework.data.annotation.Id;


@Data
@Entity
@Table (name="nace")
public class NaceEntity {

    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order;

    @Column(name="lvl")
    private Integer level;

    @Column(name="code")
    private String code;

    @Column(name="parent")
    private String parent;

    @Column(name="description")
    private String description;

    @Column(name="item_includes")
    private String itemIncludes;

    @Column(name="also_includes")
    private String alsoIncludes;

    @Column(name="rulings")
    private String rulings;

    @Column(name="item_excludes")
    private String itemExcludes;

    @Column(name="reference_isic")
    private String referenceIsic;
}
