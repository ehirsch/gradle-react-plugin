package net.eikehirsch.gradle.react

import com.moowork.gradle.node.task.NodeTask
import org.gradle.api.GradleException

class ReactTask
    extends NodeTask
{
    private final static String JSX_SCRIPT = 'node_modules/react-tools/bin/jsx';

    public ReactTask() {
        this.group = 'React';
    }

    // TODO: inputs & outputs
    // TODO: options

    @Override
    void exec() {
        def jsx = this.project.file(JSX_SCRIPT)
        if (!jsx.isFile() )
        {
            throw new GradleException(
                "React-Tools not installed in node_modules, please run 'gradle ${ReactPlugin.REACT_INSTALL_NAME}' first." )
        }

        setScript( jsx )
        super.exec()
    }
}
