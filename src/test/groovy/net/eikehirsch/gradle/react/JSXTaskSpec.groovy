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
	validProjectSetup()

	when:
	project.tasks.jsx.exec()

	then:
	notThrown(GradleException.class)
  }

  def "uses default input and output locations"() {
	given: "a valid project setup"
	validProjectSetup()
	createInputFile('src/main/react')
	def output = project.file('build/react')

	when:
	project.tasks.jsx.exec()

	then:
	project.tasks.jsx.args == [project.file('src/main/react').absolutePath, output.absolutePath]
	output.exists()
  }

  def "input and output locations get configured via extension"() {
	given: "a valid project setup"
	project.with {
	   apply plugin: 'net.eikehirsch.react'
	   jsx {
		 sourcesDir = 'src/react'
		 destDir = 'out'
	   }
	}

	when:
	project.evaluate()

	then:
	project.tasks.jsx.sourcesDir == project.file('src/react')
	project.tasks.jsx.destDir == project.file('out')
  }

  def "configurations in task definitions take precedence over extension"() {
	given: "a valid project setup"
	project.with {
	  apply plugin: 'net.eikehirsch.react'

	  jsx {
		sourcesDir = 'src/react'
		destDir = 'out'
	  }

	  task([type:JSXTask],'myJSX') {
		sourcesDir = 'src/react2'
		destDir = 'out2'
	  }
	}

	when:
	project.evaluate()

	then:
	project.tasks.myJSX.sourcesDir == project.file('src/react2')
	project.tasks.myJSX.destDir == project.file('out2')
  }


  def "can use options"() {
	given: "a valid project setup"
	project.with {
	  apply plugin: 'net.eikehirsch.react'

	  jsx {
		  sourcesDir = 'src/react'
		  destDir = 'out'
		  options {
			  extension = 'jsx'
		  }
	  }
	}

	when:
	project.evaluate()

	then:
		JSXTask task = project.tasks.jsx
		task.sourcesDir == project.file('src/react')
		task.destDir == project.file('out')
		task.options.extension == 'jsx'
  }


  private void validProjectSetup() {
	project.apply plugin: 'net.eikehirsch.react'
	project.evaluate()
	project.tasks.installReact.exec()
  }


  private void createInputFile(String inputDir) {
	def dir = project.file(inputDir)
	dir.mkdirs();
	def input = new File(dir, 'test.js')
	input.createNewFile()
  }

}
