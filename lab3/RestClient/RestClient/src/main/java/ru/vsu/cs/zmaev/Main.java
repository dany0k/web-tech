package ru.vsu.cs.zmaev;

import ru.vsu.cs.zmaev.web.RestClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Runnable run = () -> {
            try {
                RestClient client = new RestClient();
                int count = 100;
                for (int i = 0; i < count; i++) {
                    client.post();
                }
                client.closeClient();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread(run, "thread" + (i + 1));
            thread.start();
        }
    }
}