package org.launchcode.AnimalRoster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "hello")
public class HomeController {
    @ResponseBody
    @GetMapping("hello") //localhost:8080/hello/hello
    public String hello() {
        return "<h1>Hello, Kyle</h1>";
    }

    @ResponseBody
    @GetMapping("helloquery") //localhost:8080/hello/helloquery?name=SOMETHING
    public String helloQuery (@RequestParam String name) {
        if (name.isBlank()) {
            name = "LaunchCode";
        }
        return String.format("<h1>Hello, %s!</h1>", name);
    }

    @ResponseBody
    @GetMapping("hello/{name}") //localhost:8080/hello/hello/name
    public String helloPath (@PathVariable String name) {
        return String.format("<h1>Hello, %s!</h1>", name);
    }

    @ResponseBody
    @RequestMapping(value="form", method = {RequestMethod.GET, RequestMethod.POST})
    public String form(@RequestParam String name) { //handles at localhost:8080/hello/form
        if (name.isBlank()) {
            name = "LaunchCode";
        } else if (name.equalsIgnoreCase("apple dog")) {
            return "<h1>Hello, Banana Cat! <em>Also how dare you.</em> >:(</h1>";
        }

        return String.format("<h1>Hello, %s!</h1>", name);
    }

    @GetMapping
    @ResponseBody
    public String defaultForm () { //defaults to localhost:8080/hello
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = '/hello/form'>" +
                "<input type = 'text' name = 'name'/>" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
