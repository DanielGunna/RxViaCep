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
