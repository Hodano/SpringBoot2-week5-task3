package pl.hodan.currencygame.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.hodan.currencygame.controller.CurrencyDataController;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;


@Service
public class CurrencyGameService {
    private CurrencyDataController currencyDataController;
    private String nameOfCurrency;
    private double targetValue;

    public CurrencyGameService(CurrencyDataController currencyDataController) {
        this.currencyDataController = currencyDataController;
        this.nameOfCurrency = getRandomNameCurrency(getMapCurrency());
        this.targetValue = Math.floor(getMapCurrency().get(nameOfCurrency) * 100) / 100;
    }

    private Map<String, Double> getMapCurrency() {
        return currencyDataController.getCurrenciesRelativePln().getPln();
    }

    private String[] getCurrencysNames(Map<String, Double> currencyMap) {
        if (currencyMap.isEmpty())
            throw new NoSuchElementException("Map is empty");

        String[] keys = currencyMap.keySet().toArray(new String[0]);
        return keys;
    }

    public String getRandomNameCurrency(Map<String, Double> currencyMap) {
        if (currencyMap.isEmpty())
            throw new NoSuchElementException("Map is empty");

        int randIndex = new Random().nextInt(currencyMap.size());

        return getCurrencysNames(currencyMap)[randIndex];
    }

    @EventListener(ApplicationReadyEvent.class)
    public void PlayCurrencyGame() {
        Scanner scanner = new Scanner(System.in);
        double choice = 0;

        System.out.println(nameOfCurrency);
        System.out.println("Odgadnij wartosc waluty względem Złotówki do dwóch miejsc po przecinku");

        while (targetValue != choice) {
            choice = scanner.nextDouble();
            if (choice > targetValue)
                System.out.println("Za dużo");
            else System.out.println("Za mało");
        }
        System.out.println("Udało Ci się");

    }


}
