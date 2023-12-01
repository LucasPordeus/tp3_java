package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class NonaQuestao {
    public static void main(String[] args) throws IOException {
        URL urlObj = new URL("http://universities.hipolabs.com/search?country=Brazil");
        HttpURLConnection conexao = (HttpURLConnection) urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int responseCode = conexao.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            ObjectMapper objectMapper = new ObjectMapper();
            List<Universidade> universidades = objectMapper.readValue(response.toString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Universidade.class));

            for (Universidade universidade : universidades) {
                System.out.println("Nome: " + universidade.getName());
                System.out.println("Web Pages: " + universidade.getWeb_pages());
                System.out.println();
            }
        } else {
            System.out.println("GET request not worked");
        }
    }
}
