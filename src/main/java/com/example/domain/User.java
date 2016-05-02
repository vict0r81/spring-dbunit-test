package com.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table(name = "USERS")
@Data @EqualsAndHashCode(of = {"id"})
public class User implements Serializable {

    private static final long serialVersionUID = 6850643513268892032L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @Column String password;
    private @Embedded Person person;

}
