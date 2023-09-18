package edu.escuelaing.arep.ASE.app.controllers;

import edu.escuelaing.arep.ASE.app.POJOS.notation.RequestMapping;

public class POJOController {

    @RequestMapping(path = "POJOGET")
    public static String index() {
        return "Example endpoint with POJOs";
    }


    @RequestMapping(path = "helloGET")
    public static String hello() {
        return "Hello world from Copt of Spring";
    }
}
