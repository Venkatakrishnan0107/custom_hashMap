package com.practice;

public class Main {

    public static void main(String[] args) {

        CustomHashMap<String,String> hashMap = new CustomHashMap<>();
        hashMap.put("venkat","citi");
        System.out.println(hashMap.get("venkat"));
        hashMap.put("venkat","tcs");
        System.out.println(hashMap.get("venkat"));
        hashMap.put("ventak","ibm");
        System.out.println(hashMap.get("ventak"));
        hashMap.put("harika","wipro");
        hashMap.put("heena","tcs");

        System.out.println("Size..."+hashMap.size());
    }
}
