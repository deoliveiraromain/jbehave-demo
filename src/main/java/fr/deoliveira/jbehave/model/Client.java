package fr.deoliveira.jbehave.model;

import lombok.Getter;
import lombok.Setter;


public class Client {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private int age;

}
