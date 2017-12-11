package net.eikehirsch.gradle.react

import com.moowork.gradle.node.npm.NpmTask

class ReactInstallTask extends NpmTask {

    public static final String        NAME = "installReact"
    public static final String INSTALL_DIR = 'node_modules/react-tools'

    public ReactInstallTask() {
        super()

        this.group = 'React'
        this.description = "Runs 'npm install react-tools' to install jsx compiler"

        setArgs( ['install', 'react-tools'] )

        def installDir = this.project.file INSTALL_DIR
        if( !installDir.exists() ) {
            installDir.mkdirs();
        }

        getOutputs().dir(installDir)
    }
}
