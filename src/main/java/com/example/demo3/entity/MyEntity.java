package com.example.demo3.entity;

import com.example.demo3.dto.MyEntityDto;
import jakarta.persistence.*;

@Entity
@Table(name = "my_entity")
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public MyEntity() {
    }

    public MyEntity(MyEntityDto myEntityDto) {
        this.name = myEntityDto.getName();
        this.id = myEntityDto.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
