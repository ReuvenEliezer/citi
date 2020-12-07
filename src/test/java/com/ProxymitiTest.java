package com;

import org.junit.Test;

import java.util.*;

public class ProxymitiTest {

    @Test
    public void checkIfTwoStringAreSameChars() {
        String s1 = "abc";
//        String s1 = "agc";
        String s2 = "acb";
        boolean isSame = checkIfTwoStringAreSameChars(s1, s2);
        boolean isSame2 = checkIfTwoStringAreSameCharsUsingOneMap(s1, s2);
        //spring:
        //1. scope - with multithreaded
//        2. exception handling
//        3. Evict controller
    }


    @Test
    public void returnArraysOfSameCharStrings() {
        List<String> stringList = Arrays.asList("ron", "nor", "onr", "avi", "avdsdsa", "iva");
        //expected result for "ron", "nor", "onr", "avi", "avdsdsa", "iva" - > [[ron, nor, onr], [avi, iva]]
        List<Set<String>> result = solution(stringList);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private List<Set<String>> solution(List<String> stringList) {
        //use map as key and value original string list<String>
        Map<Map<Integer, Integer>, Set<String>> mainMap = new HashMap<>();
        for (String s : stringList) {
            Map<Integer, Integer> map = getMap(s);
            Set<String> strings = mainMap.get(map);
            if (strings == null) {
                strings = new HashSet<>();
            }
            strings.add(s);
            mainMap.put(map, strings);
        }

        List<Set<String>> result = new ArrayList<>();
        for (Map.Entry<Map<Integer, Integer>, Set<String>> mapListEntry : mainMap.entrySet()) {
            if (mapListEntry.getValue().size() > 1) { //add only if duplicated
                Set<String> inner = new HashSet<>();
                inner.addAll(mapListEntry.getValue());
                result.add(inner);
            }
        }
        return result;
    }

    private boolean checkIfTwoStringAreSameChars(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        Map<Integer, Integer> map1 = getMap(str1);
        Map<Integer, Integer> map2 = getMap(str2);

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer str2Count = map2.get(key);
            if (!entry.getValue().equals(str2Count))
                return false;
        }

        return true;
    }

    //memory optimization
    // TODO use one map: reduce map count from map1 and if map1 is empty= return true else - return false.
    private boolean checkIfTwoStringAreSameCharsUsingOneMap(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        Map<Integer, Integer> map = getMap(s1);
        for (int charValue : s2.toCharArray()) {
            Integer instanceCount = map.get(charValue);
            if (instanceCount == null)
                return false;
            if (instanceCount == 1) {
                map.remove(charValue);
            } else {
                map.put(charValue, instanceCount - 1);
            }
        }

        return map.isEmpty();

//        return map.entrySet().stream()
//                .parallel()
//                .filter(e -> e.getValue() > 0)
//                .count() == 0;
    }

    private Map<Integer, Integer> getMap(String s2) {
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int charValue : s2.toCharArray()) {
            Integer instanceCount = map2.get(charValue);
            if (instanceCount == null) {
                map2.put(charValue, 1);
            } else {
                map2.put(charValue, instanceCount + 1);
            }
        }
        return map2;
    }
}
