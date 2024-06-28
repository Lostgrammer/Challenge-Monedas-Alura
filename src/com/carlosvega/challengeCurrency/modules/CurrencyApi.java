package com.carlosvega.challengeCurrency.modules;

import java.util.Map;

public record CurrencyApi(String base_code,Map <String, Double> conversion_rates) {
}
