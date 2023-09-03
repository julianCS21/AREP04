package edu.escuelaing.arep.ASE.app;

import edu.escuelaing.arep.ASE.app.HTTPserver.webServer;
import edu.escuelaing.arep.ASE.app.services.impl.HTTPmethodsImpl.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class main {

    public static void main(String[] args) throws IOException {
        webServer instanceWebServer = webServer.getWebServer();
        instanceWebServer.start();
    }
}
