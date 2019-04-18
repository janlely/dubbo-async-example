package com.jay.async;

import com.jay.async.service.DemoService;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.protocol.file.FileURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/")
public class MainController {

    @Value("${dubbo.application.name}")
    private String name;

    @Reference(version = "1.0.0", timeout = 10000)
    private DemoService demoService;

    @RequestMapping("/helloAsync")
    public @ResponseBody String helloAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = demoService.sayHello(name);
        String result = future.get();
        return result;
    }
}
