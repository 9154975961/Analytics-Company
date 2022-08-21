package com.example.parseurl.controller;

import com.example.parseurl.models.Company;
import com.example.parseurl.models.IndustryIndeed;
import com.example.parseurl.models.IndustryYahoo;
import com.example.parseurl.parse.ParseIndeed;
import com.example.parseurl.parse.ParseNameCompany;
import com.example.parseurl.parse.ParseYahoo;
import com.example.parseurl.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/main")
    public String greeting(Model model) {
        Iterable<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        return "page";
    }

    @PostMapping("/main")
    public String postAdd(@RequestParam String name, Model model) throws IOException {

        ParseIndeed parseIndeed = new ParseIndeed();
        String stringIndustryIndeed = parseIndeed.ParseIndeed(name);
        IndustryIndeed industryIndeed = new IndustryIndeed(stringIndustryIndeed);

        ParseNameCompany parseNameCompany = new ParseNameCompany();
        String stringNameStockCompany = parseNameCompany.ParseNameCompany(name);

        ParseYahoo parseYahoo = new ParseYahoo();
        String stringIndustryYahoo = parseYahoo.ParseYahoo(stringNameStockCompany);
        IndustryYahoo industryYahoo = new IndustryYahoo(stringIndustryYahoo);

        Company company = new Company(name);
        company.setIndustryIndeed(industryIndeed);
        company.setIndustryYahoo(industryYahoo);
        companyRepository.save(company);

        return "redirect:/main";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model) {
        Company companiId = companyRepository.findById(id).orElseThrow();
        companyRepository.delete(companiId);
        return "redirect:/main";
    }
}
