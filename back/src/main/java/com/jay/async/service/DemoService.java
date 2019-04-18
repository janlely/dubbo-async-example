package com.jay.async.service;

import java.util.concurrent.CompletableFuture;

public interface DemoService {
    CompletableFuture<String> sayHello(String name);
}
