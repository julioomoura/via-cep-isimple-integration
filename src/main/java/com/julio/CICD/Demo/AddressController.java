package com.julio.CICD.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class AddressController {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws";

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/address/{cep}")
    public ResponseEntity<ViaCepModel> getAddressByCep(@PathVariable("cep") String cep) throws IOException, URISyntaxException, InterruptedException {
        ViaCepModel address = viaCepService.getAddressFromViaCep(cep);
        return address != null ? ResponseEntity.ok(address) : ResponseEntity.noContent().build();
    }
}
