package com.example.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "fraud")
public interface FraudClient {
    @RequestMapping(method = RequestMethod.GET, value= "api/v1/fraud-check/{customerId}")
    boolean isFraudster(@PathVariable("customerId") Integer customerId);
}
