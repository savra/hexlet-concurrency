package com.hvdbs.hexletconcurrency.m0.e3;

import com.hvdbs.hexletconcurrency.m0.e2.GraphNode;
import com.hvdbs.hexletconcurrency.m0.e2.XOField;

import java.util.HashSet;
import java.util.Set;

public class GraphBuilder {
    public GraphNode build(final XOField.Figure currentFigure, final XOField currentField) {
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
                children.add(build(nextFigure, newField));
            }
        }

        return new GraphNode(currentField, children);
    }
}
