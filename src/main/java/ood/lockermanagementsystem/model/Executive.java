/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:47 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.model;

public class Executive extends Account {

    public Executive(String name, int id, String address) {
        super(name, id, address);
    }

    @Override
    public String toString() {
        return "Executive{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
