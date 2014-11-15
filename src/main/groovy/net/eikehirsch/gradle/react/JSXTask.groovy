package net.eikehirsch.gradle.react
import com.moowork.gradle.node.task.NodeTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory

class JSXTask extends NodeTask {

    public static final String NAME = 'jsx';
    public static final String DEFAULT_SOURCES_DIR = 'src/main/react'
    public static final String DEFAULT_DEST_DIR    = 'build/react'

    private final static String JSX_SCRIPT = 'node_modules/react-tools/bin/jsx';

    @InputDirectory
    def sourcesDir

    @OutputDirectory
    def destDir


    public JSXTask() {
        this.group = 'React'
        this.description = 'Compiles jsx sources into javascript. Configure via jsx extension.'
        this.dependsOn 'installReact'
    }

    // updating will happen when the project was evaluated.
    def updateSettings() {
        JSXExtension config = project.extensions.getByName(JSXExtension.NAME)
        sourcesDir = config.sourcesDir ? config.sourcesDir : DEFAULT_SOURCES_DIR;
        destDir = config.destDir ? config.destDir : DEFAULT_DEST_DIR;
    }

    @Override
    void exec() {
        def jsx = this.project.file(JSX_SCRIPT)
        if (!jsx.isFile()) {
            throw new GradleException(
                    "React-Tools not installed in node_modules, please run 'gradle " +
                            "${ReactInstallTask.NAME}' first.")
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
