package ru.atikhonov;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static boolean isLeap(short year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) return true;
        else return false;
    }

    public static void suggestVersion(byte typeOS, short deviceYear) {
        if (typeOS == 1 && deviceYear >= LocalDate.now().getYear()) System.out.println("Установите версию приложения для Android по ссылке");
            else if (typeOS == 1 && deviceYear < LocalDate.now().getYear()) System.out.println("Установите облегченную версию приложения для Android по ссылке");
        if (typeOS == 0 && deviceYear >= LocalDate.now().getYear()) System.out.println("Установите версию приложения для iOS по ссылке");
            else if (typeOS == 0 && deviceYear < LocalDate.now().getYear()) System.out.println("Установите облегченную версию приложения для iOS по ссылке");
    }

    public static short calcDeliveryDays(short deliveryDistance) {
        short deliveryDays = 1;
        if (deliveryDistance >= 20 && deliveryDistance < 60) deliveryDays += 1;
            else if (deliveryDistance >= 60 && deliveryDistance <= 100) deliveryDays += 2;
        return deliveryDays;
    }

    public static void checkForDoubles(String stringToCheck) {
        for (int i = 1; i < stringToCheck.length(); i++) {
            if (stringToCheck.charAt(i) == stringToCheck.charAt(i - 1)) {
                System.out.println("Присутствует дубль символа '" + stringToCheck.charAt(i) + "'");
                return;
            }
        }
        System.out.println("В строке дублей нет");
    }

    public static void reverseArray(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static void calcMonthlyAverage(int[] arr) {
        printAverage(calcAverage(calcSumOfElements(arr), arr.length));
    }

    public static int calcSumOfElements(int[] arr) {
        int sumOfElements = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfElements += arr[i];
        }
        return sumOfElements;
    }

    public static float calcAverage(int sumOfElements, int numberOfElements) {
        return (float)sumOfElements/numberOfElements;
    }

    public static void printAverage(float averageNumber) {
        System.out.println("Средняя сумма трат за месяц составила " +
                new DecimalFormat("###,###.##").format(averageNumber) +
                " рублей.");
    }

    public static void main(String[] args) {
        //Задание 1
        short year = 3308;
        if (isLeap(year)) System.out.println(year + " год является високосным");
            else System.out.println(year + " год не является високосным");
        //Задание 2
        byte clientOS = 0;
        short deviceYear = 2022;
        suggestVersion(clientOS, deviceYear);
        //Задание 3
        short deliveryDistance = 60;
        System.out.println("Потребуется дней: " + calcDeliveryDays(deliveryDistance));
        //Задание 4
        String stringToCheck = "abcdeef";
        checkForDoubles(stringToCheck);
        //Задание 5
        int[] arr = {3, 2, 1, 6, 5};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
        //Задание 6
        calcMonthlyAverage(generateRandomArray());
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
