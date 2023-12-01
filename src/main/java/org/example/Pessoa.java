package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
    private String name;
    private int age;

    public Pessoa(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Nome: " + name + ", Idade: " + age;
    }
}
