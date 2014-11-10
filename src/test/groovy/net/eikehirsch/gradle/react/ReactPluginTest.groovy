package net.eikehirsch.gradle.react

import com.moowork.gradle.node.NodePlugin
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.instanceOf
import static org.hamcrest.CoreMatchers.not
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertTrue

/**
 *
 * @author Eike Hirsch
 * Date: 10.11.14
 * Time: 12:10
 */
class ReactPluginTest {

  private Project project

  @Before
  public void setUp ( ) throws Exception {
    project = ProjectBuilder.builder().build()
    project.apply plugin: 'net.eikehirsch.react'
  }

  @Test
  void addsNodePluginToProject() {
    assertTrue(project.plugins.hasPlugin(NodePlugin.class))
  }

  @Test
  void addsInstallTaskToProject() {
    assertThat(project.tasks.installReact, not(null))
    assertThat(project.tasks.installReact, instanceOf(ReactInstallTask) )
  }

  @Test
  void addsJSXTaskToProject() {
    assertThat(project.tasks.jsx, not(null))
    assertThat(project.tasks.jsx, instanceOf(JSXTask) )
  }


}
