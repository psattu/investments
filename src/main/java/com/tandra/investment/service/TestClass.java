package com.tandra.investment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {
    public static void main(String[] args){

        List<String> quotesList = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println("Removing from list == >"+ quotesList.remove("AAPL"));
    }
}
