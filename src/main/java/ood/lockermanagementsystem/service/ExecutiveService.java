/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:59 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

import ood.lockermanagementsystem.model.Executive;

import java.util.Map;

public class ExecutiveService {

    private Map<Integer, Executive> executiveMap;

    public ExecutiveService(Map<Integer, Executive> executiveMap) {
        this.executiveMap = executiveMap;
    }

    public Executive getExecutiveById(int executiveId) {
        return executiveMap.get(executiveId);
    }
}
