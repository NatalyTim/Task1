package ru.timofeeva;

import java.io.File;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        if(args == null || args.length == 0){
            System.out.println("Please add the path to file, when calling the program...");
            return;
        }
        String filePath = args[0];
        List<Integer> numbersArray = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
            for (int i = 0; scanner.hasNextLine(); i++) {
                int x = scanner.nextInt();
                numbersArray.add(i,x);
            }
        } catch (FileNotFoundException e){
            System.out.println("File " + filePath + " not found");
            return;
        }finally {
            if(scanner != null){
                scanner.close();
            }

        }
         Collections.sort(numbersArray);

        System.out.println("90 percentile < " + getPercentile(numbersArray) + " >");
        System.out.println("median < " + getMedian(numbersArray) + " >");
        System.out.println("average < " + getAverage(numbersArray) + " >");
        System.out.println("max < " + getMax(numbersArray) + " >");
        System.out.println("min < " + getMin(numbersArray) + " >");
    }

    private static int getPercentile(List<Integer> list){
        int a = (int)(Math.ceil(90.0 * list.size() / 100.0))-1;
        return list.get(a);
    }
    private static int getMax(List<Integer> list){
        int s = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) >= s){
                s = list.get(i);
            }
        }
        return s;
    }
    private static int getMin (List<Integer> list){
        int d = 0;
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) <= d) {
                d = list.get(i);
            }
        }
        return d;
    }
    private static  double getMedian (List<Integer> list){
        double median;
        int len = list.size();
        if(len%2 != 0){
            median = ((len + 1) / 2)-1;
        } else {
            median = (list.get((len / 2)-1)) + list.get((len / 2 + 1)) / 2;
        }
        return median;
    }
    public  static double getAverage(List<Integer> list){
        int c;
        int len = list.size();
        int sum = 0;
        for (int i = 0; i <list.size(); i++){
            sum += list.get(i);
        }
        c = sum / len;
        return  c;
    }

}


