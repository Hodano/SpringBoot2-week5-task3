package pl.hodan.currencygame.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CurrencyData {
    public CurrencyData() {
    }

    @JsonProperty("date")
    private String data;
    @JsonProperty("pln")
    private Map<String, Double> pln;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, Double> getPln() {
        return pln;
    }

    public void setPln(Map<String, Double> pln) {
        this.pln = pln;
    }

    @Override
    public String toString() {
        return "CurrencyData{" +
                "data='" + data + '\'' +
                ", pln=" + pln +
                '}';
    }
}
