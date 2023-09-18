plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.music"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.music"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation (project(":avloadingview"))
    implementation (project(":equalizerview"))
    implementation (project(":SeekArc_library"))
    implementation (project(":indicatorseekbar"))

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("com.google.android.play:core:1.10.3")
    implementation ("com.balysv:material-ripple:1.0.2")
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
//    implementation("com.github.jd-alexander:LikeButton:0.2.3")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
}