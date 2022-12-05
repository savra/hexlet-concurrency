package com.hvdbs.hexletconcurrency.m0.e3;

import com.hvdbs.hexletconcurrency.m0.e2.GraphNode;
import com.hvdbs.hexletconcurrency.m0.e2.XOField;

public class Main {
    public static void main(String[] args) {
        GraphNode root = new GraphBuilder().build(XOField.Figure.X, new XOField());
        System.out.println(root.getNode());

        System.out.println(GraphHelper.countNodes(root));
    }
}
