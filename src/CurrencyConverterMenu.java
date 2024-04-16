

import utils.ConvercionRate;

import java.io.IOException;


public class CurrencyConverterMenu {
    public static void main(String[] args) throws IOException {

        ConvercionRate convercionRate = new ConvercionRate();

        convercionRate.conversionStart();

        /*
        ExchangeRateAPI ex = new ExchangeRateAPI();

        Rate rate = ex.search("EUR", "BRL", "10.50");

        System.out.println(rate);

        HashMap<Integer, String> currencyMap = CurrencyHashMap.createCurrencyMap();

        String teste = currencyMap.get(1);

        System.out.println(teste);
        */


    }
}