package com.example.parseurl.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class IndustryIndeed {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String industryIndeedName;

    @OneToOne(mappedBy = "industryIndeed", cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    public IndustryIndeed() {
    }

    public IndustryIndeed(String industryIndeedName) {
        this.industryIndeedName = industryIndeedName;
    }
}
