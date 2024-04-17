package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Rate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileGenerator {

    public void salveFile(Rate rate) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(rate.getBase_code() + "-para-" + rate.getTarget_code() + ".json");
        writer.write(gson.toJson(rate));
        writer.close();
    }


    public void salveFileHistory(List<?> list, String data) throws IOException {

         String fileName = "Ultima-consulta-";
         fileName += data.replace('/', '_').replace(':', '_') + ".json";
         Gson gson = new GsonBuilder().setPrettyPrinting().create();
         try (FileWriter writer = new FileWriter(fileName)) {
             gson.toJson(list, writer);
        }
    }
}
