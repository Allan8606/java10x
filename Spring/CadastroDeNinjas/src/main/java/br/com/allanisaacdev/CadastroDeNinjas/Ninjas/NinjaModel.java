package br.com.allanisaacdev.CadastroDeNinjas.Ninjas;


import br.com.allanisaacdev.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String email;

    private  int idade;

    // Um ninja tem apenas uma unica missão.
    @ManyToMany
    @JoinColumn(name = "missoes_id")//Chave estrangeira. Esse nome fomos nós que escolhemos.
    private MissoesModel missoes;



}
