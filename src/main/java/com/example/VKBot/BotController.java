package com.example.VKBot;

import com.example.VKBot.model.Request;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@RestController
@RequestMapping("/chat")
public class BotController {

    private final Random random = new Random();
    URL url;
    HttpClient client;
    HttpGet httpGet;


    @PostMapping("/1")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> postMessage(@RequestBody Request request) {
        if (request != null) {
            if (request.getType().equals("confirmation"))
                return new ResponseEntity<>("2e2ed453", new HttpHeaders(), HttpStatus.OK);
            String answerBot = "Вы сказали: " + request.getObject().getBody();
            String response = createResponse(String.valueOf(request.getObject().getUser_id()), URLEncoder.encode(answerBot, StandardCharsets.UTF_8));

            try {
                url = new URL(response);
                client = HttpClientBuilder.create().build();
                httpGet = new HttpGet(String.valueOf(url));
                httpGet.addHeader("accept", "application/x-www-form-urlencoded");
                httpGet.addHeader("Content-length", String.valueOf(answerBot.getBytes(StandardCharsets.UTF_8).length));

                HttpResponse responsee = client.execute(httpGet);


                BufferedReader br = new BufferedReader(new InputStreamReader((responsee.getEntity().getContent())));
                String outputCode;


                while ((outputCode = br.readLine()) != null) {
                    System.out.println(outputCode);
                }
                br.close();
            } catch (IOException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>("ok", new HttpHeaders(), HttpStatus.OK);
    }
/*
    @GetMapping("/1")
    public ResponseEntity<String> send(){
        System.out.println("fsdfdsfsd");
        return new ResponseEntity<>(String.valueOf(url), new HttpHeaders(), HttpStatus.OK);
    }*/



    public String createResponse(String userId, String message){
        String token = "f6115d0a0a2f9f1248fcca4669bff2c849803ebf58a964f82b4ff5a7d97adb4b83ddde9e6e3d98c15ba73";
        String vkApiMethod = "https://api.vk.com/method/messages.send?access_token=" + token + "&v=5.50";
        return vkApiMethod + "&user_id=" + userId + "&message=" + message + "&random_id=" + random.nextInt(10);
    }


}
