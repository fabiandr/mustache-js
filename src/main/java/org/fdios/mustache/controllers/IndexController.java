package org.fdios.mustache.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/index/")
    public String index(Model m) {
        m.addAttribute("message", "Hello World");
        return "index";
    }


    @ResponseBody
    @RequestMapping(value = "/index/getuserinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson() {
        Person p = new Person();
        p.setName("Fabián");
        p.setSurname("Dios Rodas");
        p.setAge(29);

        return p;
    }

    @ResponseBody
    @RequestMapping(value = "/index/getusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersonList() {
        Person p = new Person();
        p.setName("Fabián");
        p.setSurname("Dios Rodas");
        p.setAge(29);
        Person p2 = new Person();
        p2.setName("Manolo");
        p2.setSurname("Gafotas González");
        p2.setAge(54);
        Person p3 = new Person();
        p3.setName("Tamara");
        p3.setSurname("Dios Rodas");
        p3.setAge(24);


        List<Person> personList = new ArrayList<>();
        personList.add(p);
        personList.add(p2);
        personList.add(p3);
        return personList;
    }
}