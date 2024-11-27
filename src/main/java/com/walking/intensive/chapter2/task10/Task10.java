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
        String text = inputString.toLowerCase();
        Pattern pattern = Pattern.compile("[.,:;!? -]");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll("");

        int length = text.length(), value = 0;

        for (int i = 0; i < length / 2; i++) {
            if (text.charAt(i) == text.charAt(length - 1 - i)) {
                value += 1;
            }
        }
        return value >= length / 2;
    }
}
