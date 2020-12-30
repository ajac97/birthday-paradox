package com.company;

import java.util.*;

public class MonteCarlo {
    public static void main(String[] args) {
        System.out.println(monteCarlo(23));
        System.out.println(monteCarlo(70));
        System.out.println(monteCarlo(366));
        System.out.println(checkNinetyPercent());

    }

    public static double monteCarlo(int people) {
        double duplicates = 0;
        Random rand = new Random();
        ArrayList<Integer> birthdays = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            birthdays.clear();
            for (int j = 0; j < people; j++) {
                int birthday = 1 + rand.nextInt(365);
                birthdays.add(birthday);

            }

            if (numberOfDuplicates(birthdays)) {
                duplicates++;
            }


        }

        return duplicates / 100;
    }

    public static boolean numberOfDuplicates(List<Integer> list) {
        Set<Integer> birthdays = new HashSet<>(list);
        return list.size() != birthdays.size();
    }


    public static int checkNinetyPercent() {
        int people = 0;
        double duplicates = 0;
        while (duplicates < 90) {
            people++;
            duplicates = monteCarlo(people);
        }
        return people;

    }
}