package net.eikehirsch.gradle.react

class JSXOptions {
	
	def extension
	
	def toArgsArray() {
		def args = []
		
		if(extension) {
			args << "--extension $extension"
		}
		
		return args
	}
}
