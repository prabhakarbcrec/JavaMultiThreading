package com.java.thread.learing;

public class DynamicPrinting {
    public static void main(String[] args) {
        String inputString = "hello";
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (Character.isLowerCase(currentChar)) {
                // Print the uppercase equivalent of the current character
                System.out.print(Character.toUpperCase(currentChar));
            } else {
                // Print the character as it is
                System.out.print(currentChar);
            }
            // Sleep for a short duration to simulate dynamic printing
            try {
                Thread.sleep(500); // 500 milliseconds pause between characters
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


