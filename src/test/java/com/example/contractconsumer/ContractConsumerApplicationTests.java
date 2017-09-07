package com.example.contractconsumer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.example:contract-provider:+:stubs:8090"}, workOffline = true)
public class ContractConsumerApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void helloWorld() {
        String message = restTemplate.getForObject("http://localhost:8090/hello", String.class);
        Assert.assertEquals(message, "{\"message\":\"Hello world\"}");
    }

}
