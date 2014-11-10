package net.eikehirsch.gradle.react

import com.moowork.gradle.node.NodePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 */
class ReactPlugin implements Plugin<Project> {

    static final String REACT_INSTALL_TASK_NAME = "installReact";
    static final String JSX_TASK_NAME = "jsx";

    Project project;

    @Override
    void apply(final Project project) {
        this.project = project;
        // We need the node plugin to run and install the react-tools.
        project.plugins.apply(NodePlugin.class)

        // Add the install task to this project.
        project.tasks.create(REACT_INSTALL_TASK_NAME, ReactInstallTask.class )

        // Add the jsx task to this project.
        project.tasks.create(JSX_TASK_NAME, JSXTask.class)
        // adding the task to the extra properties makes it available as task type in this project.
        addGlobalTaskType(JSXTask.class)

        // TODO: extension for configuration.
        // TODO: jsx dependsOn installReact
    }

    private void addGlobalTaskType( Class type ) {
        this.project.extensions.extraProperties.set( type.getSimpleName(), type )
    }
}
