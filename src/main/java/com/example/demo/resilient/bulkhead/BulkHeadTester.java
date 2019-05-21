/*
 * Copyright 2019 Rudy De Busscher (Payara Services)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo.resilient.bulkhead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BulkHeadTester {

    public static void main(String[] args) {
        int number = 4;

        for (int i = 0; i < number; i++) {
            new Thread(new CallRest(i)).start();
        }
    }

    private static class CallRest implements Runnable {

        private int id;

        public CallRest(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            try {
                URL target = new URL("http://localhost:8080/microprofile/data/bulk/slow");
                HttpURLConnection con = (HttpURLConnection) target.openConnection();

                // optional default is GET
                con.setRequestMethod("GET");

                //int responseCode = con.getResponseCode();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                System.out.println(String.format("Id : %s - Result : %s", id, response.toString()));
            } catch (IOException e) {
                System.out.println("Exception for id" + id);
                e.printStackTrace();  // Demo Code
            }

        }

    }
}
