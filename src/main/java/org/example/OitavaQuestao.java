package org.example;

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
public class OitavaQuestao {
    public static void main(String[] args) throws IOException {
        URL urlObj = new URL("http://universities.hipolabs.com/search?country=Brazil");
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

            JSONArray jsonArray = new JSONArray(response.toString());

            List<Universidade> universidades = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonUniversidade = jsonArray.getJSONObject(i);

                String nome = jsonUniversidade.getString("name");

                JSONArray webPagesArray = jsonUniversidade.getJSONArray("web_pages");

                List<String> webPagesList = new ArrayList<>();
                for (int j = 0; j < webPagesArray.length(); j++) {
                    webPagesList.add(webPagesArray.getString(j));
                }

                Universidade universidade = new Universidade(nome, webPagesList);
                universidades.add(universidade);
            }

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