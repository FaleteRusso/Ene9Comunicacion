package com.corenetworks.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
     try(ServerSocket sv = new ServerSocket(3001);) {
         //2. Ponerlo a la escucha
         while (true) {
             System.out.println("En espera de registrar mensajes ...");
             Socket s1 = sv.accept();

             BufferedReader bf = new BufferedReader(new InputStreamReader(s1.getInputStream()));
             System.out.println(bf.readLine());
             PrintWriter sResp = new PrintWriter(s1.getOutputStream(),true);
             sResp.println("Se ha recibido su mensaje");

             }
         } catch (IOException e) {
         throw new RuntimeException(e);
     }
    }
    }