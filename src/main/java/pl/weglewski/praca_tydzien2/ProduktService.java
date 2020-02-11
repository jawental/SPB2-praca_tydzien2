package pl.weglewski.praca_tydzien2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@Service
public class ProduktService {

    private List<Produkt> produktList;
    private double totalSum;

    public ProduktService() {
    Random rand = new Random();

    Produkt produkt1 = new Produkt("betoniarka", rand.nextInt(250) + 50);
    Produkt produkt2 = new Produkt("łopata", rand.nextInt(250) + 50);
    Produkt produkt3 = new Produkt("kielnia", rand.nextInt(250) + 50);
    Produkt produkt4 = new Produkt("podest", rand.nextInt(250) + 50);
    Produkt produkt5 = new Produkt("taczka", rand.nextInt(250) + 50);

    produktList = new ArrayList<>();
    produktList.add(produkt1);
    produktList.add(produkt2);
    produktList.add(produkt3);
    produktList.add(produkt4);
    produktList.add(produkt5);

    Produkt produkt6 = new Produkt("Razem:", getSumProdukt());
    produktList.add(produkt6);
    }


    public double getSumProdukt(){
        for(int i = 0; i < produktList.size(); i++){
            totalSum += produktList.get(i).getCena();
        }
        return totalSum;
    }

    public double getProcent(double procent){
        totalSum=(int)((totalSum*procent)*100)/100.00;
        return totalSum;
    }

    public List<Produkt> getProdukty(){
        return produktList;
    }

    public void dodajVat(int vat) {
        Produkt produkt7 = new Produkt("Razem z vat:", getProcent(1 + (vat / 100.00)));
        produktList.add(produkt7);
    }

    public void dodajRabat(int rabat) {
        Produkt produkt8 = new Produkt("Razem po rabacie:", getProcent(1-(rabat/ 100.00)));
        produktList.add(produkt8);
    }
}
