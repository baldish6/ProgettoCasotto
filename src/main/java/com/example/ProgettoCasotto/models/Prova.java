package com.example.ProgettoCasotto.models;


import com.example.ProgettoCasotto.services.Attrezatura;
import com.example.ProgettoCasotto.services.Orario;

import java.util.ArrayList;
import java.util.List;

public class Prova {
    private Integer id;
    private String nome;
    private String random;
    private Orario tempo_prenotazione;
    private Integer giorni_prenotazione;
    private List<Attrezatura> attrezature=new ArrayList<>();

    /*
    private final String qr;
    private final Integer capienza;
    private String persona;
    private List<Attrezatura> attrezature=new ArrayList<>();
    private Orario tempo_prenotazione;
    private Integer giorni_prenotazione;*/

    public Prova(){}

    public Prova(Integer id, String nome, String random,Orario tempo_prenotazione,Integer giorni_prenotazione,
                 List<Attrezatura> attrezature){
        this.id=id;
        this.nome=nome;
        this.random=random;
        this.tempo_prenotazione=tempo_prenotazione;
        this.giorni_prenotazione=giorni_prenotazione;
        this.attrezature=attrezature;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void setRandom(String random) {
        this.random = random;
    }

    public String getRandom() {
        return random;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Orario getTempo_prenotazione() {
        return tempo_prenotazione;
    }

    public void setTempo_prenotazione(Orario tempo_prenotazione) {
        this.tempo_prenotazione = tempo_prenotazione;
    }


    public Integer getGiorni_prenotazione() {
        return giorni_prenotazione;
    }

    public void setGiorni_prenotazione(Integer giorni_prenotazione) {
        this.giorni_prenotazione = giorni_prenotazione;
    }


    public List<Attrezatura> getAttrezature() {
        return attrezature;
    }

    public void setAttrezature(List<Attrezatura> attrezature) {
        this.attrezature = attrezature;
    }


    @Override
    public String toString() {
        return "Prova{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", random='" + random + '\'' +
                ", tempo_prenotazione=" + tempo_prenotazione +
                ", giorni_prenotazione=" + giorni_prenotazione +
                ", attrezature=" + attrezature +
                '}';
    }
}
