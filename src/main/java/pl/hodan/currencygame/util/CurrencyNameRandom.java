package pl.hodan.currencygame.util;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

@Component
public class CurrencyNameRandom {

    public String getRandomNameCurrency(Map<String, Double> currencyMap) {
        if (currencyMap.isEmpty())
            throw new NoSuchElementException("Map is empty");

        int randIndex = new Random().nextInt(currencyMap.size());

        return getCurrencyNames(currencyMap)[randIndex];
    }

    private String[] getCurrencyNames(Map<String, Double> currencyMap) {
        if (currencyMap.isEmpty())
            throw new NoSuchElementException("Map is empty");

        String[] keys = currencyMap.keySet().toArray(new String[0]);
        return keys;
    }

}
