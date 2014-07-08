Build
=====

The library is written with Android Studio and has Gradle support.

This module is yet to be pushed to Maven Central as an AAR.

You can add this library to your project adding a dependency to your `build.gradle`, or your can reference this project as a library (from Eclipse) or add it as a module (from IntelliJ).


## Referencing this module in Android Studio
  - clone a copy of this repository, or download it
  
    `https://github.com/Project-SILPA/sdk-transliteration`
  - Select File -> New Module -> Import existing project -> set path to the cloned/downloaded repository
  - Add the following to `settings.gradle` if not automatically included. Example :
  
    `include ':MyApp', ':sdk-transliteration'`
  - Add the following to dependencies in `build.gradle` of the project to which you want to reference this module
   
## 
    dependencies {
        compile project(':sdk-transliteration')
    }

