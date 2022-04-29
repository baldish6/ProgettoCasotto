package com.example.ProgettoCasotto.api;

import com.example.ProgettoCasotto.models.Posto;
import com.example.ProgettoCasotto.services.Attrezatura;
import com.example.ProgettoCasotto.services.Orario;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootApplication
public class PostoDatiMg {

    private List<Posto> temp_posti = new ArrayList<>();

    @PostConstruct
    public void RiempiTable() throws IOException {
        String path = "C:\\Users\\Baldish Singh\\Downloads\\Compressed\\ProgettoCasotto\\src\\main\\java\\com\\example\\ProgettoCasotto\\dao\\posti_db.csv";
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
            if (!record.get(0).equals("qr")){

                String qr = record.get(0);
                Integer capienza = Integer.valueOf(record.get(1));

                String persona = null;
                List<Attrezatura> attrezature = null;
                Integer giorni_prenotazione = null;
                Orario tempo_prenotazione = null;

                if (!record.get(2).equals("null")){
                    persona = record.get(2);
                    if (!record.get(3).equals("null")){
                        attrezature = Arrays.stream(record.get(3)
                                .split("/"))
                                .map(x->x.replace(" ",""))
                                .map(Attrezatura::valueOf)
                                .collect(Collectors.toList());
                    }
                    tempo_prenotazione = Orario.valueOf(record.get(4));
                    if (tempo_prenotazione.equals(Orario.GIORNI_CONSECUTIVI)){
                    giorni_prenotazione = Integer.valueOf(record.get(5));}
                    else {giorni_prenotazione=0;}
                }

                Posto ps = new Posto(qr,capienza,persona,attrezature,tempo_prenotazione,giorni_prenotazione);
                temp_posti.add(ps);}
            }
    }

    public List<Posto> getPosti() {
        return temp_posti;
    }

    public List<Posto> getPostCap(int i){
        return temp_posti.stream()
                .filter(x-> x.getPersona() == null)
                .filter(x->x.getCapienza()>i-1)
                .collect(Collectors.toList());
    }

    public Posto getPostobyID(String id){
        return temp_posti.stream().filter(x->x.getQr().equals(id)).findFirst().orElse(null);
    }

    public void update_posto(Posto ps) {
        int idx = temp_posti.indexOf(
                temp_posti.stream()
                        .filter(x->x.getQr().equals(ps.getQr()))
                        .findFirst().orElse(null));
       temp_posti.set(idx,ps);
    }
}
