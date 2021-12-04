package com.stitchable.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stitchable.api.Shop;
import lombok.extern.log4j.Log4j2;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Log4j2
public class EtsyShopDao {

    Shop getEtsyResponse(int shopId) {
        String url = "https://openapi.etsy.com/v2/shops/" + shopId + "?api_key=wtj49aahjtf5wqf7apami7mn";
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


}
