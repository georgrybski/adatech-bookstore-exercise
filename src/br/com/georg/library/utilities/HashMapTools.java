package br.com.georg.library.utilities;

import java.util.HashMap;

public class HashMapTools {

    private HashMapTools(){}

    public static HashMap<Integer,String> initializeGenresOrTypesHashMap(String[] genreOrTypeArray) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int index = 0; index < genreOrTypeArray.length; index++) {
            hashMap.put(index, genreOrTypeArray[index]);
        }
        return hashMap;
    }

}
