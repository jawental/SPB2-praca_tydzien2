package pl.weglewski.praca_tydzien2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("plus")
public class SklepPlus {

    @Value("${sklep-info.vat}")
    private int vat;

    @Autowired
    private ProduktService produktService;

    @EventListener(ApplicationReadyEvent.class)
    public void showProdukt(){
        produktService.dodajVat(vat);
        produktService.getProdukty().forEach(System.out::println);
    }
}
