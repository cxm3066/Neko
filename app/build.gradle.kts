import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("org.jmailen.kotlinter") version "2.3.1"
    id("com.github.ben-manes.versions") version "0.28.0"
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.gms.google-services") apply false
}

val BUILD_TIME = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now(ZoneOffset.UTC))


android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        applicationId = "tachiyomi.mangadex"
        versionCode = 47
        versionName = "1.6.4.1"
        multiDexEnabled = true
        setProperty("archivesBaseName", "Neko")
        buildConfigField("String", "BUILD_TIME", "\"${BUILD_TIME}\"")
        ndk {
            abiFilters("armeabi-v7a", "arm64-v8a", "x86")
        }
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }

    }
    lintOptions {
        isAbortOnError = false
        isCheckReleaseBuilds = false
    }
    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("LICENSE.txt")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE")
    }

    compileOptions {
        setSourceCompatibility(1.8)
        setTargetCompatibility(1.8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
androidExtensions {
    isExperimental = true
}

dependencies {
// Modified dependencies
    implementation("com.github.inorichi:subsampling-scale-image-view:ac0dae7")

// Android support library
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.preference:preference:1.1.0")
    implementation("androidx.annotation:annotation:1.1.0")
    implementation("androidx.browser:browser:1.2.0")
    implementation("androidx.biometric:biometric:1.0.1")

    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("androidx.multidex:multidex:2.0.1")

    implementation("com.google.firebase:firebase-core:17.2.3")

    val lifecycle_version = "2.1.0"
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

// ReactiveX
    implementation("io.reactivex:rxandroid:1.2.1")
    implementation("io.reactivex:rxjava:1.3.8")
    implementation("com.jakewharton.rxrelay:rxrelay:1.2.0")
    implementation("com.f2prateek.rx.preferences:rx-preferences:1.0.2")
    implementation("com.github.pwittchen:reactivenetwork:0.13.0")

// Network client
    val okhttp_version = "4.2.1"
    implementation("com.squareup.okhttp3:okhttp:$okhttp_version")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttp_version")
    implementation("com.squareup.okio:okio:2.4.3")

// REST
    val retrofit_version = "2.6.2"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.squareup.retrofit2:adapter-rxjava:$retrofit_version")

// JSON
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.github.salomonbrys.kotson:kotson:2.5.0")

// Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:0.20.0")

// Disk
    implementation("com.jakewharton:disklrucache:2.0.2")
    implementation("com.github.inorichi:unifile:e9ee588")

// HTML parser
    implementation("org.jsoup:jsoup:1.12.2")

//Icons
    implementation("com.mikepenz:iconics-core:4.0.2@aar")
    implementation("com.mikepenz:iconics-views:4.0.2@aar")
    implementation("com.mikepenz:community-material-typeface:3.7.95.4-kotlin@aar")
    implementation("com.mikepenz:material-design-icons-dx-typeface:5.0.1.0-kotlin@aar")

// Job scheduling
    implementation("com.evernote:android-job:1.4.2")
    implementation("com.google.android.gms:play-services-gcm:17.0.0")

// Changelog
    implementation("com.github.gabrielemariotti.changeloglib:changelog:2.1.0")

// Database
    implementation("androidx.sqlite:sqlite:2.1.0")
    implementation("com.github.inorichi.storio:storio-common:8be19de@aar")
    implementation("com.github.inorichi.storio:storio-sqlite:8be19de@aar")
    implementation("io.requery:sqlite-android:3.31.0")

// Model View Presenter
    val nucleus_version = "3.0.0"
    implementation("info.android15.nucleus:nucleus:$nucleus_version")
    implementation("info.android15.nucleus:nucleus-support-v7:$nucleus_version")

// Dependency injection
    implementation("com.github.inorichi.injekt:injekt-core:65b0440")

// Image library
    val glide_version = "4.11.0"
    implementation("com.github.bumptech.glide:glide:$glide_version")
    implementation("com.github.bumptech.glide:okhttp3-integration:$glide_version")
    kapt("com.github.bumptech.glide:compiler:$glide_version")

// Transformations
    implementation("jp.wasabeef:glide-transformations:4.1.0")

// Logging
    implementation("com.jakewharton.timber:timber:4.7.1")

// UI
    implementation("com.dmitrymalkovich.android:material-design-dimens:1.4")
    implementation("com.github.dmytrodanylyk.android-process-button:library:1.0.4")
    implementation("eu.davidea:flexible-adapter:5.1.0")
    implementation("eu.davidea:flexible-adapter-ui:1.0.0")
    implementation("com.nononsenseapps:filepicker:2.5.2")
//switch this to material dialog file picker
    implementation("com.github.amulyakhare:TextDrawable:558677e")
    implementation("com.afollestad.material-dialogs:core:3.3.0")
    implementation("com.afollestad.material-dialogs:input:3.3.0")
    implementation("me.zhanghai.android.systemuihelper:library:1.0.0")
    implementation("com.nightlynexus.viewstatepageradapter:viewstatepageradapter:1.1.0")
    implementation("com.github.kizitonwose:AndroidTagGroup:1.6.0")
    implementation("com.github.chrisbanes:PhotoView:2.3.0")
    implementation("com.github.carlosesco:DirectionalViewPager:a844dbca0a")

// Conductor
    implementation("com.bluelinelabs:conductor:2.1.5")
    implementation("com.bluelinelabs:conductor-support:2.1.5") {
        exclude("group", "com.android.support")
    }
    implementation("com.github.inorichi:conductor-support-preference:a32c357")

// RxBindings
    val rxbindings_version = "1.0.1"
    implementation("com.jakewharton.rxbinding:rxbinding-kotlin:$rxbindings_version")
    implementation("com.jakewharton.rxbinding:rxbinding-appcompat-v7-kotlin:$rxbindings_version")
    implementation("com.jakewharton.rxbinding:rxbinding-support-v4-kotlin:$rxbindings_version")
    implementation("com.jakewharton.rxbinding:rxbinding-recyclerview-v7-kotlin:$rxbindings_version")

//badge library
    implementation("com.github.nekocode:Badge:2.1")

// Tests
    testImplementation("junit:junit:4.13")
    testImplementation("org.assertj:assertj-core:1.7.1")
    testImplementation("org.mockito:mockito-core:1.10.19")

    val robolectric_version = "3.1.4"
    testImplementation("org.robolectric:robolectric:$robolectric_version")
    testImplementation("org.robolectric:shadows-multidex:$robolectric_version")
    testImplementation("org.robolectric:shadows-play-services:$robolectric_version")


    implementation(kotlin("stdlib", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))

    val coroutines_version = "1.3.3"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    val acraVersion = "5.5.0"
    implementation("ch.acra:acra-http:$acraVersion")
    implementation("ch.acra:acra-mail:$acraVersion")
}

tasks.preBuild {
    dependsOn(tasks.lintKotlin)
}
tasks.lintKotlin {
    dependsOn(tasks.formatKotlin)
}

if (getGradle().getStartParameter().getTaskRequests().toString().contains("Standard")) {
    apply(mapOf("plugin" to "com.google.gms.google-services"))
}