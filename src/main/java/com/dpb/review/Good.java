package com.dpb.review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Good {

    private Map<String, List<Object[]>> map = new HashMap<>();

    public boolean add(String key1, String value) {
        List<Object[]> list = map.computeIfAbsent(key1, v -> new ArrayList<>());
        return list.add(new Object[]{value, value.length()});
    }

    public int statistics(String v) {
        return map.values().stream().mapToInt(l -> l.stream().filter(o -> v.equals(o[0]))
                                    .mapToInt(o -> (int)o[1]).sum())
                                    .sum();
    }

    public static void main(String[] args) {
        final Good good = new Good();
        good.add("hello", "world");
        good.add("hello", "world");
        good.add("hello", "welt");
        good.add("there", "world");
        good.add("what is wrong", "with this code");
        if(args.length==0) {
            System.out.println("Good has" + good.statistics("world") + "for world");
        }else {
            System.out.println("Good has" + good.statistics(args[0]) + "for " + args[0]);
        }
    }
}
