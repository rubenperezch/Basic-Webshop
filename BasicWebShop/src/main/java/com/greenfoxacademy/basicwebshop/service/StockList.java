package com.greenfoxacademy.basicwebshop.service;

import com.greenfoxacademy.basicwebshop.models.ShopItem;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StockList {

    public static List<ShopItem> shopList = new ArrayList<>(Arrays.asList(
            new ShopItem("Fender","6-string guitar","Jaguar HH",1000.00, 3),
            new ShopItem("PRS","6-string guitar","Custom-24 SE",1500.00, 5),
            new ShopItem("Fender","6-string guitar","Jaguar Tremolo",1200.00, 0),
            new ShopItem("Fender","4-string bass","Mustang",1200.00, 2),
            new ShopItem("Fender","6-string guitar","Mustang",1500.00, 5),
            new ShopItem("PRS","6-string guitar","Pauls Guitar SE",1200.00, 0),
            new ShopItem("Ibanez","5-string bass","SR-305E",300.00, 3),
            new ShopItem("Gretsch","6-string guitar","White Falcon",3800.00, 1),
            new ShopItem("Gretsch","7-string guitar","Electromatic",850.00, 4)
    ));

    public static List<ShopItem> getShopList() {
        return shopList;
    }

    public static List<ShopItem> onlyAvailable() {
        List<ShopItem> onlyAvailableList = shopList.stream().filter(item -> item.getStock() > 0).collect(Collectors.toList());
        return onlyAvailableList;
    }

    public static List<ShopItem> sortCheapest() {
        List<ShopItem> cheapestFirst = shopList.stream().sorted(Comparator.comparing(ShopItem::getPrice)).collect(Collectors.toList());
        return cheapestFirst;
    }

    public static List<ShopItem> containsFender() {
        List<ShopItem> fenderItems = shopList.stream().filter(item -> item.getBrand().contains("Fender")).collect(Collectors.toList());
        return fenderItems;
    }

    public static Double averageStock() {

        List<Integer> listOfStocks = new ArrayList<>();

        for (int i = 0; i < shopList.size(); i++) {
            listOfStocks.add(shopList.get(i).getStock());
        }

        DoubleSummaryStatistics stats = listOfStocks.stream().mapToDouble(x->x).summaryStatistics();

        return stats.getAverage();
    }

    public static List<ShopItem> mostExpensiveAvailable() {

        List<Double> listPrices = new ArrayList<>();

        for (int i = 0; i < shopList.size(); i++) {
            listPrices.add(shopList.get(i).getPrice());
        }

        DoubleSummaryStatistics stats = listPrices.stream().mapToDouble(x ->x).summaryStatistics();

        List<ShopItem> mostExpensiveAvailable = shopList.stream().filter(item -> item.getStock() > 0).filter(item -> item.getPrice() == stats.getMax()).collect(Collectors.toList());

        return mostExpensiveAvailable;
    }

    public static List<ShopItem> searchResult(String name) {

        List<ShopItem> searchItems = shopList.stream().filter(item -> item.getBrand().toLowerCase().contains(name.toLowerCase()) ||
                item.getType().toLowerCase().contains(name.toLowerCase()) ||
                item.getModel().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());

        return searchItems;
    }
}
