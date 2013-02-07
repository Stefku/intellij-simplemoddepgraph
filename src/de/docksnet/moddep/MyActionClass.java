package de.docksnet.moddep;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.graph.Graph;

public class MyActionClass extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        if (project == null) {
            Messages.showMessageDialog(project, "No project loaded", "Information", Messages.getInformationIcon());
            return;
        }

        final Graph<Module> graph = ModuleManager.getInstance(project).moduleGraph();

        String graphAsPumlString = new PlantumlGraphBuilder().buildGraph(graph);
        String graphAsGraphmlString = new GraphmlGraphBuilder().buildGraph(graph);

        Messages.showMessageDialog(project, graphAsPumlString, "PlantUML", Messages.getInformationIcon());
        Messages.showMessageDialog(project, graphAsGraphmlString, "GraphML", Messages.getInformationIcon());
    }

}
