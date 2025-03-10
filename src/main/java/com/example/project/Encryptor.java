package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen % rows != 0 || messageLen == 0) {
            return (messageLen / rows) + 1;
        } else {
            return messageLen / rows;
        }
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        String[][] encrypted = new String[rows][determineColumns(message.length(), rows)];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < determineColumns(message.length(), rows); j++) {
                if (i != rows && idx < message.length()) {
                    encrypted[i][j] = message.substring(idx, idx + 1);
                    idx++;
                } else {
                    if (encrypted[i][j] == null) {
                        encrypted[i][j] = "=";
                        idx++;
                    } else if (idx < message.length()){
                        encrypted[i][j] = message.substring(idx, idx + 1);
                        idx++;
                    }
                }
            }
        }
        return encrypted;
    }

    public static String encryptMessage(String message, int rows){
        String[][] arr = generateEncryptArray(message, rows);
        for (String[] row : arr) {
            for (String s : row) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        String encrypted = "";
        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                encrypted += arr[i][j];
            }
        }
        return encrypted;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        String decrypted = "";
        String[][] arr = new String[rows][encryptedMessage.length() / rows];
        int idx = 0;
        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                arr[i][j] = encryptedMessage.substring(idx, idx + 1);
                idx++;
            }
        }
        for (String[] row : arr) {
            for (String s : row) {
                if (!s.equals("=")) {
                    decrypted += s;
                }
            }
        }
        return decrypted;
    }
}