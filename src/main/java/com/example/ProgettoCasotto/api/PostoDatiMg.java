package com.example.ProgettoCasotto.api;

import com.example.ProgettoCasotto.models.Posto;
import com.example.ProgettoCasotto.services.Attrezatura;
import com.example.ProgettoCasotto.services.Orario;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class PostoDatiMg {

    //public PostoDatiMg(){}

    private List<Posto> temp_posti = new ArrayList<>();
    private Integer j=5;

    @PostConstruct
    public void RiempiTable() throws IOException {
        //List<Posto> temp_posti = new ArrayList<>();
        Reader in = new FileReader("C:\\Users\\Baldish Singh\\Downloads\\Compressed\\ProgettoCasotto\\src\\main\\java\\com\\example\\ProgettoCasotto\\dao\\PostiDati.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        //System.out.println("prova");
        for (CSVRecord record : records) {
            //qr capineza
            //String qr, Integer capienza,
            //     String persona, List<Attrezatura> attrezature,List<Orario> tempo_prenotazione,Integer giorni_prenotazione
            //String qr = record.get("Qr");
            //Integer capienza = Integer.parseInt(record.get("Capienza"));
            //Posto ps = new Posto(qr,capienza);
            //"Nome","Cognome","Età"
            //temp_posti.add(ps);
            String qr = record.get("Nome");
            System.out.println(qr);
        }
        RiempiamoTabll();
        //System.out.println(temp_posti);

        //posti=temp_posti;
    }

    private void RiempiamoTabll(){


        List< Attrezatura > attr = new ArrayList<>() ;
        attr.add( Attrezatura.OMBRELLONE ) ;  // This person prefers cats over dogs…
        attr.add( Attrezatura.SDRAIO ) ;

        Posto ps = new Posto("uno",3);
        Posto ps1 = new Posto("pp",7,"Mario",attr,Orario.MEZZA_GIORNATA,0);
        Posto ps2 = new Posto("due",4);
        Posto ps3 = new Posto("214",2,"Luca",attr,Orario.GIORNATA_INTERA,0);
        Posto ps4 = new Posto("52",9,"Tom",attr,Orario.GIORNI_CONSECUTIVI,10);
        Posto ps5 = new Posto("2462",1);
        Posto ps6 = new Posto("983",3,"Gatto",attr,Orario.GIORNATA_INTERA,0);
        Posto ps7 = new Posto("19",10,"X",attr,Orario.MEZZA_GIORNATA,0);
        Posto ps8 = new Posto("1294",5,"Anon",attr,Orario.GIORNI_CONSECUTIVI,3);
        Posto ps9 = new Posto("nove",6);
        Posto ps10 = new Posto("124",8,"Ragno",attr,Orario.GIORNI_CONSECUTIVI,6);
        temp_posti.add(ps);
        temp_posti.add(ps1);
        temp_posti.add(ps2);
        temp_posti.add(ps3);
        temp_posti.add(ps4);
        temp_posti.add(ps5);
        temp_posti.add(ps6);
        temp_posti.add(ps7);
        temp_posti.add(ps8);
        temp_posti.add(ps9);
        temp_posti.add(ps10);

        //System.out.println(temp_posti);
    }

    public List<Posto> getPosti() {
        return temp_posti;
    }

    public List<Posto> getPostCap(int i){
        return temp_posti.stream()
                .filter(x->x.getCapienza()>i)
                .collect(Collectors.toList());
    }
}
