package com.example.ProgettoCasotto.models;

import com.example.ProgettoCasotto.services.Attrezatura;
import com.example.ProgettoCasotto.services.Orario;

import java.util.ArrayList;
import java.util.List;

public class Posto {
    private final String qr;
    private final Integer capienza;
    private String persona;
    private List<Attrezatura> attrezature=new ArrayList<>();
    private Orario tempo_prenotazione;
    private Integer giorni_prenotazione;


    public Posto(String qr, Integer capienza,
     String persona, List<Attrezatura> attrezature,Orario tempo_prenotazione,Integer giorni_prenotazione){
        this.qr=qr; this.capienza=capienza; this.persona=persona;
        this.attrezature=attrezature;this.tempo_prenotazione=tempo_prenotazione;
        this.giorni_prenotazione=giorni_prenotazione;
    }

    public Posto(String qr, Integer capienza){
        this.qr=qr; this.capienza=capienza;
    }



    public Boolean isPrenotato(){
        return persona.equals("Free");
    }

    public String getQr(){
        return qr;
    }

    public Integer getCapienza(){
        return capienza;
    }

    public String getPersona(){
        return persona;
    }

    public List<Attrezatura> getAttrezature(){
        return attrezature;
    }

    public Orario getTempo_prenotazione(){
        return tempo_prenotazione;
    }

    public Integer getGiorni_prenotazione(){
        return giorni_prenotazione;
    }

    public void occupaPosto(String persona,List<Attrezatura> attrezature,Orario tempo_prenotazione,
                            Integer giorni_prenotazione){
        this.persona=persona;
        this.attrezature=attrezature;
        this.tempo_prenotazione=tempo_prenotazione;
        if (tempo_prenotazione.equals(Orario.GIORNI_CONSECUTIVI)){
            this.giorni_prenotazione=giorni_prenotazione;
        }

    }

    public void LiberaPosto(){
        this.persona="Free";
        this.attrezature=null;
        this.tempo_prenotazione=null;
        this.giorni_prenotazione=null;
    }


    @Override
    public String toString() {
        return "stats{" +
                "qr='" + qr + '\'' +
                ", capienza=" + capienza +
                ", persona='" + persona + '\'' +
                ", attrezature=" + attrezature +
                ", tempo_prenotazione=" + tempo_prenotazione +
                ", giorni_prenotazione=" + giorni_prenotazione +
                '}';
    }
}
