package hello;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AirportPairs {

    public static void orderAirports(Map<String, String> sortedMap) {

        Map<String, String> orderedMap = new LinkedHashMap<>();
        Map.Entry<String, String> next = sortedMap.entrySet().iterator().next();
        String key = next.getKey();

        while (sortedMap.size() > orderedMap.size()) {
            orderedMap.put(key, sortedMap.get(key));
            key = sortedMap.get(key);
        }

        System.out.println(orderedMap);

    }

    public static void main(String[] args) {

        //Map<String, String> stringTreeMap = new TreeMap<>();
        Map<String, String> stringTreeMap = new HashMap();
        /*stringTreeMap.put("ITO", "KOA");
        stringTreeMap.put("ANC", "SEA");
        stringTreeMap.put("LGA", "CDG");
        stringTreeMap.put("KOA", "LGA");
        stringTreeMap.put("PDX", "ITO");
        stringTreeMap.put("SEA", "PDX");*/
        stringTreeMap.put("5", "6");
        stringTreeMap.put("7", "8");
        stringTreeMap.put("1", "5");
        stringTreeMap.put("6", "7");

        orderAirports(stringTreeMap);
    }
}