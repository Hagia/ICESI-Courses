package com.example.demo;
public class StopProcess{

    public Boolean stop;

    public StopProcess(){
        this.stop = false;
    }

    public StopProcess(Boolean s){
        this.stop = s;
    }

    public void setStop(Boolean s){
        this.stop = s;
    }

    public Boolean getStop(){
        return this.stop;
    }

    @Override
    public String toString(){
        return Boolean.toString(stop);
    }

}