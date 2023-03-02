package com.producter.basketballcard.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Position  {
    @Id
    private Long id;
    private String name;
    private String shortName;
}
