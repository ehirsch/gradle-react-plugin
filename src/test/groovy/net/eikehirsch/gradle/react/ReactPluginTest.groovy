package net.eikehirsch.gradle.react

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

/**
 * @author Eike Hirsch
 * Date: 10.11.14
 * Time: 12:10
 */
class ReactPluginTest {

  @Test
  void addsInstallTaskToProject() {
    Project project = ProjectBuilder.builder().build()
    project.apply plugin: 'net.eikehirsch.react'

    assertTrue(project.tasks.installReact instanceof ReactInstallTask)
  }
}
