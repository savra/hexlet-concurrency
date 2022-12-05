package com.hvdbs.hexletconcurrency.m1.e0;

import com.hvdbs.hexletconcurrency.m0.e2.GraphNode;
import com.hvdbs.hexletconcurrency.m0.e2.XOField;

import java.util.*;

public class GraphBuilder {
    public GraphNode build(final XOField.Figure currentFigure,
                           final XOField currentField,
                           int deepLevel) {
        if (deepLevel > 3) return new GraphNode(currentField, Collections.emptySet());
        List<Thread> threads = new ArrayList<>();

        final XOField.Figure nextFigure =
                currentFigure == XOField.Figure.O ? XOField.Figure.X : XOField.Figure.O;

        Set<GraphNode> children = new HashSet<>();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigures(x, y) != null) {
                    continue;
                }

                final XOField newField = new XOField(currentField);
                newField.setFigures(x, y, nextFigure);

                Thread threadThatAddsChildren = new Thread(() -> {
                    children.add(build(nextFigure, newField, deepLevel + 1));
                });

                threadThatAddsChildren.start();
                threads.add(threadThatAddsChildren);
            }
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return new GraphNode(currentField, children);
    }
}
