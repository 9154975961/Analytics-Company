package com.example.parseurl.parse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseNameCompany {

    public String ParseNameCompany(String name){

        Connection connection = Jsoup.connect("https://ru.investing.com/search/?q="+name);
        connection.userAgent("Mozilla/5.0");
        connection.timeout(5000);
        Document document = null;
        String stringCompanyStockName = "not found";

        try {
            document = connection.get();
            Elements Element = document.getElementsByAttributeValue("class", "js-inner-all-results-quote-item row");
            Element companyElement = Element.first().child(1);
            stringCompanyStockName = companyElement.text();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            return stringCompanyStockName;
        }
}
}
