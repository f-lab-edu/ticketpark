package com.ticketpark.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Response<T> {
    private final String resultCode;
    private final T result;

    public static<T> Response<T> success(){
        return new Response<T>("SUCCESS", null);
    }

    public static<T> Response<T> success(T result) {
        return new Response<T>("SUCCESS", result);
    }

    public static<T> Response<Void> error(String resultCode) {
        return new Response<Void>(resultCode, null);
    }
    public static<T> Response<T> error(T result){
        return new Response<T>("ERROR", result);
    }
}
