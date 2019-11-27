package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class ProcessRepository {

    private ArrayList<String> header;

    private ArrayList<String> body;

    public ProcessRepository(){
        body = new ArrayList<String>();
    }

    public void saveHeader(String header) {
        if (this.header != null)
            this.header.set(0, header);
        this.header = new ArrayList<>();
        this.header.add(header);
    }

    public void saveBodyRow(String row) {
        this.body.add(row);
    }

    public ArrayList<String> getHeader(){
        return header;
    }

    public ArrayList<String> getBody(){
        return body;
    }

    public void reset(){
        this.body = new ArrayList<>();
    }
}