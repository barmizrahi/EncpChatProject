package com.example.encpchatproject.service;

import com.example.encpchatproject.model.CryptoModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface CryptoAPI {

    @GET("prices?key=5373f6bfaffb7f8180e293237edb3f47")
    Observable<List<CryptoModel>> getData();

}
