import models.Rate;
import service.ExchangeRateAPI;

import java.io.IOException;

public class CurrencyConverterMenu {
    public static void main(String[] args) throws IOException {

        ExchangeRateAPI ex = new ExchangeRateAPI();

        Rate rate =  ex.search("EUR","BRL","10.50");

        System.out.println(rate);
    }
}