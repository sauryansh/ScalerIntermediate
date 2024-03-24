package com.day20string;

public class ToggleState {
    public static void main(String[] args) {
        ToggleState toggleState = new ToggleState();
        System.out.println(toggleState.solve("aAbBcC"));
    }

    public String solve(String s) {
        char[] chars = s.toCharArray();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            chars[i] = toggle(chars[i]);
        }
        return new String(chars);
    }

    private char toggle(char c) {
        char result = c;
        if (c >= 65 && c <= 90) {
            result = (char) (c + 32);
        } else if (c >= 97 && c <= 122) {
            result = (char) (c - 32);
        }
        return result;
    }
}
