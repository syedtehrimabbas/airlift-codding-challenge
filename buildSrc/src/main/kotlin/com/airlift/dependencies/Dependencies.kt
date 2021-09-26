//    Kotlin
object KotlinDependencies {
    const val KOTLIN_REFLECTION =
        "org.jetbrains.kotlin:kotlin-reflect:${KotlinVersions.STANDARD_LIBRARY}"
    const val KOTLIN_STD_LIB =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${KotlinVersions.STANDARD_LIBRARY}"

    // kotlin coroutine
    const val COROUTINE_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${KotlinVersions.COROUTINE_VERSION}"
    const val COROUTINE_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${KotlinVersions.COROUTINE_VERSION}"
}

// Retrofit2 & Networking
object NetworkDependencies {

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${NetworkVersions.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${NetworkVersions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${NetworkVersions.OKHTTP}"
    const val RETROFIT_CONVERTOR_GSON =
        "com.squareup.retrofit2:converter-gson:${NetworkVersions.RETROFIT}"
    const val GSON = "com.google.code.gson:gson:${NetworkVersions.GSON}"

    //Glide Image Loading
    const val GLIDE = "com.github.bumptech.glide:glide:${NetworkVersions.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${NetworkVersions.GLIDE}"

}

//LifeCycle_KTX
object LifeCycleKtxDependencies {
    const val CORE_KTX = "androidx.core:core-ktx:${LifeCycle_KTX.CORE_KTX}"
    const val LIFECYCL_EEXTENSIONS =
        "androidx.lifecycle:lifecycle-extensions:${LifeCycle_KTX.LIFECYCL_EEXTENSIONS}"
    const val Collection_KTX =
        "androidx.collection:collection-ktx:${LifeCycle_KTX.Collection_KTX}"
    const val VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${LifeCycle_KTX.LIFECYCLE}"
    const val VIEW_MODEL_SAVE_STATE_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${LifeCycle_KTX.LIFECYCLE}"
    const val LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${LifeCycle_KTX.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime:${LifeCycle_KTX.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${LifeCycle_KTX.LIFECYCLE}"
    const val LIFECYCLE_COMMON_JAVA =
        "androidx.lifecycle:lifecycle-common-java8:${LifeCycle_KTX.LIFECYCLE}"
    const val REACTIVE_STREAMS =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${LifeCycle_KTX.LIFECYCLE}"
}

// Androidx Architecture
// Androidx

object AndroidxDependencies {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${AndroidXVersions.APPCOMPAT}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${AndroidXVersions.FRAGMENT_KTX}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${AndroidXVersions.ACTIVITY_KTX}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${AndroidXVersions.CONSTRAINT_LAYOUT}"
    const val CONSTRAINT_LAYOUT_SOLVER =
        "androidx.constraintlayout:constraintlayout-solver:${AndroidXVersions.CONSTRAINT_LAYOUT}"
    const val CARD_VIEW = "androidx.cardview:cardview:${AndroidXVersions.CARD_VIEW}"
    const val RECYCLERVIEW =
        "androidx.recyclerview:recyclerview:${AndroidXVersions.RECYCLERVIEW}"
    const val VECTOR_DRAWABLE =
        "androidx.vectordrawable:vectordrawable:${AndroidXVersions.VECTOR_DRAWABLE}"
    const val VECTOR_DRAWABLE_ANIMATED =
        "androidx.vectordrawable:vectordrawable-animated:${AndroidXVersions.VECTOR_DRAWABLE}"
    const val SECURITY = "androidx.security:security-crypto:${AndroidXVersions.SECURITY_CRYPTO}"
    const val MATERIAL = "com.google.android.material:material:${AndroidXVersions.MATERIAL}"
}

object NavigationDependencies {
    //    Navigation KTX
    const val NAVIGATION_RUNTIME =
        "androidx.navigation:navigation-runtime-ktx:${BuildPluginsVersions.NAVIGATION}"
    const val NAVIGATION_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${BuildPluginsVersions.NAVIGATION}"
    const val NAVIGATION_UI_KTX =
        "androidx.navigation:navigation-ui-ktx:${BuildPluginsVersions.NAVIGATION}"
}

//ThirdParty
object

ThirdPartyDependencies {
    const val SDP = "com.intuit.sdp:sdp-android:${ThirdPartyVersions.SDP}"
    const val SSP = "com.intuit.ssp:ssp-android:${ThirdPartyVersions.SDP}"
    const val INLINE_ACTIVITY_RESULT =
        "com.github.florent37:inline-activity-result-kotlin:${ThirdPartyVersions.INLINE_ACTIVITY_RESULT}"
    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"
}

object RXDependencies {
    // RX Java
    const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:2.1.1"
    const val RX_JAVA = "io.reactivex.rxjava2:rxjava:2.2.6"
    const val INLINE_ACTIVITY_RESULT =
        "com.github.florent37:inline-activity-result-kotlin:1.0.4"
}

object HiltDaggerDependencies {
    // Hilt Dagger DI
    const val DAGGER_HILT = "com.google.dagger:hilt-android:${HiltDaggerVersion.HILT_DI}"
    const val DAGGER_COMPILER =
        "com.google.dagger:hilt-android-compiler:${HiltDaggerVersion.HILT_DI}"
    const val HILT_VM = "androidx.hilt:hilt-lifecycle-viewmodel:${HiltDaggerVersion.HILT_VM}"
    const val HILT_FRAGMENT = "androidx.hilt:hilt-navigation-fragment:${HiltDaggerVersion.HILT_VM}"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${HiltDaggerVersion.HILT_VM}"
}

object TestDependencies {
    const val JUNIT4 = "junit:junit:${TestDependenciesVersions.JUNIT4}"
    const val MOCKK = "io.mockk:mockk:${TestDependenciesVersions.MOCKK}"
    const val ROBOLECTRIC = "org.robolectric:robolectric:${TestDependenciesVersions.ROBOLECTRIC}"
    const val KLUENT = "org.amshove.kluent:kluent:${TestDependenciesVersions.KLUENT}"
    const val TESTRUNNER = "androidx.test:runner:${TestDependenciesVersions.TESTRUNNER}"
    const val TESTRULES = "androidx.test:rules:${TestDependenciesVersions.TESTRULES}"
    const val ESPRESSOCORE =
        "androidx.test.espresso:espresso-core:${TestDependenciesVersions.ESPRESSOCORE}"
    const val ESPRESSOINTENTS =
        "androidx.test.espresso:espresso-intents:${TestDependenciesVersions.ESPRESSOINTENTS}"
    const val TESTEXTENSIONS = "androidx.test.ext:junit:${TestDependenciesVersions.TESTEXTENSIONS}"
    const val HILTTESTING =
        "com.google.dagger:hilt-android-testing:${TestDependenciesVersions.HILTTESTING}"
    const val MOCKITO_INLINE =
        "org.mockito:mockito-inline:${TestDependenciesVersions.MOCKITO_INLINE}"
    const val MOCKITO_CORE =
        "org.mockito:mockito-inline:${TestDependenciesVersions.MOCKITO_CORE}"
    const val JUPITER =
        "org.junit.jupiter:junit-jupiter-params:${TestDependenciesVersions.JUPITER}"
}

object RoomDbDependencies {
    const val RUNTIME = "androidx.room:room-runtime:${RoomDbDependenciesVersion.ROOM_VERSION}"
    const val KTP = "androidx.room:room-compiler:${RoomDbDependenciesVersion.ROOM_VERSION}"
    const val KTX = "androidx.room:room-ktx:${RoomDbDependenciesVersion.ROOM_VERSION}"
}

