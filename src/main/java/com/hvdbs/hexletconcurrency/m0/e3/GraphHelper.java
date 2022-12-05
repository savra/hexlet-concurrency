package com.hvdbs.hexletconcurrency.m0.e3;

import com.hvdbs.hexletconcurrency.m0.e2.GraphNode;

public class GraphHelper {
    public static void show(GraphNode node, int level) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < level * 7; i++) {
            stringBuilder.append(".");
        }

        stringBuilder.append(" ");

        String space = stringBuilder.toString();
        String nodeStr = node.getNode().toString();
        String updatedNodeStr = nodeStr.replace("\n", "\n" + space);
        System.out.println("\n" + space + updatedNodeStr);

        for (GraphNode child : node.getChildren()) {
            show(child, level + 1);
        }

    }

    public static int countNodes(GraphNode node) {
        int count = 1;

        for (GraphNode child : node.getChildren()) {
            count = count + countNodes(child);
        }

        return count;
    }
}
