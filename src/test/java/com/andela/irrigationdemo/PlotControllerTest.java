package com.andela.irrigationdemo;

import com.andela.irrigationdemo.models.Plot;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PlotControllerTest {

    private static final String BASE_URL = "http://localhost:8080/api/plots";

    @Test
    public void testCanCreateReadAndDeletePlot() {

        String testname = RandomStringUtils.randomAlphabetic(7);

        RestTemplate restTemplate = new RestTemplate();
        Plot plot = new Plot();
        plot.setName(testname);
        plot.setLatitude((float) 40.5);
        plot.setLongitude((float) 2.5);
        plot.setWidth(100);
        plot.setLength(105);

        ResponseEntity<Plot> responseEntity = restTemplate.postForEntity(BASE_URL, plot, Plot.class);

        Plot[] plots = restTemplate.getForObject(BASE_URL, Plot[].class);
        Assertions.assertThat(plots).extracting(Plot::getName).contains(testname);

        restTemplate.delete(BASE_URL + "/"+ responseEntity.getBody().getId());
        Assertions.assertThat(restTemplate.getForObject(BASE_URL, Plot[].class)).extracting(Plot::getName).doesNotContain(testname);
    }
}
