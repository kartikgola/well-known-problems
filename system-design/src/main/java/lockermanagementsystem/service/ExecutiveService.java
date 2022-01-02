/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import lockermanagementsystem.model.Executive;

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
