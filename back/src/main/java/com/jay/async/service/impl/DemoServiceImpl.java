package com.jay.async.service.impl;

import com.jay.async.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.CompletableFuture;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    @Override
    public CompletableFuture<String> sayHello(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Hello World");
            return String.format("Hello: %s", name);
        });
    }
}
