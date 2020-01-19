package com.example.retrofit.demo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.function.BiConsumer;

public class CallbackFunction<T> implements Callback<T> {

    private final BiConsumer<Call<T>, Response<T>> onResponse;

    private final BiConsumer<Call<T>, Throwable> onFailure;

    public CallbackFunction(Builder<T> builder) {
        this.onResponse = builder.onResponse;
        this.onFailure = builder.onFailure;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onResponse.accept(call, response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        onFailure.accept(call, throwable);
    }

    public static class Builder<T1> {
        private BiConsumer<Call<T1>, Response<T1>> onResponse;
        private BiConsumer<Call<T1>, Throwable> onFailure;

        public Builder(){}

        public Builder<T1> onResponse(BiConsumer<Call<T1>, Response<T1>> onResponse) {
            this.onResponse = onResponse;
            return this;
        }

        public Builder<T1> onFailure(BiConsumer<Call<T1>, Throwable> onFailure) {
            this.onFailure = onFailure;
            return this;
        }

        public CallbackFunction<T1> build(){
            return new CallbackFunction<>(this);
        }
    }

}
