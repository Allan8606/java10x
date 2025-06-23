package Intermediario;

import java.util.ArrayList;
import java.util.List;

public class BolsaDeHabilidades<T> {

    private List<T> habilidades;


    //Colocando habilidades
    public void adicionarHabilidades(T habilidadeGenercia) {
        habilidades.add(habilidadeGenercia);

    }


    //Construtor
    public BolsaDeHabilidades() {
        this.habilidades = new ArrayList<>();
    }

    //getters e setters

    public List<T> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<T> habilidades) {
        this.habilidades = habilidades;
    }

    //toString

    @Override
    public String toString() {
        return "Bolsa de Habilidadades : " + habilidades.toString();
    }
}
