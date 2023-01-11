package ru.horn.transactional.Purchases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchasesController {

    PurchasesService purchasesService;
    PurchasesRepository purchasesRepository;

    @Autowired
    public PurchasesController(PurchasesService purchasesService, PurchasesRepository purchasesRepository) {
        this.purchasesService = purchasesService;
        this.purchasesRepository = purchasesRepository;
    }

    @GetMapping("Purchases")
    public void getPurchases(){
        purchasesService.getPurchases();
    }

    @PostMapping
    public void addNewPurchase(@RequestBody Purchases purchases){
        purchasesService.addNewPurchase(purchases);
    }
}
