package net.eikehirsch.gradle.react

import com.moowork.gradle.node.task.NodeTask
import org.gradle.api.GradleException

class JSXTask extends NodeTask {

    private final static String JSX_SCRIPT = 'node_modules/react-tools/bin/jsx';

    public JSXTask() {
        this.group = 'React'
        this.description = 'Compiles jsx sources into javascript. Configure via jsx extension.'
        this.dependsOn 'installReact'
    }

    // TODO: inputs & outputs
    // TODO: options
    // TODO: clean up

    @Override
    void exec() {
        def jsx = this.project.file(JSX_SCRIPT)
        if (!jsx.isFile() )
        {
            throw new GradleException(
                "React-Tools not installed in node_modules, please run 'gradle " +
                        "${ReactPlugin.REACT_INSTALL_TASK_NAME}' first." )
        }
        setScript( jsx )
        setArgs(["src/main/react", "build/"])
        super.exec()
    }
}
