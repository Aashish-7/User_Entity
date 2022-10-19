package com.entity.org.entity.example.random;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomString {

    public String getRandomPassword(int n)
    {
        Random rand = new Random(); //instance of random class
        String total_characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()[]<>{}";
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = rand.nextInt(total_characters.length()-1);
            randomString.append(total_characters.charAt(index));
        }
        return randomString.toString();
    }
}
