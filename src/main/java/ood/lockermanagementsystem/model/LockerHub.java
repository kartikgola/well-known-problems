/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:47 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

public class LockerHub {

    private int id;
    private String address;
    private List<Locker> lockerList;

    public LockerHub(int id, String address, List<Locker> lockerList) {
        this.id = id;
        this.address = address;
        this.lockerList = lockerList;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<Locker> getLockerList() {
        return lockerList;
    }
}
