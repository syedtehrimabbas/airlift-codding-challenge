plugins {
    id(BuildPluginsConfig.androidApplication)
    kotlin(BuildPluginsConfig.kotlinAndroid)
    kotlin(BuildPluginsConfig.kotlinKapt)
    id(BuildPluginsConfig.kotlinParcelize)
    id(BuildPluginsConfig.androidHilt)
    id(BuildPluginsConfig.navigationSafeArgs)

    // Internal Script plugins
    id(ScriptPlugins.variants)
    id(ScriptPlugins.compilation)
}

android {
    compileSdkVersion(AppConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AppConfig.MIN_SDK_VERSION)
        targetSdkVersion(AppConfig.TARGET_SDK_VERSION)
        multiDexEnabled = true
        applicationId = AppConfig.APP_ID
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME
        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }

    }
    viewBinding {
        android.buildFeatures.viewBinding = true
    }
    buildFeatures {
        this.dataBinding = true

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":networking"))
    implementation(DependenciesManager.kotlinImplementation)
    implementation(DependenciesManager.lifeCycleKtxImplementation)
    implementation(DependenciesManager.androidxImplementation)
    implementation(DependenciesManager.navigationImplementation)
    implementation(DependenciesManager.thirdPartyImplementation)
    implementation(DependenciesManager.networkImplementation)
    implementation(DependenciesManager.hiltImplementation)
    implementation(ThirdPartyDependencies.TIMBER)
    kapt(DependenciesManager.hiltKapt)
    kapt(DependenciesManager.networkKapt)
    testImplementation(DependenciesManager.testingImplementation)
    androidTestImplementation(DependenciesManager.androidTestImplementation)
    implementation(DependenciesManager.roomDB)
    kapt(DependenciesManager.roomDBKPT)
}
