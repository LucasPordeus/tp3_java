package org.example;

import org.junit.Test;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.net.URL;

public class DecimaSegundaQuestao {

    @Test
    public void testResponseStatus() {
        try {
            URL urlObj = new URL("http://universities.hipolabs.com/search?country=Brazil");
            HttpURLConnection conexao = (HttpURLConnection) urlObj.openConnection();
            conexao.setRequestMethod("GET");
            int responseCode = conexao.getResponseCode();
            
            assertEquals(200, responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
