package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Rate;
import service.ExchangeRateAPI;
import service.FileGenerator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ConvercionRate {


    HashMap<Integer, String> currencyMap = CurrencyHashMap.createCurrencyMap();
    ExchangeRateAPI ex = new ExchangeRateAPI();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd 'hora:' HH:mm");
    ArrayList<Rate> list = new ArrayList<>();
    Scanner  input = new Scanner(System.in);
    Messages msg = new Messages();

    protected String   op  = "S";
    protected int number = 0;
    protected double value = 0.0;
    protected String base,target,salve;
    protected String data = dateFormat.format(date);

    public void conversionStart(){

        input.useLocale(Locale.US);

        while(true){

            if(op.contentEquals("N")){
                System.out.println(msg.end);
                input.close();
                break;

            }else if(op.contentEquals("S")){

                msg.menu();

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
                rate.setData(data);
                list.add(rate);
                System.out.println(gson.toJson(rate));
                System.out.println();
                input.nextLine();

                System.out.println(msg.salveFile);
                salve = input.nextLine().toUpperCase(Locale.ROOT);

                // salvar arquivo
                while(true) {

                        try {

                            if (salve.contentEquals("S")) {
                                FileGenerator fileGenerator = new FileGenerator();
                                fileGenerator.salveFile(data, rate);
                                System.out.println(msg.salvedSuccessfully);
                                break;

                            }else if(salve.contentEquals("N")){
                                break;
                            }else{
                                System.out.println(msg.notOption);
                                System.out.println(msg.salveFile);
                                salve = input.nextLine().toUpperCase(Locale.ROOT);
                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                // Mostrar historico

            }else if(op.contentEquals("H")){
                System.out.println(msg.startHistory);
                System.out.println(gson.toJson(list));
                System.out.println(msg.endtHistory);
                System.out.println();
                System.out.println(msg.salveFile);
                salve = input.nextLine().toUpperCase(Locale.ROOT);
                while(true) {

                    try {

                        if (salve.contentEquals("S")) {
                            FileGenerator fileGenerator = new FileGenerator();
                            fileGenerator.salveFileHistory(list,data);
                            System.out.println(msg.salvedSuccessfully);
                            break;

                        }else if(salve.contentEquals("N")){
                            break;
                        }else{
                            System.out.println(msg.notOption);
                            System.out.println(msg.salveFile);
                            salve = input.nextLine().toUpperCase(Locale.ROOT);
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }else{
                System.out.println(msg.notOption);
            }
            System.out.println(msg.replay);

            try {
                op = input.nextLine().toUpperCase();
            }catch (InputMismatchException e){
                System.out.println(msg.notOption);

            }
        }
    }
}
