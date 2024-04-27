package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Rate;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;

public class FileGenerator {

    private String data;
    private String formattedDate;


    public FileGenerator(String data){
        this.data = data;
        this.formattedDate = data.replace("/", "_").replace(":", "_");
    }


    public void createDirectory(String path) {

        File pasta = new File(path);

        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }


    public void salveFile( Rate rate) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String directoryPath = "src/resources/savedFiles";
        createDirectory(directoryPath);
        File file = new File(directoryPath, rate.getBase_code() + "-para-" + rate.getTarget_code() +"-" + formattedDate + ".json");

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(rate, writer);
        }
    }


    public void salveFileHistory(List<?> list) throws IOException {

        String fileName = "Historico-";
        String path = "src/resources/history";

        createDirectory(path);

        String filePath = path + "/" + fileName + formattedDate + ".json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }
}