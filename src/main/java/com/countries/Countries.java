package com.countries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Countries {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            JSONObject o = (JSONObject) parser.parse(new FileReader("eu.json"));
            JSONArray array = (JSONArray) o.get("data");
            ArrayList<JSONObject> list = new ArrayList<>();

            for (Object value : array) {
                list.add((JSONObject) value);
            }

            list.sort(new PopulationComparator());

            System.out.println();
            System.out.println("********************************************");
            System.out.println("Top 10 countries with the biggest population");
            System.out.println("********************************************");
            System.out.println();

            for (JSONObject obj : list.subList(0, 10)) {
                System.out.println("Country: " + obj.get("name"));
                System.out.println("Capital: " + obj.get("capital"));
                System.out.println("Currency: " + obj.get("currencies"));
                System.out.println("Population: " + obj.get("population"));
                System.out.println("Area: " + obj.get("area"));
                System.out.println();
                System.out.println("*****");
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            JSONObject o = (JSONObject) parser.parse(new FileReader("eu.json"));
            JSONArray array = (JSONArray) o.get("data");
            ArrayList<JSONObject> list = new ArrayList<>();

            for (Object value : array) {
                list.add((JSONObject) value);
            }

            list.sort(new AreaComparator());

            System.out.println();
            System.out.println("**************************************");
            System.out.println("Top 10 countries with the biggest area");
            System.out.println("**************************************");
            System.out.println();

            for (JSONObject obj : list.subList(0, 10)) {
                System.out.println("Country: " + obj.get("name"));
                System.out.println("Capital: " + obj.get("capital"));
                System.out.println("Currency: " + obj.get("currencies"));
                System.out.println("Population: " + obj.get("population"));
                System.out.println("Area: " + obj.get("area"));
                System.out.println();
                System.out.println("*****");
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            JSONObject o = (JSONObject) parser.parse(new FileReader("eu.json"));
            JSONArray array = (JSONArray) o.get("data");
            ArrayList<JSONObject> list = new ArrayList<>();

            for (Object value : array) {
                list.add((JSONObject) value);
            }

            list.sort(new DensityComparator());

            System.out.println();
            System.out.println("*************************************************************************");
            System.out.println("Top 10 countries with the biggest population density (people / square km)");
            System.out.println("*************************************************************************");
            System.out.println();

            for (JSONObject obj : list.subList(0, 10)) {
                System.out.println("Country: " + obj.get("name"));
                System.out.println("Capital: " + obj.get("capital"));
                System.out.println("Currency: " + obj.get("currencies"));
                System.out.println("Population: " + obj.get("population"));
                System.out.println("Area: " + obj.get("area"));
                System.out.println();
                System.out.println("*****");
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class PopulationComparator implements Comparator<JSONObject> {

    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        long v1 = (long) (o1.get("population"));
        long v2 = (long) (o2.get("population"));
        return Long.compare(v2, v1);
    }

}

class AreaComparator implements Comparator<JSONObject> {

    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        double v1 = (double) (o1.get("area"));
        double v2 = (double) (o2.get("area"));
        return Double.compare(v2, v1);
    }

}

class DensityComparator implements Comparator<JSONObject> {

    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        long v1 = (long) (o1.get("population"));
        double v2 = (double) (o1.get("area"));
        long v3 = (long) (o2.get("population"));
        double v4 = (double) (o2.get("area"));
        long d1 = v1 / (long) v2;
        long d2 = v3 / (long) v4;
        return Long.compare(d2, d1);
    }

}
