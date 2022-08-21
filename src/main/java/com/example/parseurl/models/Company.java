package com.example.parseurl.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="industryIndeed_id")
    private IndustryIndeed industryIndeed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="industryYahoo_id")
    private IndustryYahoo industryYahoo;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }
}
