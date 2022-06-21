package com.github.krunalvora;

/**

Find out all possibility of string that substring is able to replace from alias map

ex1:
input: value: "key1key2key3"
alias: {"k1": "key1", "k2": "key2", "k12": "k1k2"}
results: ["key1key2key3", "k1key2key3", "key1k2key3", "k1k2key3", "k12key3"]
explanation:
from input vlaue: key1key2key3
1. we do not replace any substring: one possible result key1key2key3
2 we replace one substring: key1 since key1 is one of value from alias, -> k1key2key3
3. we replace one substring: key2 since key2 is one of value from alias, ->  k1k2key3
4. we replace both substring: key1, key2 since both are the value from alias, -> k1k2key3
5. we replace one substring: k1k2 since k1k2 is the value from alias, -> k12key3
6 we replace one substring: key2 since key2 is one of value from alias, -> key1k2key3

 */

import java.util.*;

public class SubstringAlias {

    static Map<String, String> reverseMap;
    static Set<String> visited;
    static List<String> result;

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "key1");
        map.put("k2", "key2");
        map.put("k12", "k1k2");

        String input = "key1key2key3";
        List<String> result = getSubstringAliasList(input, map);
        System.out.println(result);
    }

    private static List<String> getSubstringAliasList(String input, Map<String, String> aliasMap) {
        result = new ArrayList<>();

        reverseMap = new HashMap<>();
        for (String key: aliasMap.keySet()) {
            reverseMap.put(aliasMap.get(key), key);
        }

        visited = new HashSet<>();

        // result.add(input);
        dfs(input);
        return result;
    }

    private static void dfs(String input) {
        if (input.isBlank()) {
            return;
        }
        if (visited.contains(input)) {
            return;
        }
        visited.add(input);
        result.add(input);
        for (String key: reverseMap.keySet()) {
            String value = reverseMap.get(key);
            if (input.contains(key)) {
                String newInput = input.replace(key, value);
                dfs(newInput);
            }
        }
    }


}
