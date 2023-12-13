plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.mak.tvshows"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mak.tvshow"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField(
                "String",
                "THUMBNAIL_BASE_URL",
                "\"https://www.themoviedb.org/t/p/w440_and_h660_face\""
            )
            buildConfigField(
                "String",
                "TOKEN",
                "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1ZTdmZjM1N2VhMjZlYWE3YWJiYTIyNzkwMjgzNGVjZiIsInN1YiI6IjY1Nzk4ZWQ3N2EzYzUyMDBjYTdhODdhNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.HMPB-OYib2u2au8LMM0_kt1AvR5_4VYN5dif6CHAo1A\""
            )
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField(
                "String",
                "THUMBNAIL_BASE_URL",
                "\"https://www.themoviedb.org/t/p/w440_and_h660_face\""
            )
            buildConfigField(
                "String",
                "TOKEN",
                "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1ZTdmZjM1N2VhMjZlYWE3YWJiYTIyNzkwMjgzNGVjZiIsInN1YiI6IjY1Nzk4ZWQ3N2EzYzUyMDBjYTdhODdhNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.HMPB-OYib2u2au8LMM0_kt1AvR5_4VYN5dif6CHAo1A\""
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.1"
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Add Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.5")

    //material3
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material:material-icons-extended:1.5.4")

    // Image loading
    implementation("io.coil-kt:coil-compose:2.1.0")
}