package net.eikehirsch.gradle.react
/**
 * Extension to configure the jsx transpiler
 */
class JSXExtension {

  public static String NAME = 'jsx'

  String sourcesDir
  String destDir
	
  @Delegate JSXOptions options = new JSXOptions()

}
