/**
 MIT License

 Copyright (c) 2018 Daniel Gunna

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.

 */


package br.gunna.rxviacep;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

import static br.gunna.rxviacep.RetrofitException.Kind.HTTP;
import static br.gunna.rxviacep.RetrofitException.Kind.NETWORK;


/**
 * Created by Daniel on 23/02/18.
 */

public class RxViaCep {

    public static Observable<AddressResponse> withCep(String cep) {
        cep = cep.replace("-", "")
                .replace(".", "")
                .trim();

        final PublishSubject<AddressResponse> subject = PublishSubject.create();

        if (cep.length() != Constants.CEP_LENGTH) {
            subject.onError(new Throwable(Constants.CEP_INVALID_FORMAT_ERROR));
        } else {
            getCep(cep, subject);
        }

        return subject.asObservable();
    }

    private static void getCep(String cep, PublishSubject subject) {
        ViaCepService.getInstance()
                .getService()
                .getAddress(cep)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(addressResponse -> addressResponse != null ?
                        Observable.just(addressResponse) :
                        Observable.error(new Throwable(Constants.UNEXPECTED_ERROR_MSG))
                )
                .subscribe(
                        subject::onNext,
                        throwable -> {
                            if (throwable instanceof RetrofitException) {
                                RetrofitException exception = ((RetrofitException) throwable);
                                if (exception.getKind() == NETWORK)
                                    subject.onError(new Throwable(Constants.NETWORK_ERROR_MSG));
                                else if (exception.getKind() == HTTP && exception.getResponse().code() == 404)
                                    subject.onError(new Throwable(Constants.CEP_NOT_FOUND_ERROR_MSG));
                                else
                                    subject.onError(new Throwable(Constants.UNEXPECTED_ERROR_MSG));
                            } else
                                subject.onError(throwable);
                        }
                );

    }



}
