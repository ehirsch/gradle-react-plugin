package net.eikehirsch.gradle.react
import org.gradle.api.GradleException
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class JSXTaskSpec extends Specification {

  def project = ProjectBuilder.builder().build()

  def "creating task sets group and description"() {
	when:
	// applying the plugin will create the task.
	project.apply plugin: 'net.eikehirsch.react'
	def task = project.tasks.jsx

	then:
	task.group != null
	0 < task.group.length()
	task.description != null
	0 < task.description.length()
  }


  def "automatically depends on installReact"() {
	when:
	// applying the plugin will create the task.
	project.apply plugin: 'net.eikehirsch.react'

	then:
	project.tasks.jsx.dependsOn.contains('installReact')
  }

  def "fails if react was not installed"() {
	given: "the plugin was applied"
	project.apply plugin: 'net.eikehirsch.react'

	when:
	project.tasks.jsx.exec()

	then:
	thrown(GradleException.class)
  }

  def "works if react was installed"() {
	given: "the plugin is applied and react was installed"
	project.apply plugin: 'net.eikehirsch.react'
	project.tasks.installReact.exec()

	when:
	project.tasks.jsx.exec()

	then:
	notThrown(GradleException.class)
  }

  def "uses default input and output locations"() {
	given: "a valid project setup"
	validProjectSetup()
	def output = project.file('build/react')

	when:
	project.tasks.jsx.exec()

	then:
	project.tasks.jsx.args == [project.file('src/main/react').absolutePath, output.absolutePath]
	output.exists()
  }


  private void validProjectSetup() {
	project.apply plugin: 'net.eikehirsch.react'
	project.tasks.installReact.exec()
	def inputDir = project.file('src/main/react')
	inputDir.mkdirs();
	def input = new File(inputDir, 'test.js')
	input.createNewFile()
  }

}
