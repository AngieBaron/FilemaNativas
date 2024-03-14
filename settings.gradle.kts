 pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url="https://jitpack.io" )// Librerias
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url="https://jitpack.io" )//Librerias
    }
}

    rootProject.name = "AppCitas"
    include(":app")
