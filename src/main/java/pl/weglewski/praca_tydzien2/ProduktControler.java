package pl.weglewski.praca_tydzien2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProduktControler {

    private ProduktService produktService;

    @Autowired
    public ProduktControler(ProduktService produktService) {
        this.produktService = produktService;
    }

    @GetMapping
    public List<Produkt> get(){
        return produktService.getProdukty();
    }


}
