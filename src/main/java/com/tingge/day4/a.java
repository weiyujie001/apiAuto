package com.tingge.day4;

import java.util.ArrayList;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
//        Scanner sacan = new Scanner(System.in);
//        String next = sacan.next();
//        System.out.println(next);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list1.addAll(list1);
        for (Integer integer : list1) {
            System.out.println(integer);
        }

    }
}
