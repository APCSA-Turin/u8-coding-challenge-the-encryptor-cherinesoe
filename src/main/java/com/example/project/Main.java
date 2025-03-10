package com.example.project;

public class Main {
    public static void main(String[] args) {
        String message = Encryptor.encryptMessage("Hello how are you today? it is very nice outside!", 4);
        System.out.println(message);
        System.out.println(Encryptor.decryptMessage(message, 4));
        // for (String[] row : arr) {
        //     for (String s : row) {
        //         System.out.print(s + " ");
        //     }
        //     System.out.println();
        // }
    }
}