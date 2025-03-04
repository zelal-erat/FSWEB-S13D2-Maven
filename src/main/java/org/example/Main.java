package org.example;

public class Main {
    public static void main(String[] args) {
        // Palindrom Sayı Testleri
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false

        // Mükemmel Sayı Testleri
        System.out.println(isPerfectNumber(6));  // true
        System.out.println(isPerfectNumber(28)); // true
        System.out.println(isPerfectNumber(5));  // false
        System.out.println(isPerfectNumber(-1)); // false

        // Sayıları Kelimelere Dökme Testleri
        numberToWords(123);   // One Two Three
        numberToWords(1010);  // One Zero One Zero
        numberToWords(-12);   // Invalid Value
    }

    // Palindrom Sayıyı Kontrol Eden Metod
    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        number = Math.abs(number); // Negatifleri pozitife çevir

        int reversed = 0;
        int temp = number;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversed = (reversed * 10) + lastDigit;
            temp /= 10;
        }

        return reversed == Math.abs(originalNumber);
    }

    // Mükemmel Sayıyı Kontrol Eden Metod
    public static boolean isPerfectNumber(int number) {
        if (number < 1) return false;

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    // Sayıları Kelimelere Çeviren Metod
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String numberStr = String.valueOf(number);

        StringBuilder result = new StringBuilder();
        for (char digit : numberStr.toCharArray()) {
            result.append(words[digit - '0']).append(" ");
        }

        return result.toString().trim();
    }

}
