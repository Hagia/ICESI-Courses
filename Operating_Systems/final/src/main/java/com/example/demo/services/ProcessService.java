package com.example.demo.services;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.example.demo.StopProcess;
import com.example.demo.repository.ProcessRepository;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processes;

    public void listProcceses() {
        try {
            Runtime rnt = Runtime.getRuntime();

            String dir = System.getProperty("user.dir");
            String os = System.getProperty("os.name");

            System.out.println("Listing processes");
            System.out.println(dir);
            System.out.println(os);
            String[] cmd = null;

            if (SystemUtils.IS_OS_LINUX)
                cmd = new String[] { "/bin/sh", "-c", "cd " + dir + "/scripts/;sh list_process.sh" };
            else if (SystemUtils.IS_OS_WINDOWS)
                cmd = new String[] { "powershell.exe " + "cd" + dir + "scripts/list_process.ps1" };
            Process p = rnt.exec(cmd);
            printCommandResults(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flagProcesses(ArrayList<StopProcess> list) {

        ArrayList<String> ps = processes.getBody();

        FileWriter fw = null;

        Iterator<StopProcess> iter = list.iterator();
        try {
            fw = new FileWriter("./data/stoplist.sh");
            BufferedWriter bw = new BufferedWriter(fw);

            String cmd = "";
            if (SystemUtils.IS_OS_LINUX)
                cmd = "kill -9 ";

            for (String str : ps) {
                String[] data = str.split(",");
                if (iter.next().stop) {
                    bw.write(cmd + data[0]);
                    bw.newLine();
                }
            }

            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopProcesses() {
        try {
            Runtime rnt = Runtime.getRuntime();

            String dir = System.getProperty("user.dir");
            String os = System.getProperty("os.name");

            System.out.println("Listing processes");
            System.out.println(dir);
            System.out.println(os);
            String[] cmd = null;

            if (SystemUtils.IS_OS_LINUX)
                cmd = new String[] { "/bin/sh", "-c", "cd " + dir + "/scripts/; sh stop_process.sh" };
            else if (SystemUtils.IS_OS_WINDOWS)
                cmd = new String[] { "powershell.exe " + "cd" + dir + "scripts/stop_process.ps1" };
            Process p = rnt.exec(cmd);
            printCommandResults(p);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private void printCommandResults(Process p) {
        try {

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String s = null;
            // read the output from the command
            System.out.println("Standard output:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Standard error:\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}