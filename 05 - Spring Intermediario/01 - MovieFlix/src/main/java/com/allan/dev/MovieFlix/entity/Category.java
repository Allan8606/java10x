package com.allan.dev.MovieFlix.entity;


import jakarta.persistence.*;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Digo que a coluna name vai ter o tamanho de 100 caracteres e não pode ser nula, sendo obrigatória.
    @Column(length = 100, nullable = false)
    private String name;




}
