/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:46 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.model;

public class Customer extends Account {

    public Customer(String name, int id, String address) {
        super(name, id, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
