/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class DeleteDuplicateFoldersInSystem {

    private class Folder {
        String name;
        String key;
        TreeMap<String, Folder> sub;
        boolean delete;

        public Folder(String name) {
            this.name = name;
        }
    }

    private Folder root = new Folder("/");
    private Map<String, Integer> counts = new HashMap<>();

    private void add(List<String> path) {
        Folder curr = root;
        for (String folder: path) {
            curr.sub.putIfAbsent(folder, new Folder(folder));
            curr = curr.sub.get(folder);
        }
    }

    private String genKey(Folder f) {
        StringBuilder key = new StringBuilder();
        if (f.sub.size() == 0)
            return key.toString();

        for (Map.Entry<String, Folder> e: f.sub.entrySet()) {
            key.append("(")
                    .append(e.getKey())
                    .append(genKey(e.getValue()))
                    .append(")");
        }

        f.key = key.toString();
        counts.put(f.key, counts.getOrDefault(f.key, 0)+1);
        return f.key;
    }

    private boolean isValid(List<String> path) {
        Folder curr = root;
        for (String folder: path) {
            curr = curr.sub.get(folder);
            if (curr.delete)
                return false;
        }
        return true;
    }

    private void markForDeletion(Folder f) {
        if (f.sub.size() > 0 && counts.get(f.key) > 1) {
            f.delete = true;
            return;
        }
        for (Folder sf: f.sub.values())
            markForDeletion(sf);
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Trie + TreeMap + Map / O(nm + n + n^2 + nm)
        // Use a regular trie to store all the paths as Folders (trie node)
        // Each trie node is Folder{key: string, sub:treemap<string, Folder>, canDelete: boolean}
        for (List<String> path: paths)
            add(path);

        // Generate string key of each Folder (trie node) using recursion
        for (Folder sf: root.sub.values())
            genKey(sf);

        // Mark a folder for deletion if key of the said folder has count > 1
        // Use a count:map<string, int> to store the frequence of each folder key
        for (Folder sf: root.sub.values())
            markForDeletion(sf);

        List<List<String>> ans = new ArrayList<>();

        // Formulate the final answer by adding only valid paths in ans[][]
        // A path is valid if it does not contain any deleted folder
        for (List<String> path: paths) {
            if (isValid(path))
                ans.add(path);
        }

        return ans;
    }
}
