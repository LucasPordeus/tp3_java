package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resposta {

    private String jsonResponse;

    @Override
    public String toString() {
        return "Resposta{"
                 + jsonResponse + '\'' +
                '}';
    }
}
