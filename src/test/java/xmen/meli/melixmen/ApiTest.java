package xmen.meli.melixmen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import xmen.meli.melixmen.persistencia.entidades.Humano;



@ApiTestConfig
public class ApiTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void guardarMutanteOK() {
        String[] dna = { "AAGCGA", "CAGTGC", "TTATGT", "AGAAGG", "AAAATA", "TCACTG" };
        Humano humano = new Humano(null, dna, null);
        webTestClient.post().uri("/mutant/").body(BodyInserters.fromValue(humano)).exchange().expectStatus().isOk();
    }

    @Test
    void guardarForbidden() {
        String[] dna = { "cccccc", "acacac", "cacaca", "tgtgtg", "tatata", "ccacca" };
        Humano humano = new Humano(null, dna, null);
        webTestClient.post().uri("/mutant/").body(BodyInserters.fromValue(humano)).exchange().expectStatus()
                .isForbidden();
    }

    @Test
    public void EstadisticaOk() {
        webTestClient.get().uri("/stats").exchange().expectStatus().isOk();

    }

}