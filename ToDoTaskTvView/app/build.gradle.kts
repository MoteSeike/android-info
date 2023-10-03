plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.todotasktvview"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.todotasktvview"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.leanback:leanback:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation ("org.java-websocket:Java-WebSocket:1.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.3.0")
    implementation("com.squareup.retrofit2:converter-gson:2.3.0")
    implementation("com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0")
}