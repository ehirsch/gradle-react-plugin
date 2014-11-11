package net.eikehirsch.gradle.react

import com.moowork.gradle.node.task.NpmTask

class ReactInstallTask
    extends NpmTask
{
    public ReactInstallTask()
    {
        super()

        this.group = 'React'
        this.description = "Runs 'npm install react-tools' to install jsx compiler"

        setArgs( ['install', 'react-tools'] )

        def installDir = this.project.file 'node_modules/react-tools'
        if( !installDir.exists() ) {
            installDir.mkdirs();
        }

        getOutputs().dir(installDir)
    }
}
