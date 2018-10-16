package com.dpb.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bad {
    public HashMap map;

    public boolean add(String key1, String value) {
        boolean b = false;
        try{
            if( map.get(key1) == null) {
                map.put(key1, new ArrayList());
                ((ArrayList) map.get(key1)).add(
                        new Object[] {value, value.length()});
                b = true;
            }
            else {
                ArrayList list = (ArrayList) map.get(key1);
                if (list == null)
                    list = new ArrayList();
                Object[] entry = new Object[2];
                entry[0] = value;
                entry[1] = value.length();
                list.add(entry);
                b = true;
            }
        } catch (Exception e) {
            b = false;
        }
        return b;
    }

    public int statitics(String v) {
        int total_length = 0;
        if (map==null)
            total_length=0 ;
        int num=map.size();
        for (Object key:map.keySet()) {
            String s = (String) key;
            List list=(List) map.get(s);
            for(int i=0; i < list.size(); i++)
            {
                Object[] o = (Object[])list.get(i);
                if(o[1] == v){
                    total_length = total_length + (int) o[0];
                }
            }
        }
        return total_length;
    }

    public static void main(String[] args) {
        final Bad bad = new Bad();
        bad.add("hello", "world");
        bad.add("hello", "world");
        bad.add("hello", "welt");
        bad.add("there", "world");
        bad.add("what is wrong", "with this code");
        if(args.length==0) {
            System.out.println("Bad has" + bad.statitics("world") + "for world");
        }else {
            System.out.println("Bad has" + bad.statitics(args[0]) + "for " + args[0]);
        }
    }
}

