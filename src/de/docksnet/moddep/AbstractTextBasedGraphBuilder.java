package de.docksnet.moddep;

import com.intellij.openapi.module.Module;
import com.intellij.util.graph.Graph;

import java.util.Iterator;

public abstract class AbstractTextBasedGraphBuilder {

    public String buildGraph(Graph<Module> graph) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getHeader());

        for (Module module : graph.getNodes()) {
            stringBuilder.append(getNodeDefinition(module.getName()));
        }

        for (Module module : graph.getNodes()) {
            Iterator<Module> in = graph.getIn(module);
            while (in.hasNext()) {
                Module next = in.next();
                stringBuilder.append(getEdge(module.getName(), next.getName()));
            }
        }

        stringBuilder.append(getFooter());
        return stringBuilder.toString();
    }

    protected abstract String getHeader();

    protected abstract String getFooter();

    protected abstract String getNodeDefinition(String name);

    protected abstract String getEdge(String sourceName, String destName);
}
