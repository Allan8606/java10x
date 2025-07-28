package br.com.allanisaacdev.CadastroDeNinjas.Missoes;


import br.com.allanisaacdev.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //Uma missão vai ter varios ninjas.
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;

}

