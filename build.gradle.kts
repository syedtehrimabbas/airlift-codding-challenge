plugins {
    id(BuildPluginsConfig.androidApplication) apply false
    id(BuildPluginsConfig.androidLibrary) apply false
    kotlin(BuildPluginsConfig.kotlinAndroid) apply false
    kotlin(BuildPluginsConfig.kotlinKapt) apply false
    id(BuildPluginsConfig.kotlinParcelize) apply false
}
buildscript {
    val kotlin_version by extra("1.5.10")
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(BuildClassesConfig.ANDROID_GRADLE_PLUGIN)
        classpath(BuildClassesConfig.KOTLIN_GRADLE_PLUGIN)
        classpath(BuildClassesConfig.NAVIGATION_SAFE_ARGS)
        classpath(BuildClassesConfig.HILT_GRADLE_PLUGIN)
        classpath(BuildClassesConfig.GOOGLE_SERVICES)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
        jcenter() // Warning: this repository is going to shut down soon
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
subprojects {
    apply {
//        plugin(ScriptPlugins.variants)
//        plugin(ScriptPlugins.compilation)
    }
}
