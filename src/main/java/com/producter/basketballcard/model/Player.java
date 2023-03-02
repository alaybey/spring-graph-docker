package com.producter.basketballcard.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

//Aggregate
@Data
@Entity
public class Player implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @OneToOne(targetEntity = Position.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name = "position_id", insertable = false, updatable = false)
    private Long positionId;

    public Player(){}

    public Player(String name, String surname, Position position) {
        this.setName(name);
        this.setSurname(surname);
        this.setPosition(position);
    }
}
