# [RxViaCep](https://danielgunna.github.io/RxViaCep/)
 
[![Release](https://jitpack.io/v/danielgunna/RxViaCep.svg)](https://jitpack.io/#danielgunna/RxViaCep)

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
