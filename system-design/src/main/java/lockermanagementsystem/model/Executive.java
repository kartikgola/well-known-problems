/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.model;

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
