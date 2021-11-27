/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:47 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.model;

public abstract class Account {

    protected String name;
    protected int id;
    protected String address;

    public Account(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
