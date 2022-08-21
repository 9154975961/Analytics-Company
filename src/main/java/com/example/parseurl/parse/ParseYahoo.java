package com.example.parseurl.parse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseYahoo {

    public String ParseYahoo(String name){
        Connection connection = Jsoup.connect("https://finance.yahoo.com/quote/"+name+"/profile?p="+name);
        connection.userAgent("Mozilla/5.0");
        connection.timeout(5000);
        Document document = null;
        Element industryElement;
        String stringIndustry = "not found";

        if (name.equals("not found")) {return stringIndustry;}

        try {
            document = connection.get();
            Elements idElement = document.getElementsByAttributeValue("class", "D(ib) Va(t)");
            industryElement = idElement.first().child(4);
            stringIndustry = industryElement.text();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return stringIndustry;
        }

    }
}
