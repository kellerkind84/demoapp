package com.example.demoapp;

import com.example.demoapp.rest.exception.ValidationError;
import com.example.demoapp.rest.model.ResourceDescription;
import com.example.demoapp.rest.model.Type;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RequiredArgsConstructor
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    private final TestRestTemplate template = new TestRestTemplate();


    @Test
    void test_Valid_Request_With_Match() {
        ResourceDescription description = ResourceDescription.builder().energy(80).type(Type.SATELLITE).build();
        ResponseEntity<ResourceDescription> result = template.exchange(uri(), HttpMethod.POST, new HttpEntity<>(description), ResourceDescription.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getEnergy()).isGreaterThan(80);
    }

    @Test
    void test_Valid_Request_Without_Match() {
        ResourceDescription description = ResourceDescription.builder().energy(95).type(Type.SATELLITE).build();
        ResponseEntity<ResourceDescription> result = template.exchange(uri(), HttpMethod.POST, new HttpEntity<>(description), ResourceDescription.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNull();
    }

    @Test
    void test_Invalid_Request() {
        ResourceDescription description = ResourceDescription.builder().energy(105).type(Type.SATELLITE).build();
        ResponseEntity<ValidationError> result = template.exchange(uri(), HttpMethod.POST, new HttpEntity<>(description), ValidationError.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getMessage()).contains("Fehler im Feld");
    }

    private String uri() {
        return UriComponentsBuilder
                .fromPath("/start")
                .scheme("http")
                .host("localhost")
                .port(port)
                .encode()
                .toUriString();
    }

}
