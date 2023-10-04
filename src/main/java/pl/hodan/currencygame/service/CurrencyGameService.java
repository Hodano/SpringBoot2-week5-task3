package pl.hodan.currencygame.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.hodan.currencygame.data.CurrencyDataProvider;
import pl.hodan.currencygame.util.CurrencyNameRandom;
import pl.hodan.currencygame.util.UserInput;


@Service
public class CurrencyGameService {
    private final CurrencyDataProvider currencyDataProvider;
    private final CurrencyNameRandom currencyNameRandom;
    private final UserInput userInput;
    private final String nameOfCurrency;
    private final double targetValue;

    public CurrencyGameService(CurrencyDataProvider currencyDataProvider, CurrencyNameRandom currencyNameRandom, UserInput userInput) {
        this.currencyDataProvider = currencyDataProvider;
        this.currencyNameRandom = currencyNameRandom;
        this.userInput = userInput;
        this.nameOfCurrency = currencyNameRandom.getRandomNameCurrency(currencyDataProvider.getCurrencyMap());
        this.targetValue = Math.floor(currencyDataProvider.getCurrencyMap().get(nameOfCurrency) * 100) / 100;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void PlayCurrencyGame() {
        double choice = 0;

        System.out.println(nameOfCurrency);
        System.out.println("Odgadnij wartosc waluty względem Złotówki do dwóch miejsc po przecinku");

        while (targetValue != choice) {
            choice = userInput.getUserInput();
            if (choice > targetValue)
                System.out.println("Za dużo");
            else System.out.println("Za mało");
        }
        System.out.println("Udało Ci się");

    }


}
