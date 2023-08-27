package edu.escuelaing.arep.ASE.app.HTTPserver;

import edu.escuelaing.arep.ASE.app.controllers.FileController;
import edu.escuelaing.arep.ASE.app.controllers.FilmController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class webServer {

    public static void main(String[] args) throws IOException{






        ServerSocket server = null;

        FileController fileController = new FileController();
        FilmController filmController = new FilmController();


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


            while ((inputLine = inputServer.readLine()) != null) {

                System.out.println("Received: " + inputLine);

                if(firstline){
                    file = inputLine.split("/")[1].split(" ")[0];
                    filmTitle = inputLine.split("/")[2].split(" ")[0];
                    firstline = false;

                }

                if (!inputServer.ready()) {
                    break;
                }



            }




            if(file.endsWith(".jpg")){
                header = fileController.getFile(file);
                for(String Answer : header){
                    responseServer.println(Answer);
                }
                responseServer.println();
                byte[] data = fileController.getImage(file,"src/main/java/static/");
                outputStream.write(data);
            }
            else if(file.equals("films")){

                header = fileController.getFile("rta.json");
                String jsonResponse = filmController.getFilmByTitle(filmTitle, "http://www.omdbapi.com/?t=", "c45e3292");
                response.add("Content-Length: " + jsonResponse.length());
                response.add(jsonResponse);
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





