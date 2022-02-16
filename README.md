# JCSectionedProgressIndicator
A Sectioned Progress Indicator built in Jetpack Compose. Easily specify number of sections with corresponding section colors

How it looks like

https://user-images.githubusercontent.com/37780207/154261234-7a9f236e-ba83-4714-89d9-2a150d45aab9.mp4



## Installation

> Step 1

Add this in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

> Step 2. Add the dependency

```groovy
dependencies {
    implementation 'com.github.develNerd:JCSectionedProgressIndicator:1.0.0'
}
```

## Usage

Take a look at the [sample](https://github.com/develNerd/JCSectionedProgressIndicator/tree/main/JCSectionedProgressIndicator)  usescase for more details on implementation

> Step 1

Call the CircularSectionedIndicator() method and set required params

```
  val listOfColors = listOf<Color>(Color.Red, Color.Green, Color.Blue,Color.LightGray,
                    Color.Yellow)
  
 CircularSectionedIndicator(sections = 4,progressValue = progressAntiClockWise,strokeValue = 3.dp,indicatorSize = 100.dp,listOfColors = listOfColors)

```

