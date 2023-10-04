package pl.hodan.currencygame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.hodan.currencygame.model.CurrencyData;

import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class CurrencyDataController {
    private RestTemplate restTemplate;
    private Logger logger;

    public CurrencyDataController() {
        this.restTemplate = new RestTemplate();
        this.logger = LoggerFactory.getLogger(CurrencyDataController.class);
    }

    public CurrencyData getCurrenciesRelativePln() {
        URL url;
        try {
            url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/pln.json");

        } catch (MalformedURLException e) {
            logger.error("incorrect url format", e.getMessage());
            return new CurrencyData();
        } catch (Exception e) {
            logger.error("Error download date", e.getMessage());
            return new CurrencyData();
        }
        return restTemplate.getForObject(url.toString(), CurrencyData.class);
    }
}
