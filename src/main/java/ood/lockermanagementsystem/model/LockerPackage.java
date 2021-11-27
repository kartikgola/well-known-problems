/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:47 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.model;

public class LockerPackage {

    private int id;
    private Dimension dimension;
    private int collectorAccountId;

    public LockerPackage(int id, Dimension dimension, int collectorAccountId) {
        this.id = id;
        this.dimension = dimension;
        this.collectorAccountId = collectorAccountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public int getCollectorAccountId() {
        return collectorAccountId;
    }

    public void setCollectorAccountId(int collectorAccountId) {
        this.collectorAccountId = collectorAccountId;
    }
}
