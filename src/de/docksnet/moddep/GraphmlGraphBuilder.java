package de.docksnet.moddep;

public class GraphmlGraphBuilder extends AbstractTextBasedGraphBuilder {
    @Override
    protected String getHeader() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\"\n" +
                "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "xmlns:y=\"http://www.yworks.com/xml/graphml\"\n" +
                "    xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns\n" +
                "     http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n" +
                "<key for=\"node\" id=\"d6\" yfiles.type=\"nodegraphics\"/>" +
                "<graph id=\"Module Dependency\" edgedefault=\"undirected\">";
    }

    @Override
    protected String getFooter() {
        return "</graph></graphml>";
    }

    @Override
    protected String getNodeDefinition(String name) {
        return "<node id=\"" + name + "\">\n" +
                "\t\t<data key=\"d6\">\n" +
                "\t\t\t<y:ShapeNode>\n" +
                "\t\t\t  <y:Fill color=\"#FFCC00\" transparent=\"false\"/>\n" +
                "\t\t\t  <y:BorderStyle color=\"#000000\" type=\"line\" width=\"1.0\"/>\n" +
                "\t\t\t  <y:NodeLabel alignment=\"center\" autoSizePolicy=\"content\" fontFamily=\"Dialog\" fontSize=\"12\" " +
                "fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" modelName=\"custom\" " +
                "textColor=\"#000000\" visible=\"true\">" + name + "<y:LabelModel>\n" +
                "\t\t\t\t  <y:SmartNodeLabelModel distance=\"4.0\"/>\n" +
                "\t\t\t\t</y:LabelModel>\n" +
                "\t\t\t\t<y:ModelParameter>\n" +
                "\t\t\t\t  <y:SmartNodeLabelModelParameter labelRatioX=\"0.0\" labelRatioY=\"0.0\" nodeRatioX=\"0.0\" nodeRatioY=\"0.0\" offsetX=\"0.0\" offsetY=\"0.0\" upX=\"0.0\" upY=\"-1.0\"/>\n" +
                "\t\t\t\t</y:ModelParameter>\n" +
                "\t\t\t  </y:NodeLabel>\n" +
                "\t\t\t  <y:Shape type=\"rectangle\"/>\n" +
                "\t\t\t</y:ShapeNode>\n" +
                "\t\t  </data>\n" +
                "\t</node>";
    }

    @Override
    protected String getEdge(String sourceName, String destName) {
        return "<edge id=\"" + sourceName + destName + "\" source=\"" + sourceName + "\" target=\"" + destName + "\"/>\n";
    }
}
