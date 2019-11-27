package com.example.demo.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.example.demo.repository.*;
import com.example.demo.repository.ProcessRepository;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CsvReader {

    @Autowired
    private ProcessRepository repository;

    public void readCsv() {

        repository.reset();
        String dir = System.getProperty("user.dir") + "/data/pr.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(dir)));
            repository.saveHeader(reader.readLine());
            
            String line = reader.readLine();

            while(line != null){
                repository.saveBodyRow(line);
                line = reader.readLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ArrayList<String>[] getData(){
        ArrayList<String>[] data = new ArrayList[2];
        data[0] = repository.getHeader();
        data[1] = repository.getBody();
        return data;
    }

}