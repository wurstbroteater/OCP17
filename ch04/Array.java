package ch04;
import static util.Util.print;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        print("--- ArrayStoreException ---");
        try {
            String[] strings = {"aValue"};
            Object[] objects = strings;
            String[] stringsAgain = (String[]) objects;
            //compiles but throws ArrayStoreException on runtime
            objects[0] = new StringBuilder();
        } catch (ArrayStoreException e ) {
            print("ArrayStoreException was thrown!");
        } finally {
            print();
        }

        print("--- Binary Search ---");
        int[] numbers = {2,4,6,8};
        print(Arrays.binarySearch(numbers, 2)); // 0
        print(Arrays.binarySearch(numbers, 4)); // 1
        // 1 should be BEFORE value 2, ie., before index 0. -> -0 -1 = -1 
        print(Arrays.binarySearch(numbers, 1)); 
        // 3 should be BEFORE value 4, ie., before index 1. -1 -1 = -2
        print(Arrays.binarySearch(numbers, 3)); 
        // 9 should be AFTER value 8, ie., after index 3 which is 4. -> -4 -1 = -5
        print(Arrays.binarySearch(numbers, 9)); 
        print();

        print("--- Comparing Arrays ---");
        char[] s1 = {'a'};
        print(s1.equals(new char[] {'a'})); //false because reference
        print("equals:", Arrays.compare(s1, new char[] {'a'})); // 0
        //A = 65, a= 97 (65 + 32)
        print("a ? A:", Arrays.compare(new char[]{'a'}, new char[]{'A'})); // 97 - 65 = 32
        print("a ? null", Arrays.compare(new String[]{"a"}, new String[]{null})); // positive because null always smaller (??always 1 or -1??) 
        print("a ? a, b", Arrays.compare(new char[]{'a'}, new char[]{'a', 'b'})); // -1 size differ: how many elements the first array is smaller
        print();

        //mismatch -1 in good case. If left array smaller than 0; if larger than #elemes how larger; If same size than compare both elemnts
        print("a mis a", Arrays.mismatch(s1, new char[] {'a'})); // -1 same data
        print("a mis A", Arrays.compare(new char[]{'B'}, new char[]{'b'})); // |66 - 98| = 32  compare both elements
        print("a mis null", Arrays.compare(new String[]{"a"}, new String[]{null})); // 1 null always smaller
        print("a,c mis a,b", Arrays.compare(new char[]{'a', 'c'}, new char[]{'a', 'b'})); // |99 - 98| = 1 compare both elemnts
        print("a,b,c mis a,b,d", Arrays.compare(new char[]{'a', 'b', 'c'}, new char[]{'a'})); // 2 size differ: how many items the first one is bigger
        print("a,b,c mis a,b,d", Arrays.compare(new char[]{'a'}, new char[]{'a', 'b', 'c'})); // -2 size differ: how many items the first one is smaller
        print();

        //Mutlidimensinal Arrays init
        int[][] vars1;  //2D
        int vars2 [][]; //2D
        int[] vars3 []; //2D
        int[] vars4 [], vars5 [][]; //2D, 3D
    }
}
