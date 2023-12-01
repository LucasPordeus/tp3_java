package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class SextaQuestao {
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


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in .close();

            JSONObject jsonResponse = new JSONObject(response.toString());

            String nomeDaApi = jsonResponse.getString("name");
            int idadeDaApi = jsonResponse.getInt("age");

            Pessoa pessoa = new Pessoa  (nomeDaApi, idadeDaApi);
            System.out.println(pessoa.toString());

        } else {
            System.out.println("GET request not worked");
        }

    }
}