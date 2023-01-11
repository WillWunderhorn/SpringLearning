package ru.horn.transactional.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.horn.transactional.Purchases.Purchases;
import ru.horn.transactional.Purchases.PurchasesService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    private final CustomerRepository customerRepository;
    private final PurchasesService purchasesService;


    @Autowired
    public CustomersService(CustomerRepository customerRepository,
                            PurchasesService purchasesService) {
        this.customerRepository = customerRepository;
        this.purchasesService = purchasesService;

    }

    public List<Customers> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customers customers) {
        Optional<Customers> CustomerOptional = customerRepository
                .findCustomersByName(customers.getName());
        if (CustomerOptional.isPresent()) {
            throw new IllegalStateException("name is taken");
        }
        customerRepository.save(customers);
    }

    public void deleteCustomerById(Long customerId) {
        customerRepository.findById(customerId);
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw new IllegalStateException("customer with " + customerId + " does not exists");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void transaction(Long customerId, int cost) {
        Customers customers = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("customer with " + customerId + " does not exists"));
        if (customerId != null) {
            customers.setBalance(customers.getBalance() - cost);
            Purchases purchase = new Purchases(
                    customerId,
                    cost
            );
            purchasesService.addNewPurchase(purchase);
//            purchasesService.addNewPurchase();
            System.out.println("Customer with id: " + customerId + " spent " + cost + "$");
        }
    }
}
