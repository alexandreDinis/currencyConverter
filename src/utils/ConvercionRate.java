package utils;

import models.Rate;
import service.ExchangeRateAPI;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class ConvercionRate {


    HashMap<Integer, String> currencyMap = CurrencyHashMap.createCurrencyMap();
    ExchangeRateAPI ex = new ExchangeRateAPI();
    Scanner  input = new Scanner(System.in);
    Messages msg = new Messages();
    protected String   op  = "S";
    protected int number = 0;
    protected double value = 0.0;
    protected String base,target,sValue;


    public void conversionStart(){

        input.useLocale(Locale.US);

        while(true){

            if(!op.contentEquals("S")){
                System.out.println(msg.end);
                input.close();
                break;

            }else {

                msg.menu();
                System.out.println(msg.extendMenu);

                try {
                    int number = input.nextInt();
                    if(number == 1){
                        msg.fullMenu();
                    }
                }catch (InputMismatchException e){

                    System.out.println(msg.error);
                    input.nextLine();
                }

                while (true) {
                    System.out.println(msg.ChooseBase);

                    try {
                        number = input.nextInt();

                        if (currencyMap.containsKey(number)) {
                            base = currencyMap.get(number);
                            break;

                        } else {

                            System.out.println(msg.notOption);
                        }
                    } catch (InputMismatchException e) {

                        System.out.println(msg.error);
                        input.nextLine();
                    }
                }
                while (true){
                    System.out.println(msg.chooseTager);

                    try {
                        number = input.nextInt();

                        if(currencyMap.containsKey(number)){
                            target = currencyMap.get(number);
                            break;

                        }else{

                            System.out.println(msg.notOption);
                        }
                    }catch (InputMismatchException e) {

                        System.out.println(msg.error);
                        input.nextLine();
                    }
                }
                while (true){

                    System.out.println(msg.value);
                    try {
                        value = input.nextDouble();
                        break;

                    }catch (InputMismatchException e){

                        System.out.println(msg.dotError);
                        input.nextLine();
                    }
                }
                System.out.println(msg.loading);
                System.out.println();
                Rate rate = ex.search(base, target, value);
                System.out.println(rate);
                System.out.println();
            }
        }
    }
}
