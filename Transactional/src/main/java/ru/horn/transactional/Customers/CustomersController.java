package ru.horn.transactional.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.horn.transactional.Purchases.Purchases;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private CustomersService customersService;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomersController(CustomersService customersService,
                               CustomerRepository customerRepository) {
        this.customersService = customersService;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customers> getCustomers() {
        return customersService.getCustomers();
    }

    @PostMapping
    public void addNewCustomer(@RequestBody Customers customers) {
        customersService.addNewCustomer(customers);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") Long customerId) {
        customersService.deleteCustomerById(customerId);
    }

    @PutMapping(path = "{customerId}")
    public List<Customers> transaction(
            @PathVariable("customerId") Long customerId,
            @RequestParam int cost) {
        customersService.transaction(customerId, cost);

        //УДАЛИТЬ
        return customersService.getCustomers();
    }
}
