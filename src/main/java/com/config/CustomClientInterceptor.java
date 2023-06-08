package com.config;

import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IHttpRequest;
import ca.uhn.fhir.rest.client.api.IHttpResponse;
import ca.uhn.fhir.util.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomClientInterceptor implements IClientInterceptor {


    private StopWatch requestStopWatch;


    @Autowired
    public CustomClientInterceptor() {
        this.requestStopWatch = new StopWatch();
    }

    @Override
    public void interceptRequest(IHttpRequest theRequest) {
        requestStopWatch.restart();
    }

    @Override
    public void interceptResponse(IHttpResponse theResponse) throws IOException {
        long responseTimeMillis = requestStopWatch.getMillisAndRestart();

        System.out.println("Response time using a Custom Client Interceptor: " + responseTimeMillis + " ms");
    }
}
