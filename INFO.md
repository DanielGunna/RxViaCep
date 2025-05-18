# [RxViaCep](https://danielgunna.github.io/RxViaCep/)
[![HitCount](http://hits.dwyl.io/DanielGunna/RxViaCep.svg)](http://hits.dwyl.io/DanielGunna/RxViaCep)

[![Release](https://jitpack.io/v/danielgunna/RxViaCep.svg)](https://jitpack.io/#danielgunna/RxViaCep)

A simple reactive android implementation  to fetch information provided by ViaCep Api  about brazilian postal code addresses.

## Usage

Call RxViaCep  method ```withCep(String cep)``` then call subscribe (note that i'm using lambdas, but you can get the same behavior using the traditional approach which is implement an ```Observer<AddressResponse>```.) : 

```java
 RxViaCep.withCep("12345-789")
          .subscribe(
              addressResponse -> {
                //use response to do whatever you want
              },
              err -> {
                //handle errors
              }
          );
     

```

