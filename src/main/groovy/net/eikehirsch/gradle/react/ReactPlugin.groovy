package net.eikehirsch.gradle.react

import com.moowork.gradle.node.NodePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class ReactPlugin
    implements Plugin<Project>
{
    static final String REACT_INSTALL_NAME = "installReact";

    @Override
    void apply(final Project project) {
        // We need the node plugin to run and install the react-tools.
        project.plugins.apply(NodePlugin.class)
        // Add the install task to this project.
        project.tasks.create(REACT_INSTALL_NAME, ReactInstallTask.class )

        project.extensions.extraProperties.set('ReactTask', ReactTask.class)
    }
}
