package main.java

/**
 * Create by bolo on 04/06/2018
 */
object Versions {
    val support_lib = "27.1.1"
    val constraint = "1.0.2"
    val glide = "4.2.0"
    val retrofit = "2.4.0"
    val okhttp = "3.8.0"
    val dagger = "2.11"
    val arch = "1.1.1"
    val arch_room = "1.1.0"
    val ktx = "0.3"
    val kotlin_coroutines = "0.24.0"
    val kotlin_lib = "1.2.51"

}

object Libs {
    val appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
    val support_v4 = "com.android.support:support-v4:${Versions.support_lib}"
    val support_media_compat = "com.android.support:support-media-compat:${Versions.support_lib}"
    val recyclerview = "com.android.support:recyclerview-v7:${Versions.support_lib}"
    val design = "com.android.support:design:${Versions.support_lib}"
    val constraint = "com.android.support.constraint:constraint-layout:${Versions.constraint}"
    val kotlin_lib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin_lib}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val dagger = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val dagger_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val arch_room = "android.arch.persistence.room:runtime:${Versions.arch_room}"
    val arch_room_compiler = "android.arch.persistence.room:compiler:${Versions.arch_room}"
    val arch_extensions = "android.arch.lifecycle:extensions:${Versions.arch}"
    val arch_viewmodel = "android.arch.lifecycle:viewmodel:${Versions.arch}"
    val arch_livedata = "android.arch.lifecycle:livedata:${Versions.arch}"
    val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
    val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin_coroutines}"
}