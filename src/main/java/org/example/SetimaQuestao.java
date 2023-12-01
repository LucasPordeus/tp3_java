package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SetimaQuestao {
    public static void main(String[] args) throws IOException {
        String nome = "John";
        String apiUrl = "https://api.agify.io/?name=" + nome;

        URL urlObj = new URL(apiUrl);
        HttpURLConnection conexao = (HttpURLConnection)urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int responseCode = conexao.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response.toString());

            String nomeDaApi = jsonResponse.get("name").asText();
            int idadeDaApi = jsonResponse.get("age").asInt();

            Pessoa pessoa = new Pessoa(nomeDaApi, idadeDaApi);

            System.out.println(pessoa.toString());
        } else {
            System.out.println("GET request not worked");
        }

    }
}