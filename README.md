# LanguageSupport
Android切换语言框架

 ![image](https://github.com/913453448/LanguageSupport/blob/master/demo8.gif)
How to

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}Copy
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.913453448:LanguageSupport:1.0'
	}




