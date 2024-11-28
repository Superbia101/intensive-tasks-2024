package com.walking.intensive.chapter2.task10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
//        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        // Регулярные выражения.
        // Я их немного знаю по другому языку, погуглил реализацию на Java
        String palindrome = inputString.toLowerCase();
        Pattern pattern = Pattern.compile("[.,:;!? -]");
        Matcher matcher = pattern.matcher(palindrome);
        palindrome = matcher.replaceAll("");

        int lengthPalindrome = palindrome.length(), letterMatches = 0;

        for (int i = 0; i < lengthPalindrome / 2; i++) {
            if (palindrome.charAt(i) == palindrome.charAt(lengthPalindrome - 1 - i)) {
                letterMatches += 1;
            }
        }
        return letterMatches >= lengthPalindrome / 2;
    }
}
