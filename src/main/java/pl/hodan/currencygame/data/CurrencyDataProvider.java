package pl.hodan.currencygame.data;

import org.springframework.stereotype.Repository;
import pl.hodan.currencygame.controller.CurrencyDataController;

import java.util.Map;

@Repository
public class CurrencyDataProvider {
    private final CurrencyDataController currencyDataController;

    public CurrencyDataProvider(CurrencyDataController currencyDataController) {
        this.currencyDataController = currencyDataController;
    }

    public Map<String, Double> getCurrencyMap() {
        return currencyDataController.getCurrenciesRelativePln().getPln();
    }
}
