/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.model;

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
