package de.docksnet.moddep;

public class PlantumlGraphBuilder extends AbstractTextBasedGraphBuilder {

    @Override
    protected String getHeader() {
        return "@startuml\n";
    }

    @Override
    protected String getFooter() {
        return "@enduml\n";
    }

    @Override
    protected String getNodeDefinition(String name) {
        return "component " + name +"\n";
    }

    @Override
    protected String getEdge(String sourceName, String destName) {
        return "[" + sourceName + "] --> [" + destName + "]\n";
    }

}
