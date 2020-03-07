package org.fdios.mustache.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class IndexController {

    @RequestMapping("/index/")
    public String index(Model m) {
        m.addAttribute("message", "Hello World");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/index/getusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GetPageResponse getPersonList() {

        List<Person> personList = new ArrayList<>();
        for (int it = 0; it < 20; it++) {
            personList.add(genRandomPerson());
        }

        GetPageResponse response = new GetPageResponse();
        response.setTitle("Lorem Ipsum");
        response.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        response.setPersonList(personList);
        return response;
    }

    private Person genRandomPerson() {
        Random rand = new Random();
        int random = rand.nextInt(100);
        Person p = new Person();
        p.setName("Person_"+random);
        p.setSurname("Surname_"+random);
        p.setAge(rand.nextInt(50));
        return p;
    }
}