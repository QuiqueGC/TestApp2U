// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    //para pasar parámetros a través del navController
    id("androidx.navigation.safeargs.kotlin") version "2.7.1" apply false
    //ksp
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false

    //dagger Hilt
    id("com.google.dagger.hilt.android") version "2.48" apply false
}