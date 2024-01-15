package com.corenetworks.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        String[] respuestas = {"Desde las 10:00 hasta las 21:00", "Dias festivos de Madrid", "Si","30 €"};
        BufferedReader mE;
        PrintWriter mS;
    try(ServerSocket servidor = new ServerSocket(3001);) {
            while(true){
                System.out.println("Esperando peticion ...");
                Socket s1 = servidor.accept();
                 mE = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                String pregunta = mE.readLine();
                int indice = Integer.parseInt(pregunta);
                 mS = new PrintWriter(s1.getOutputStream(),true);
                mS.println("se ha recibido su hola mundo");


             }
         } catch (IOException e) {
        System.out.println(e.toString());
     }
    }
    }