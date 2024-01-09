package com.corenetworks.presentacion.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteRobot {
    public static void main(String[] args) {
        String[]preguntas={"Horario de la tienda","Que dias no abren?","Tienen el libro Java desde cero?","Precio del libro?"};
        try(Socket cl= new Socket("localhost",3000);){
        String preguntasSelecionada= mostrarMenu();
            PrintWriter mAE=new PrintWriter(cl.getOutputStream());
            mAE.println(preguntasSelecionada);
            System.out.println("esperando respuesta del serveidor...");
            //Esperamos contestacion del servidor
            BufferedReader mR = new BufferedReader(new InputStreamReader(cl.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static String mostrarMenu() {
       // Mostrar las preguntas del array
       //
    }
}
