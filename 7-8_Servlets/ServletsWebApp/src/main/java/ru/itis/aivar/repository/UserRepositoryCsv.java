package ru.itis.aivar.repository;

import au.com.bytecode.opencsv.CSVWriter;
import ru.itis.aivar.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class UserRepositoryCsv implements UserRepository{
    private File csvFile = new File(getProjectPath()+"src/main/webapp/db/users.csv");

    @Override
    public void add(User user) {
        try {
            if(!csvFile.exists()){
                csvFile.createNewFile();
            }
            CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFile, true));
            csvWriter.writeNext(getRecord(user));
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void findByName() {

    }

    private String[] getRecord(User user){
        String data = user.getLogin()+","+user.getEmail()+","+user.getPassword();
        return data.split(",");
    }

    private String getProjectPath(){
        return "/home/aivar/Desktop/Semester3/IdeaProjects/ServletsWebApp/";
    }
}
