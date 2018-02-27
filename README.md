# RxViaCep

[![Release](https://jitpack.io/v/danielgunna/RxViaCep.svg)]
(https://jitpack.io/#danielgunna/RxViaCep)

A simple reactive android implementation  to fetch information provided by ViaCep Api  about brazilian postal code addresses.

## Setup

To use this library your `minSdkVersion` must be >= 16.

In order to use the library, you must to configurate your gradle scripts as described below:

** Gradle dependency** 

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
	implementation 'com.github.danielgunna:RxViaCep:1.0.2'
}
```

## Usage

Call RxViaCep  method ```withCep(String cep)``` then call subscribe (note that i'm using lambdas, but you can get the same behavior using the traditional approach which is implement an ```Observer<AddressResponse>```.) : 

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

