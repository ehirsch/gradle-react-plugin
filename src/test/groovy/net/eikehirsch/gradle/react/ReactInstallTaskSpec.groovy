package net.eikehirsch.gradle.react

import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * @author Eike Hirsch
 * Date: 11.11.14
 * Time: 14:16
 */
class ReactInstallTaskSpec extends Specification {

  def "creating task sets group and description"() {
	given:
	def project = ProjectBuilder.builder().build()

	when:
	// applying the plugin will create the task.
	project.apply plugin: 'net.eikehirsch.react'
	def task = project.tasks.installReact

	then:
	task.group != null
	0 < task.group.length()
	task.description != null
	0 < task.description.length()
  }

  def "creating task configures superclass"() {
	given:
	def project = ProjectBuilder.builder().build()

	when:
	// applying the plugin will create the task.
	project.apply plugin: 'net.eikehirsch.react'

	then:
	null != project.tasks.installReact.args
  }

  def "task creates output dir"() {
	given:
	def project = ProjectBuilder.builder().build()

	when:
	// applying the plugin will create the task.
	project.apply plugin: 'net.eikehirsch.react'

	then:
	project.file(ReactInstallTask.INSTALL_DIR).exists();
  }


}
