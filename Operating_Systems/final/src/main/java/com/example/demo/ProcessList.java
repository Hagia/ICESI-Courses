package com.example.demo;

import java.util.ArrayList;

public class ProcessList {

    public ArrayList<StopProcess> stopList;

    public ProcessList(){
        this.stopList = new ArrayList<>();
    }

    public ProcessList(ArrayList<StopProcess> stopList){
        this.stopList = new ArrayList<>();
    }

    public ArrayList<StopProcess> getStopList(){
        return this.stopList;
    }

    public void fill(int size){
        this.stopList = new ArrayList<>();
        int i = 0;
        while(i < size){
            this.stopList.add(new StopProcess(false));
            i++;
        }
    }

    public  void setStopList(ArrayList<StopProcess> l){
        this.stopList = l;
    }

}