package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Universidade {
    @JsonProperty("name")
    private String name;
    @JsonProperty("web_pages")
    private List<String> web_pages;

    public Universidade() {
    }
    public Universidade (String name, List<String> web_pages) {
        this.name = name;
        this.web_pages = web_pages;
    }

}