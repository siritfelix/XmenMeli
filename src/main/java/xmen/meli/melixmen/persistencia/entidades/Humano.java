package xmen.meli.melixmen.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Humano implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String[] dna;
    private Boolean mutante;

    public Humano() {
        
    }

    public Humano(Integer id, String[] dna, Boolean mutante) {
        this.id = id;
        this.dna = dna;
        this.mutante = mutante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public Boolean getMutante() {
        return mutante;
    }

    public void setMutante(Boolean mutante) {
        this.mutante = mutante;
    }

}