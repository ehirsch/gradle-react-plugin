package net.eikehirsch.gradle.react
import com.moowork.gradle.node.task.NodeTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory

class JSXTask extends NodeTask {

    private final static String JSX_SCRIPT = 'node_modules/react-tools/bin/jsx';

    @InputDirectory
    def sourcesDir = 'src/main/react'

    @OutputDirectory
    def destDir = 'build/react'


    public JSXTask() {
        this.group = 'React'
        this.description = 'Compiles jsx sources into javascript. Configure via jsx extension.'
        this.dependsOn 'installReact'
    }


    @Override
    void exec() {
        def jsx = this.project.file(JSX_SCRIPT)
        if (!jsx.isFile()) {
            throw new GradleException(
                    "React-Tools not installed in node_modules, please run 'gradle " +
                        "${ReactPlugin.REACT_INSTALL_TASK_NAME}' first." )
        }
        setScript( jsx )

        // make sure the output folder exists
        def out = getDestDir();
        if( out.exists() ) {
            out.mkdirs()
        }
        setArgs([getSourcesDir().absolutePath, out.absolutePath])
        super.exec()
    }

    def getSourcesDir() {
        return project.file(sourcesDir)
    }

    def getDestDir() {
        return project.file(destDir)
    }

}
