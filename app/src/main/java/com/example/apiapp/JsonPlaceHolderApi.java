package com.example.apiapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("Loader/Start/2237/wolfgold?casinolobbyurl=https%3A%2F%2Fgames.staging.irl.aws.tipicodev.de%2Fen%2F&funMode=False&language=en&launchApi=true&_sid64=R3fJpfl4GwmcsDzrNpvOyS1YEGM4agCkwxB.kjbzBzZZkbyfU0_GGg--&fbclid=IwAR2QL-cMjqKiDTczzoXH6OnU5pXrPbdnZ_KInP6MutSqluiVR4x3_I58fz0")
    Call<Post> getPosts();

}