package com.greenfoxacademy.basicwebshop.controllers;

import com.greenfoxacademy.basicwebshop.service.StockList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @GetMapping("/")
    public String renderShopList(Model model) {
        model.addAttribute("items", StockList.getShopList());
        return "index";
    }

    @GetMapping("/only-available")
    public String renderOnlyAvailable(Model model) {
        model.addAttribute("items", StockList.onlyAvailable());
        return "only-available";
    }

    @GetMapping("/cheapest-first")
    public String renderCheapestFirst(Model model) {
        model.addAttribute("items",StockList.sortCheapest());
        return "cheapest-first";
    }

    @GetMapping("/contains-fender")
    public String renderFenderItems(Model model) {
        model.addAttribute("items",StockList.containsFender());
        return "contains-fender";
    }

    @GetMapping("/average-stock")
    public String renderAverageStock(Model model) {
        model.addAttribute("average",StockList.averageStock());
        return "average-stock";
    }

    @GetMapping("/most-expensive-available")
    public String renderMostExpensiveAvailable(Model model) {
        model.addAttribute(("items"),StockList.mostExpensiveAvailable());
        return "most-expensive-available";
    }

    @GetMapping("/search")
    public String renderSearch(Model model) {
        model.addAttribute("items",StockList.getShopList());
        return "search";
    }

    @PostMapping("/search")
    public String returnSearch(Model model, @RequestParam String search) {
        model.addAttribute("items",StockList.searchResult(search));
        return "search";
    }
}
