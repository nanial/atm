package com.atm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CourseOfCurrency {
    public static void getCourse() {
        try {
            Date date = new Date();
            List<String> nameOfCurrency = new ArrayList<>();
            List<Double> valueOfCurrency = new ArrayList<>();
            Map<String, Double> currencyMap = new HashMap<>();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
            Document document = Jsoup.connect("https://finance.tut.by/kurs/").get();

            Elements elements = document.getElementsByClass("b-course");
            String s = elements.select("p").text();
            String[] currency = s.split(" ");

            for (int i = 0; i < currency.length; i++) {
                i++;
                valueOfCurrency.add(Double.parseDouble(currency[i++]));//in expect georgian lari
                i++;
            }

            Elements elements1 = document.getElementsByClass("first");
            var ar = elements1.select("a");
            for (var a : ar) {
                nameOfCurrency.add(a.text());
            }

            for (int i = 0; i < nameOfCurrency.size(); i++) {
                currencyMap.put(nameOfCurrency.get(i), valueOfCurrency.get(i));
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Курс валюс на сегодня " + simpleDateFormat.format(date) + "г." + "                  |");
            System.out.println("---------------------------------------------------");
            for (Map.Entry<String, Double> m : currencyMap.entrySet()) {
                System.out.printf("%-23s%-11s%-6.4f%s%n", m.getKey(), " |  курс НБРБ  | ", m.getValue(), " BY |");
            }
            System.out.println("---------------------------------------------------");
        } catch (
                IOException ie) {
            System.out.println(ie.getMessage());
        }
    }
}
