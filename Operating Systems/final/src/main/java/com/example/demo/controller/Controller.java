package com.example.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import com.example.demo.repository.ProcessList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Manage processes running in the host
 */
@RestController("/")
public class Controller{

    /**
     * Obtain the processes curretly running in the host and shows them
     * @return
     */
    @GetMapping("/processes")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        
        ArrayList<String> list = new ArrayList<>();
        list.add("1.8,29/10/19");
        String header = list.get(0);
        // list.remove(0);
        header = "CPU,Date";
        ProcessList pl = new ProcessList(list.size());

        mv.addObject("processes", list);
        mv.addObject("header", header);
        mv.addObject("stopList", pl);
        return mv;
    }

    /**
     * Stop processes running in the host given the processes identifier
     * @param list All the processes to stop in the host
     * @return Redirects to the main page
     */
    @DeleteMapping("/processes/delete")
    public String stop(@RequestBody ArrayList<Integer> list){
        return "redirect:/processes";
    }

}