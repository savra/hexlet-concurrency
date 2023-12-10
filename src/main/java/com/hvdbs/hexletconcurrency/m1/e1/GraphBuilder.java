package com.hvdbs.hexletconcurrency.m1.e1;

import com.hvdbs.hexletconcurrency.m0.e2.GraphNode;
import com.hvdbs.hexletconcurrency.m0.e2.XOField;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GraphBuilder {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    public GraphNode build(final XOField.Figure currentFigure,
                           final XOField currentField,
                           int deepLevel) {
     //   if (deepLevel > 4) return new GraphNode(currentField, Collections.emptySet());
        final List<Future<?>> futures = new ArrayList<>();

        final XOField.Figure nextFigure =
                currentFigure == XOField.Figure.O ? XOField.Figure.X : XOField.Figure.O;

        final Set<GraphNode> children = new HashSet<>();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigures(x, y) != null) {
                    continue;
                }

                final XOField newField = new XOField(currentField);
                newField.setFigures(x, y, nextFigure);

                final Future<?> future = EXECUTOR_SERVICE.submit(() -> {
                    children.add(build(nextFigure, newField, deepLevel + 1));
                });

                futures.add(future);
            }
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return new GraphNode(currentField, children);
    }
}
