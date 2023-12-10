package com.hvdbs.hexletconcurrency.m1.e1;

import com.hvdbs.hexletconcurrency.m0.e2.GraphNode;
import com.hvdbs.hexletconcurrency.m0.e2.XOField;
import com.hvdbs.hexletconcurrency.m0.e3.GraphHelper;
import com.hvdbs.hexletconcurrency.m1.e0.GraphBuilder;

public class Main {
    public static void main(String[] args) {
        final GraphNode node = new GraphBuilder().build(XOField.Figure.X, new XOField(), 0);
        System.out.println(node.getNode());
        System.out.println(GraphHelper.countNodes(node));
    }
}
