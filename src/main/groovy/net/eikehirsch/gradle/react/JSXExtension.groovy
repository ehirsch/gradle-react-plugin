package net.eikehirsch.gradle.react

import org.gradle.util.ConfigureUtil

/**
 * Extension to configure the jsx transpiler
 */
class JSXExtension {
	
	public static String NAME = 'jsx'
	
	String sourcesDir
	String destDir
	
	JSXOptions options = new JSXOptions()
	
	@SuppressWarnings("GroovyUnusedDeclaration")
	JSXExtension options(Closure<JSXOptions> optionsClosure) {
		ConfigureUtil.configure(optionsClosure, options)
		return this
	}
}
