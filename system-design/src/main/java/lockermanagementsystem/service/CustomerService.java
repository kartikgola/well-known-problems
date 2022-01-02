/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import lockermanagementsystem.model.Customer;

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
