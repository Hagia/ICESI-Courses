package com.example.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import com.example.demo.StopProcess;
import com.example.demo.ProcessList;
import com.example.demo.services.CsvReader;
import com.example.demo.services.ProcessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Manage processes running in the host
 */
@RestController("/")
public class Controller{

    @Autowired
    private ProcessService ps;

    @Autowired
    private CsvReader reader;

    /**
     * Obtain the processes curretly running in the host and shows them
     * @return
     */
    @GetMapping("/processes/list")
    public RedirectView list(){
       ps.listProcceses();
       reader.readCsv();
       return new RedirectView("/processes");
    }

    @GetMapping("/processes")
    public ModelAndView processes(){
        ModelAndView mv = new ModelAndView();

        ArrayList<String>[] dt = reader.getData();
        ProcessList list = new ProcessList();
        list.fill(dt[1].size());

        mv.addObject("processes",dt[1]);
        mv.addObject("header", dt[0]);
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping("/")
    public RedirectView home(){
       return new RedirectView("processes");
    }

    /**
     * Stop processes running in the host given the processes identifier
     * @param list All the processes to stop in the host
     * @return Redirects to the main page
     */
    @PostMapping("/processes/stop")
    public RedirectView stop(@ModelAttribute ProcessList list){

        ps.flagProcesses(list.getStopList());
        ps.stopProcesses();
        System.out.println(list.getStopList().toString());
        return new RedirectView("/processes");
    }

}