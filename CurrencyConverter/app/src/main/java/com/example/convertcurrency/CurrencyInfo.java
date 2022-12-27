package com.example.convertcurrency;

public class CurrencyInfo {

    @Override
    public String toString() {
        return _country + "-" + _name;
    }

    public float convertToCurrency(float value, CurrencyInfo currency){
        return value * currency._weight_on_usd / this._weight_on_usd;
    }
    public float convertToCurrency(float value, float currency_weight_on_usd){
        return value * currency_weight_on_usd / this._weight_on_usd;
    }

    public CurrencyInfo(String name, String country, String iso_code,
                        String symbol, float weight_on_usd) {
        this._name = name;
        this._country = country;
        this._iso_code = iso_code;
        this._symbol = symbol;
        this._weight_on_usd = weight_on_usd;
    }

    public String getName() {
        return _name;
    }

    public String getCountry() {
        return _country;
    }

    public String getISOCode() {
        return _iso_code;
    }

    public String getSymbol() {
        return _symbol;
    }

    public float getWeight() {
        return _weight_on_usd;
    }

    public void setName(String name) {
        this._name = name;
    }

    public void setCountry(String country) {
        this._country = country;
    }

    public void setISOCode(String iso_code) {
        this._iso_code = iso_code;
    }

    public void setSymbol(String symbol) {
        this._symbol = symbol;
    }

    public void setWeight(float weight_on_usd) {
        this._weight_on_usd = weight_on_usd;
    }

    private String _name;
    private String _country;
    private String _iso_code;
    private String _symbol;
    private float _weight_on_usd;
}
