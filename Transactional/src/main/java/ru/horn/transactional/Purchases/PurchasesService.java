package ru.horn.transactional.Purchases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.horn.transactional.Customers.Customers;

import java.util.List;

@Service
public class PurchasesService {
    private final PurchasesRepository purchasesRepository;

    @Autowired
    public PurchasesService(PurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }

    public List<Purchases> getPurchases(){
        return purchasesRepository.findAll();
    }

    public void addNewPurchase(Purchases purchases) {
        purchasesRepository.save(purchases);
    }

}
