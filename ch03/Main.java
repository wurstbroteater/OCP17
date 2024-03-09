package ch03;
import java.util.ArrayList;
import java.util.List;

import util.Util;

import static util.Util.print;

public class Main {
    enum STATS {FOO, BAR};
    public static void main(String[] args) {
        List<Number> ns = List.of((byte)1, (short) 2, 3L, 4.0, 5.0f);
        ns.forEach(n -> {
            if (n instanceof Byte b) {
                print("Byte " + b);
            } else if (n instanceof Short s) {
                print("Short " + s);
            } else if(n instanceof Integer i) {
                print("Integer " + i);
            } else if (n instanceof Long l) {
                print("Long " + l);
            } else if (n instanceof Double d) {
                print("Double " + d);
            } else if (n instanceof Float f){
                print("Float "+ f);
            } else {
                print("Strange n: " +n);
            }
        }); 

        List.of(STATS.FOO, STATS.BAR).stream().map(s -> switch (s) {
            case FOO -> "cool";
            case BAR -> "hot";
            //default optional as all cases are covered<
        }).forEach(Util::print);

        String v1 = "foo";
        int v2 = 3;
        if (v2 >= 3)        
        if ("bar".equals(v1)) print("hi");
        else print("bye");
        else print("tschö");
        x: for(int i = 0; i < 3; i++) {
           $Y: for(int j = 0; j < 3; j++) {
                if(j > i && i % j == 0) {
                    break x;
                } else {
                    continue $Y;
                }
            }
        }

        var l1 = List.of(1,2,3);
        for(var l : l1) {
            System.out.print(l);
        }
        print("");
        for(var x: new int[2]) {
            System.out.print(x);
        }
        for(var x: new ArrayList<Integer>()) {
            System.out.print(x);
        }
        print("");
        var l2 = new Character[2];
        for(var x: l2) {
            System.out.print(x);
        }
        print("");
    }
}
