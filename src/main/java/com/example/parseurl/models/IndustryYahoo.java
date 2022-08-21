package com.example.parseurl.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class IndustryYahoo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String industryYahooName;

    @OneToOne(mappedBy = "industryYahoo", cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    public IndustryYahoo() {
    }

    public IndustryYahoo(String industryYahooName) {
        this.industryYahooName = industryYahooName;
    }
}
