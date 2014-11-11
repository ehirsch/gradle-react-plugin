package net.eikehirsch.gradle.react

import com.moowork.gradle.node.NodePlugin
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification


class ReactPluginSpec extends Specification {

  def "applying the plugin adds react tasks to project"() {
    given:
    def project = ProjectBuilder.builder().build()

    when:
    project.apply plugin: 'net.eikehirsch.react'

    then:
    project.tasks.installReact instanceof ReactInstallTask
    project.tasks.jsx instanceof JSXTask
  }

  def "applying the plugin adds jsxTask to global namespace"() {
    given:
    def project = ProjectBuilder.builder().build()

    when:
    project.apply plugin: 'net.eikehirsch.react'

    then:
    project.JSXTask == JSXTask
  }

  def "applying the plugin applies the node plugin to to the project"() {
    given:
    def project = ProjectBuilder.builder().build()

    when:
    project.apply plugin: 'net.eikehirsch.react'

    then:
    project.plugins.hasPlugin(NodePlugin.class)
  }

}
