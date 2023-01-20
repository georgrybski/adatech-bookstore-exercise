package br.com.ada.georg.bookstore.controller;

import java.util.HashMap;

public class HashMapTools {

    private HashMapTools(){}

    public static HashMap<Integer,String> initializeCategoryGenresOrTypesHashMap(String[] genreOrTypeArray) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int index = 0; index < genreOrTypeArray.length; index++) {
            hashMap.put(index + 1, genreOrTypeArray[index]);
        }
        return hashMap;
    }
}
