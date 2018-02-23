package br.gunna.rxviacep;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

interface ViaCepAPI {

    @GET("{cep}/json")
    Observable<AddressResponse> getAddress(@Path("cep") String cep);

}
