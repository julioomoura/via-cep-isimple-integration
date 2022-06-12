package com.julio.CICD.Demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponentsBuilder;

import static org.mockito.ArgumentMatchers.anyString;


@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {

    @Autowired
    private AddressController addressController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ViaCepService service;

    @Test
    void validateInjections() {
        Assertions.assertNotNull(addressController);
    }

    @Test
    void returnNoContentWhenServiceReturnsNull() throws Exception {
        Mockito.when(service.getAddressFromViaCep(anyString())).thenReturn(null);

        String path = UriComponentsBuilder.fromUriString("/address")
                .buildAndExpand()
                .getPath();

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(path + "/72812520")).andReturn().getResponse();

        Assertions.assertEquals(response.getStatus(), 204);
    }

    @Test
    void returnsOkWhenServiceReturnsViaCepModel() throws Exception {
        ViaCepModel mockResponse = new ViaCepModel();

        mockResponse.setCep("7280000");
        mockResponse.setBairro("Centro");
        mockResponse.setDdd("61");
        mockResponse.setUf("GO");
        mockResponse.setLocalidade("Luziânia");

        Mockito.when(service.getAddressFromViaCep(anyString())).thenReturn(mockResponse);

        String path = UriComponentsBuilder.fromUriString("/address")
                .buildAndExpand()
                .getPath();
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(path + "/72800000"))
                .andReturn().getResponse();


        Assertions.assertEquals(response.getStatus(), 200);
    }
}
