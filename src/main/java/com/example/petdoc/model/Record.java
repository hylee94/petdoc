package com.example.petdoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "chart")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @ManyToOne
    @JoinColumn(name = "petid", referencedColumnName = "petid")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pet petid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @CreationTimestamp
    private Date date;

    private String disease;
    private String doctor_op;
    private String medicine;
    private String fee;
    private String hospital;
    private String memo;
}
