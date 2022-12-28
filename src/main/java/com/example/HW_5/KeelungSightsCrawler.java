package com.example.HW_5;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeelungSightsCrawler {
    public List<Sight> getItems(String inputZone) {

        final String url = "https://www.travelking.com.tw";
        ArrayList<Sight> sights = new ArrayList<Sight>();

        {
            try {
                Document doc = Jsoup.connect(url + "/tourguide/taiwan/keelungcity/").get();
                Element guidePoint = doc.getElementById("guide-point");
                Elements zones = guidePoint.select("div.box>h4");

                for (Element zone : zones) {
                    if (zone.text().substring(0, 2).equals((inputZone))) {

                        Elements List = zone.nextElementSibling().select("ul>li");
                        for (Element li : List) {
                            String href = li.select("a").attr("href");
                            Document docli = Jsoup.connect(url + href).get();
                            Element pointArea = docli.getElementById("point_area");

                            Sight s = new Sight(
                                    pointArea.select("meta[itemprop=name]").attr("content"),
                                    zone.text().substring(0, 2),
                                    pointArea.select("cite>span>span>strong").text(),
                                    pointArea.select("meta[itemprop=image]").attr("content"),
                                    pointArea.select("meta[itemprop=description]").attr("content"),
                                    pointArea.select("meta[itemprop=address]").attr("content"),
                                    docli.getElementById("point_data").select(".address>p>a:eq(0)").attr("href")
                            );

                            sights.add(s);
                        }
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sights;
    }
}
