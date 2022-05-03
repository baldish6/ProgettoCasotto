package com.example.ProgettoCasotto.services;

import com.example.ProgettoCasotto.models.OccupatoPosto;
import com.example.ProgettoCasotto.models.LiberoPosto;
import com.example.ProgettoCasotto.services.Attrezatura;
import com.example.ProgettoCasotto.services.Orario;
import com.example.ProgettoCasotto.util.DettagliPosto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class Spiaggia {


    private ArrayList<LiberoPosto> posti_liberi=new ArrayList<>();
    private ArrayList<OccupatoPosto> posti_occupati=new ArrayList<>();
    private List<DettagliPosto> stato_spiaggia = new ArrayList<>();

    @PostConstruct
    public void RiempiTable() throws IOException {
        RiempiPostiLiberi();
        RiempiPostiOccupati();
    }

    public List<LiberoPosto> getPostCap(int i){
        return posti_liberi.stream()
                .filter(x->x.getCapienza()>i-1)
                .collect(Collectors.toList());
    }

    public LiberoPosto getPostobyID(String id){
        return posti_liberi.stream().filter(x->x.getQr().equals(id)).findFirst().orElse(null);
    }

    //TODO add comanda
    public void partecipa_posto(OccupatoPosto ps) {
        posti_liberi.remove(posti_liberi.stream()
                .filter(x -> x.getQr().equals(ps.getQr()))
                .findFirst().orElse(null));
        posti_occupati.add(ps);


    }


    private void RiempiPostiLiberi() throws IOException {


        String path = "C:\\Users\\Baldish Singh\\Downloads\\Compressed\\ProgettoCasotto\\src\\main\\java\\com\\example\\ProgettoCasotto\\dao\\posti_db.csv";
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
            if (!record.get(0).equals("qr")){

                String qr = record.get(0);
                Integer capienza = Integer.valueOf(record.get(1));

                LiberoPosto dp = new LiberoPosto(qr,capienza);
                posti_liberi.add(dp);
            }
        }
    }//

    private void RiempiPostiOccupati() throws IOException{
        String path = "C:\\Users\\Baldish Singh\\Downloads\\Compressed\\ProgettoCasotto\\src\\main\\java\\com\\example\\ProgettoCasotto\\dao\\posti_occupati_db.csv";
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
            if (!record.get(0).equals("qr")){
                String qr = record.get(0);
                Integer capienza = Integer.valueOf(record.get(1));
                String persona = record.get(2);

                List<Attrezatura> attrezature = Arrays.stream(record.get(3)
                                .split("/"))
                        .map(x -> x.replace(" ", ""))
                        .map(Attrezatura::valueOf).toList();

                Orario tempo_prenotazione = Orario.valueOf(record.get(4));
                int giorni_prenotazione = 0;
                if (tempo_prenotazione.equals(Orario.GIORNI_CONSECUTIVI)){
                    giorni_prenotazione = Integer.parseInt(record.get(5));}

                OccupatoPosto dp = new OccupatoPosto(qr,capienza,persona,attrezature,tempo_prenotazione,giorni_prenotazione);
                posti_occupati.add(dp);}
        }
    }


    public List<DettagliPosto> getDettagli(){

     //   if (stato_spiaggia.isEmpty()){
            Iterator<LiberoPosto> pli = posti_liberi.iterator();
            LiberoPosto libp;
            while (pli.hasNext()){
                libp =  pli.next();
                DettagliPosto dp = new DettagliPosto(libp.getQr(),libp.getCapienza());
                stato_spiaggia.add(dp);
            }

            Iterator<OccupatoPosto> ocp = posti_occupati.iterator();
            OccupatoPosto pps;
            while (ocp.hasNext()){
                pps = ocp.next();
                DettagliPosto dp = new DettagliPosto(pps.getQr(), pps.getCapienza(), pps.getPersona(),
                        pps.getAttrezature(),pps.getTempo_prenotazione(),pps.getGiorni_prenotazione());
                stato_spiaggia.add(dp);
            }

            long seed = 25L;
            Collections.shuffle(stato_spiaggia,new Random(seed));
    //    }
        return stato_spiaggia;
    }


    public void LiberaPosto(OccupatoPosto ps){
        posti_liberi.add(new LiberoPosto(ps.getQr(), ps.getCapienza()));

        posti_occupati.remove(posti_occupati.stream()
                .filter(x -> x.getQr().equals(ps.getQr()))
                .findFirst().orElse(null));

    }

}
