/*
 * Author: Kartik Gola
 * Date: 1/6/22, 5:10 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/discuss/interview-question/759611/Confluent-or-Senior-Software-Engineer-or-Phone-interview
 */

package interview;

import java.util.*;

public class FunctionLibrary {

    private static class Function {
        String name;
        List<String> argumentTypes = new ArrayList<>();
        boolean isVariadic;

        public Function(String name) {
            this.name = name;
        }

        Function(String name, List<String> argumentTypes, boolean isVariadic) {
            this.name = name;
            this.argumentTypes = argumentTypes;
            this.isVariadic = isVariadic;
        }

        @Override
        public String toString() {
            return "(" + name + ", " + argumentTypes.toString() + ", " + isVariadic + ")";
        }
    }

    /*
    * a[0,0]
    *   -> b[0,2]
    *       -> b[0,1]
    *           -> b[1,0]
    *       -> c[1,0]
    * */
    private class Node {
        String arg;
        Map<String, Node> children = new HashMap<>();
        List<Function> functions = new ArrayList<>();
        List<Function> varFunctions = new ArrayList<>();
        Node(String arg) {
            this.arg = arg;
        }
    }

    private class Trie {
        Node root = new Node("#");

        public void add(Function func) {
            Node curr = root;
            for (int i = 0; i < func.argumentTypes.size(); ++i) {
                String arg = func.argumentTypes.get(i);
                curr.children.putIfAbsent(arg, new Node(arg));
                curr = curr.children.get(arg);
            }
            if (func.isVariadic) {
                curr.varFunctions.add(func);
            } else {
                curr.functions.add(func);
            }
        }

        private List<Function> search(List<String> args, boolean[] lookAhead) {
            List<Function> ans = new ArrayList<>();
            Node parent = root;
            if (args.isEmpty())
                ans.addAll(parent.functions);
            for (int i = 0; i < args.size(); ++i) {
                if (!parent.children.containsKey(args.get(i)))
                    break;
                Node child = parent.children.get(args.get(i));
                if (lookAhead[i])
                    ans.addAll(child.varFunctions);
                if (i == args.size()-1)
                    ans.addAll(child.functions);
                parent = child;
            }
            return ans;
        }

        private boolean[] getLookAhead(List<String> args) {
            // calculate lookAhead that will be used at each node
            // lookAhead[i] = true, means that args[i] is same as all args in range[i+1,n-1]
            // so, if lookAhead[i] is true, we can use all varFunctions from current node
            boolean[] lookAhead = new boolean[args.size()];
            if (args.isEmpty())
                return lookAhead;
            lookAhead[args.size()-1] = true;
            String prev = args.get(args.size()-1);
            for (int i = args.size()-2; i >= 0; --i) {
                lookAhead[i] = args.get(i).equals(prev);
                prev = args.get(i);
            }
            return lookAhead;
        }

        public List<Function> search(List<String> args) {
            return search(args, getLookAhead(args));
        }
    }

    private Trie trie = new Trie();

    public void register(Function function)  {
        trie.add(function);
    }

    public List<Function> findMatches(List<String> argumentTypes) {
        return trie.search(argumentTypes);
    }

    public static void main(String[] args) {
        FunctionLibrary fl = new FunctionLibrary();
        fl.register(new Function("FuncX"));
        fl.register(new Function("FuncA", Arrays.asList("String", "Integer", "Integer"), false));
        fl.register(new Function("FuncB", Arrays.asList("String", "Integer"), true));
        fl.register(new Function("FuncC", Arrays.asList("Integer"), true));
        fl.register(new Function("FuncD", Arrays.asList("Integer", "Integer"), true));
        fl.register(new Function("FuncE", Arrays.asList("Integer", "Integer", "Integer"), false));
        fl.register(new Function("FuncF", Arrays.asList("String"), false));
        fl.register(new Function("FuncG", Arrays.asList("Integer"), false));

        System.out.println(fl.findMatches(Arrays.asList())); //Arrays.asList(FuncX)
        System.out.println(fl.findMatches(Arrays.asList("String"))); //Arrays.asList(FuncF)
        System.out.println(fl.findMatches(Arrays.asList("Integer"))); //Arrays.asList(FuncC, FuncG)
        System.out.println(fl.findMatches(Arrays.asList("Integer", "Integer", "Integer", "Integer"))); //Arrays.asList(FuncC, FuncD)
        System.out.println(fl.findMatches(Arrays.asList("Integer", "Integer", "Integer"))); //Arrays.asList(FuncC, FuncD, FuncE)
        System.out.println(fl.findMatches(Arrays.asList("String", "Integer", "Integer", "Integer"))); //FuncB
        System.out.println(fl.findMatches(Arrays.asList("String", "Integer", "Integer"))); //FuncA,FuncB }}}
    }

}
