package com.hvdbs.hexletconcurrency.m1.e0;

import com.hvdbs.hexletconcurrency.m0.e2.GraphNode;
import com.hvdbs.hexletconcurrency.m0.e2.XOField;
import com.hvdbs.hexletconcurrency.m0.e3.GraphHelper;

public class Main {
    public static void main(String[] args) {
        GraphNode node = new GraphBuilder().build(XOField.Figure.X, new XOField(), 0);
        System.out.println(node.getNode());
        System.out.println(GraphHelper.countNodes(node));
    }
}
