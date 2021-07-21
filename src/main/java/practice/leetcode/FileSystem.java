/*
 * Author: Kartik Gola
 * Date: 12/10/20, 11:22 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/design-in-memory-file-system/
 */

package practice.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ls: Given a path in string format. If it is a file path, return a list that only contains this file's name.
 * If it is a directory path, return the list of file and directory names in this directory.
 * Your output (file and directory names together) should in lexicographic order.
 *
 * mkdir: Given a directory path that does not exist, you should make a new directory according to the path.
 * If the middle directories in the path don't exist either, you should create them as well. This function has void return type.
 *
 * addContentToFile: Given a file path and file content in string format.
 * If the file doesn't exist, you need to create that file containing given content.
 * If the file already exists, you need to append given content to original content. This function has void return type.
 *
 * readContentFromFile: Given a file path, return its content in string format.
 */

abstract class FileSystemObject {
    private String name;

    public FileSystemObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean isDirectory();
    public abstract boolean isFile();
}

class Directory extends FileSystemObject {
    private TreeMap<String, FileSystemObject> children = new TreeMap<>();

    Directory(String name) {
        super(name);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    public TreeMap<String, FileSystemObject> getChildren() {
        return children;
    }

    public void setChildren(TreeMap<String, FileSystemObject> children) {
        this.children = children;
    }
}

class File extends FileSystemObject {
    private String data;

    File(String name) {
        super(name);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

public class FileSystem {

    private final Directory ROOT_DIR = new Directory("/");

    private StringTokenizer getPathTokenizer(String path) {
        return new StringTokenizer(path, "/");
    }

    public List<String> ls(String path) {
        FileSystemObject fsObj = ROOT_DIR;
        StringTokenizer st = getPathTokenizer(path);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (fsObj instanceof File)
                return Collections.emptyList();
            Directory dir = (Directory) fsObj;
            if (dir.getChildren().containsKey(token)) {
                fsObj = dir.getChildren().get(token);
            } else
                return Collections.emptyList();
        }
        if (fsObj.isFile())
            return Collections.singletonList(((File) fsObj).getName());
        return ((Directory) fsObj).getChildren().values().stream().map(FileSystemObject::getName).collect(Collectors.toList());
    }

    public void mkdir(String path) {
        Directory dir = ROOT_DIR;
        StringTokenizer st = getPathTokenizer(path);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            dir.getChildren().putIfAbsent(token, new Directory(token));
            dir = (Directory) dir.getChildren().get(token);
        }
    }

    public void addContentToFile(String filePath, String content) {
        FileSystemObject fsObj = ROOT_DIR;
        StringTokenizer st = getPathTokenizer(filePath);
        String token = "";
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if (fsObj instanceof File)
                return;
            Directory dir = (Directory) fsObj;
            if (dir.getChildren().containsKey(token)) {
                fsObj = dir.getChildren().get(token);
            }
        }
        if (fsObj.isFile()) {
            final File file = (File) fsObj;
            file.setData(file.getData().concat(content));
        } else {
            final File file = new File(token);
            file.setData(content);
            ((Directory) fsObj).getChildren().put(token, file);
        }
    }

    public String readContentFromFile(String filePath) {
        Directory dir = ROOT_DIR;
        StringTokenizer st = getPathTokenizer(filePath);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (dir.getChildren().get(token).isFile())
                return ((File) dir.getChildren().get(token)).getData();
            else
                dir = (Directory) dir.getChildren().get(token);
        }
        return "";
    }
}
