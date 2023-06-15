package org.esupportail.httpurltest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpURLConnectionTest {

    static Logger log = Logger.getLogger("UrlTest");

    public static void main(String[] args) {
        if(args.length < 1) {
            log.severe("Le programme attend en entrée une url de type https://www.esup-portail.org");
            return;
        }
        String urlString = args[0];
        log.info("Connexion à " + urlString + " ...");
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            log.info("Ouverture de connexion OK");
            connection.setRequestMethod("GET");
            connection.connect();
            log.info("Get OK - code de retour : " + connection.getResponseCode());
        } catch(Exception e) {
            log.log(Level.SEVERE, "Erreur lors du GET sur l'url " + urlString, e);
        }
    }
}