package ru.vsemenenko.binchecker.binchecker.model;

import javax.persistence.*;

@Entity
@Table(name = "bins")
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", unique = true)
    private Integer value;

    public Bin(Integer value) {
        this.value = value;
    }

    public Bin (){}

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
