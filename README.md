# RxViaCep
A simple reactive android implementation  to fetch information provided by ViaCep Api  about brazilian postal code addresses.

## Setup

To use this library your `minSdkVersion` must be >= 16.

In order to use the library, you must to configurate your gradle scripts as described below:

**1. Gradle dependency** (recommended)

  -  Add the following to your project level `build.gradle`:
 
```gradle
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
```
  -  Add this to your app `build.gradle`:
 
```gradle
dependencies {
	implementation 'com.github.danielgunna:RxViaCep:1.0.0'
}
```

## Usage

Call RxViaCep  method ```withCep(String cep)``` then call subscribe : 

```java
 RxViaCep.with("12345-789")
          .subscribe(
              addressResponse -> {
                //use response to do whatever you want
              },
              err -> {
                //handle errors
              }
          );
     

```

