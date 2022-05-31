package com.company;

import com.company.customExceptions.IncorrectArgumentException;
import com.company.customExceptions.NegativeInputException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder countOf = new StringBuilder();
        StringBuilder capacity = new StringBuilder();
        char[] arr = s.toCharArray();
        boolean flag = false;
        for (char c : arr) {
            if (String.valueOf(c).equals(" ")) {
                flag = true;
            } else if (!flag) {
                countOf.append(c);
            } else {
                capacity.append(c);
            }
        }

        int countOfSetGet = Integer.parseInt(countOf.toString());
        int cp = Integer.parseInt(capacity.toString());
        if (countOfSetGet < 0 || cp < 0) {
            scanner.close();
            throw new NegativeInputException("Your argument " + countOfSetGet + " is negative");
        }
        LRUCache l = new LRUCache(cp);

        for (int i = 0; i < countOfSetGet; i++) {
            String str = scanner.nextLine();
            StringBuilder setGet = new StringBuilder();
            StringBuilder key = new StringBuilder();
            StringBuilder value = new StringBuilder();
            char[] array = str.toCharArray();
            boolean flag1 = false;
            boolean flag2 = false;
            for (char c : array) {
                boolean equals = String.valueOf(c).equals(" ");
                if (equals && !flag1) {
                    flag1 = true;
                } else if (!flag1) {
                    setGet.append(c);
                } else if (equals && !flag2) {
                    flag2 = true;
                } else if (!flag2) {
                    key.append(c);
                } else {
                    value.append(c);
                }

            }

            if (key.toString().equals("")) {
                throw new IncorrectArgumentException("Your argument is incorrect");
            }
            int realKey = Integer.parseInt(key.toString());
            int realValue = -1;
            if (!value.toString().equals("")) {
                realValue = Integer.parseInt(value.toString());
            }

            if (setGet.toString().equals("set")) {
                l.set(realKey, realValue);
            } else if (setGet.toString().equals("get")) {
                System.out.println(l.get(realKey));
            } else {
                scanner.close();
                throw new IncorrectArgumentException("Your argment " + setGet + " is incorrect. It should be set or get");
            }
        }
        scanner.close();
        l.printNodes();
    }
}
