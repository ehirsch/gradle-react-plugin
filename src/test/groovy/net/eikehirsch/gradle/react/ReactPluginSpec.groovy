package net.eikehirsch.gradle.react

import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification


class ReactPluginSpec extends Specification {

  def "apply the plugin"() {
    given:
    def project = ProjectBuilder.builder().build()

    when:
    project.apply plugin: 'net.eikehirsch.react'

    then:
    project.JSXTask == JSXTask
  }
}
