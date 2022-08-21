package com.example.parseurl.parse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseIndeed {

    public String ParseIndeed(String name){

        Connection connection = Jsoup.connect("https://www.indeed.com/cmp/"+name);
        connection.userAgent("Mozilla/5.0");
        connection.timeout(5000);
        Document document = null;
        Elements idElement;
        Element industryElement;
        String stringIndustry = "not found";

        try {
            document = connection.get();
            idElement = document.getElementsByAttributeValue("data-testid", "companyInfo-industry");
            industryElement = idElement.first().child(1);
            stringIndustry = industryElement.text();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            return stringIndustry;
        }
    }
}
