package edu.escuelaing.arep.ASE.app.HTTPserver;


import edu.escuelaing.arep.ASE.app.HTTPObjects.Request;
import edu.escuelaing.arep.ASE.app.HTTPObjects.Response;
import edu.escuelaing.arep.ASE.app.POJOS.scanner.Scope;
import edu.escuelaing.arep.ASE.app.controllers.ExampleController;
import edu.escuelaing.arep.ASE.app.controllers.FileController;
import edu.escuelaing.arep.ASE.app.controllers.FilmController;
import static edu.escuelaing.arep.ASE.app.services.impl.HTTPmethodsImpl.getMethod;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class webServer {

    private static webServer instance;


    public static webServer getWebServer() throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if(instance == null){
            instance = new webServer();

        }
        return instance;
    }
    private webServer() throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        start();
    }


    public void start() throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {





        ServerSocket server = null;

        FileController fileController = new FileController();
        FilmController filmController = new FilmController();
        ExampleController  exampleController = new ExampleController();
        Scope scanner = new Scope();
        scanner.getClasses();

        try {
            server = new ServerSocket(35000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Socket client = null;

        while(!(server.isClosed())){
            try{
                System.out.println("Ready to receive");
                client = server.accept();

            }catch (IOException e){
                System.out.println("Couldn't listen on port: 32000");
                System.exit(1);

            }


            OutputStream outputStream = client.getOutputStream();
            PrintWriter responseServer = new PrintWriter(client.getOutputStream(),true);
            BufferedReader inputServer = new BufferedReader(new InputStreamReader((client.getInputStream())));

            String inputLine;


            boolean firstline= true;


            String file = "";

            List<String> response = new ArrayList<>();

            List<String> header = new ArrayList<>();

            String filmTitle = "";

            String method = "";

            String query = "";

            String Host = "";


            while ((inputLine = inputServer.readLine()) != null) {

                System.out.println("Received: " + inputLine);

                if(firstline){
                    method = inputLine.split("/")[0].split(" ")[0];
                    query = inputLine.split("/")[1].split(" ")[0];
                    file = inputLine.split("/")[1].split("\\?")[0].split(" ")[0];
                    firstline = false;

                }
                else if(inputLine.contains("Host")){
                    Host = inputLine.split(" ")[1];


                }


                if (!inputServer.ready()) {
                    break;
                }



            }
            String endpoint = file + method;
            String URL = "http://"+ Host + "/" + query;
            System.out.println(getMethod(endpoint));

            if(getMethod(endpoint) != null){
                header = fileController.getFile("rta.json");
                String jsonResponse = getMethod(endpoint).HTTPAction(new Request(new URL(URL)),new Response());
                header.add("Content-Length: " + jsonResponse.length());
                response.add(jsonResponse);
            } else if (scanner.getMethod(endpoint) != null) {
                Method aMethod = scanner.getMethod(endpoint);
                header = fileController.getFile("rta.json");
                String jsonResponse = (String) aMethod.invoke(null);
                header.add("Content-Length: " + jsonResponse.length());
                response.add(jsonResponse);
                
            } else if(file.endsWith(".png")){
                header = fileController.getFile(file);
                for(String Answer : header){
                    responseServer.println(Answer);
                }
                responseServer.println();
                byte[] data = fileController.getImage(file,"src/main/java/static/");
                outputStream.write(data);
            }
            else if(!(file.isEmpty())){
                header = fileController.getFile(file);
                response = fileController.searchFile(file,"src/main/java/static/");
            }
            else{
                header = fileController.getFile("rta.root");
                String rootResponse = "<h1>THIS IS A ROOT PAGE OF SERVER</h1>";
                response.add(rootResponse);
            }
            //header
            if(!(file.endsWith(".jpg"))){
                for(String Answer : header){
                    responseServer.println(Answer);
                }
                responseServer.println();
                //response
                for(String Answer : response){
                    System.out.println(Answer);
                    responseServer.println(Answer);
                }

            }


            responseServer.close();
            inputServer.close();
            client.close();



        }
        server.close();
    }
}





