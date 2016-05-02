package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = -6298788221245663927L;

    private @Column String name;
    private @Column String surname;

}
