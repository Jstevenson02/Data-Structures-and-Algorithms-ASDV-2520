/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.javatest;

/**
 *
 * @author jacob
 */
public class Palindrome {

    public static boolean palindromeR(String s) {
        return palindromeHelper(s, 0, s.length() - 1);
    }

    public static boolean palindromeHelper(String s, int i, int j) {
        if (i > j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        } else {
            return palindromeHelper(s, ++i, --j);
        }
    }

    public static boolean palindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("mom");
        System.out.println("momma");
    }
}
