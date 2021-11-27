/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:59 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

import ood.lockermanagementsystem.model.Customer;

import java.util.Map;

public class CustomerService {

    private Map<Integer, Customer> customerMap;

    public CustomerService(Map<Integer, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public Customer getCustomerById(int customerId) {
        return customerMap.get(customerId);
    }
}
