package com.stitchable.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stitchable.api.Shop;
import lombok.extern.log4j.Log4j2;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

@Log4j2
public class EtsyShopDao {

    private static final String ETSY_PROPERTIES = "/etsyapi.properties";
    private Properties properties;

    public Shop getEtsyResponse(int shopId) {
        loadProperties();
        String website = properties.getProperty("url");
        String apiKey = properties.getProperty("key");
        String url = website + shopId + apiKey;
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        Shop etsyShop = null;

        try {
            etsyShop = mapper.readValue(response, Shop.class);
        } catch (JsonProcessingException e) {
            log.error("JSON processing exception: " + e);
        } catch (Exception e) {
            log.error("Exception: " + e);
        }
        return etsyShop;
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream(ETSY_PROPERTIES));
        } catch (IOException ioe) {
            log.error("Database.loadProperties()...Cannot load the properties file", ioe);
        } catch (Exception e) {
            log.error("Database.loadProperties()...", e);
        }

    }


}
