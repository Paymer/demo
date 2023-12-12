package com.demo.demo.entities;


//import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Id;

@Data
@Entity
@Table (name="nace")
public class NaceEntity {

    @Id
    @Column(name="orderId")
    private Long order;

    @Column(name="level")
    private Integer level;

    @Column(name="code")
    private String code;

    @Column(name="parent")
    private String parent;

    @Column(name="description")
    private String description;

    @Column(name="itemIncludes")
    private String itemIncludes;

    @Column(name="alsoIncludes")
    private String alsoIncludes;

    @Column(name="rulings")
    private String rulings;

    @Column(name="itemExcludes")
    private String itemExcludes;

    @Column(name="referenceIsic")
    private String referenceIsic;
}
