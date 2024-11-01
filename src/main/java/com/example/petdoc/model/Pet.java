package com.example.petdoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petid;

    @ManyToOne
    @JoinColumn(name = "memberid", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Member memberid;

    private String type;
    private String name;
    private String gender;
    private int age;
    private String hospital;
}
