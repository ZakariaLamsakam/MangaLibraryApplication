package com.example.mangalibraryapp.Scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Scraper {

    public static void main(String[] args) throws IOException {

        final String url="https://myanimelist.net/topmanga.php?type=manga";

        try{
            final Document doc = Jsoup.connect(url).get();

            for(Element row : doc.select(
                    "table.top-ranking-table tr")){
                if(row.select(".ac.rank").text().equals("")){
                    continue;
                }else{
                    final String rank = row.select(".ac.rank").text();
                    final String name = row.select(".manga_h3").text();
                    final String details = row.select(".mt4.di-ib.information").text();
                    final String score = row.select(".fs14.ac.score").text().trim();

                    System.out.println("Rank: " + rank + " Name: " + name + " Details: " + details + " Score: " + score);
                }
            }

        }

        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
