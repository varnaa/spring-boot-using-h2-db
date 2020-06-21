package com.varnaa.spring_h2.controller;

import com.varnaa.spring_h2.controller.entity.Employee;
import com.varnaa.spring_h2.controller.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping({"/", "/index"})
    public String getIndex() {
        return "index";
    }

    @GetMapping("/new")
    public String newData(Model model) {
        Employee varnaa = new Employee(3, "foz", 200000, "05-05-2020");
        repository.save(varnaa);
        System.out.println(repository.findEmployeeByDateOfJoiningEquals("05-05-2020").toString());
        System.out.println(repository.getOne(1));
        return "index";
    }


}
