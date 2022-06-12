package com.julio.CICD.Demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class ViaCepService {

    private static final String BASE_URL = "https://viacep.com.br/ws/";

    @Autowired
    private final ObjectMapper objectMapper;

    public ViaCepService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ViaCepModel getAddressFromViaCep(String cep) throws URISyntaxException, IOException, InterruptedException {


        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL + cep + "/json"))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        try {
            return objectMapper.readValue(response.body(), ViaCepModel.class);
        } catch (JsonProcessingException e) {
            System.out.println("DEU ERRO: " + e);
            return null;
        }
    }
}
