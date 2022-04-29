package com.example.ProgettoCasotto.models;

import com.example.ProgettoCasotto.services.Attrezatura;
import com.example.ProgettoCasotto.services.Orario;

import java.util.ArrayList;
import java.util.List;


public class Posto {
    private  String qr;
    private  Integer capienza;
    private String persona;
    private List<Attrezatura> attrezature=new ArrayList<>();
    private Orario tempo_prenotazione;
    private Integer giorni_prenotazione;


    /****************************************************/

    public Posto(String qr, Integer capienza,
     String persona, List<Attrezatura> attrezature,Orario tempo_prenotazione,Integer giorni_prenotazione){
        this.qr=qr;
        this.capienza=capienza;
        this.persona=persona;
        this.attrezature=attrezature;
        this.tempo_prenotazione=tempo_prenotazione;
        this.giorni_prenotazione=giorni_prenotazione;
    }
/*
    public Posto(String persona, List<Attrezatura> attrezature,Orario tempo_prenotazione,Integer giorni_prenotazione){
        this.qr="aaaaa"; this.capienza=1; this.persona=persona;
        this.attrezature=attrezature;this.tempo_prenotazione=tempo_prenotazione;
        this.giorni_prenotazione=giorni_prenotazione;
    }
*/
    public Posto(String qr, Integer capienza){
        this.qr=qr; this.capienza=capienza;
    }

    public Posto(){}




    /****************************************************/


    public Boolean isPrenotato(){
        return persona.equals("Free");
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

    /****************************************************/

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public Integer getCapienza() {
        return capienza;
    }

    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public List<Attrezatura> getAttrezature() {
        return attrezature;
    }

    public void setAttrezature(List<Attrezatura> attrezature) {
        this.attrezature = attrezature;
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

    @Override
    public String toString() {
        return "Posto{" +
                "qr='" + qr + '\'' +
                ", capienza=" + capienza +
                ", persona='" + persona + '\'' +
                ", attrezature=" + attrezature +
                ", tempo_prenotazione=" + tempo_prenotazione +
                ", giorni_prenotazione=" + giorni_prenotazione +
                '}';
    }
}
