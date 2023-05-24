package com.jpanativesql.nativesql.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="fname")
    private String firstName;
    @Column(name="lname")
    private String lastName;
    private int score;
    @Override
    public String toString(){
        return "Student [id="+id+",firstName="+firstName+",lastName="+lastName+", score="+score+"]";
    }
}


