package com.demo.demo.entities;


import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity (name="Nace")
public class NaceEntity {

    @Id
    private Long order;

    private Integer level;

    private String code;

    private String parent;

    private String description;

    private String itemIncludes;

    private String alsoIncludes;

    private String rulings;

    private String itemExcludes;

    private String referenceIsic;
}
