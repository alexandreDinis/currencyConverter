package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Rate;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {

    public void salveFile(Rate rate) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(rate.getBase_code() + "para" + rate.getTarget_code() + ".json");
        writer.write(gson.toJson(rate));
        writer.close();
    }
}
