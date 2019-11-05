package com.example.demo.repository;

import java.util.ArrayList;

public class ProcessList{
    private ArrayList<Process> list;

    public ProcessList(int size){
        list = new ArrayList<>(size);
    }
}