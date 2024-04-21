package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Rate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;

public class FileGenerator {

    public void createDirectory(String path) {

        File pasta = new File(path);

        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }

    public void salveFile(String data, Rate rate) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String directoryPath = "src/resources/savedFiles";
        createDirectory(directoryPath);

        String formattedDate = data.replace("/", "_").replace(":", "_");


        File file = new File(directoryPath, rate.getBase_code() + "-para-" + rate.getTarget_code() +"-" + formattedDate + ".json");


        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(rate, writer);
        }
    }


    public void salveFileHistory(List<?> list, String data) throws IOException {

        String fileName = "Historico-";
        String path = "src/resources/history";

        createDirectory(path);

        String filePath = path + "/" + fileName + data.replace('/', '_').replace(':', '_') + ".json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }
}