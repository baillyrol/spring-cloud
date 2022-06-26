package com.example.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository, FraudClient fraudClient) {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        // todo validation
        // todo already exist
        fraudClient.isFraudster(1);
        customerRepository.save(customer);
    }
}
