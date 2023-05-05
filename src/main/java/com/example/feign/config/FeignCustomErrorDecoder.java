package com.example.feign.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignCustomErrorDecoder implements ErrorDecoder {

    @Override public Exception decode(String methodKey, Response response) {

        switch (response.status()) {
            case 400:
                log.error("Error in request went through feign client");
                //handle exception
                return new Exception("Bad Request Through Feign");
            case 401:
                log.error("Error in request went through feign client");
                //handle exception
                return new Exception("Unauthorized Request Through Feign");
            case 404:
                log.error("Error in request went through feign client");
                //handle exception
                return new Exception("Unidentified Request Through Feign");
            default:
                log.error("Error in request went through feign client");
                //handle exception
                return new Exception("Common Feign Exception");
        }
    }

}