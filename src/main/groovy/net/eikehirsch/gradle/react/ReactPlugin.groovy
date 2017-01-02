package net.eikehirsch.gradle.react

import com.moowork.gradle.node.NodePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 */
class ReactPlugin implements Plugin<Project> {

    Project project

    @Override
    void apply(final Project project) {
        this.project = project

        // We need the node plugin to run and install the react-tools.
        project.plugins.apply(NodePlugin.class)

        // Add the install task to this project.
        project.tasks.create(ReactInstallTask.NAME, ReactInstallTask.class )

        // Add the jsx task to this project.
        project.tasks.create(JSXTask.NAME, JSXTask.class)
        // adding the task to the extra properties makes it available as task type in this project.
        addGlobalTaskType(JSXTask.class)

        // create the extension to configure the tasks
        project.extensions.create(JSXExtension.NAME, JSXExtension.class)
        // when the project was evaluated and before any task is running we are able to configure the tasks
        project.afterEvaluate {
	        ((JSXTask)project.tasks.getByName(JSXTask.NAME)).updateSettings()
        }

    }

    private void addGlobalTaskType( Class type ) {
        this.project.extensions.extraProperties.set( type.getSimpleName(), type )
    }
}
