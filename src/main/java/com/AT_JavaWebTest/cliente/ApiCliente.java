package com.AT_JavaWebTest.cliente;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCliente
{

    public static String sendPost(String endpoint, String jsonPayload) throws IOException
    {
        HttpURLConnection connection = (HttpURLConnection) new URL(endpoint).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);


        try (OutputStream output = connection.getOutputStream())
        {
            output.write(jsonPayload.getBytes());
            output.flush();
        }

        int status = connection.getResponseCode();
        String response = readResponse(connection);
        System.out.println("POST Status: " + status);


        return response;
    }

    public static String sendGet(String endpoint) throws IOException
    {
        HttpURLConnection connection = (HttpURLConnection) new URL(endpoint).openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();
        String response = readResponse(connection);
        System.out.println("GET Status: " + status);


        return response;
    }

    private static String readResponse(HttpURLConnection connection) throws IOException
    {
        InputStream input = (connection.getResponseCode() >= 400)
                ? connection.getErrorStream()
                : connection.getInputStream();

        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
        String inputLine;
        StringBuilder responseBuilder = new StringBuilder();

        while ((inputLine = buffer.readLine()) != null)
        {
            responseBuilder.append(inputLine);
        }

        buffer.close();

        return responseBuilder.toString();
    }




}
