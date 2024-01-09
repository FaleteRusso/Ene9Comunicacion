package com.corenetworks.presentacion.cajero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCajero {
    public static void main(String[] args) {
        BufferedReader mR = null;
        PrintWriter mAE= null;
            try(ServerSocket sv= new ServerSocket(3000);){
             while (true) {
                 System.out.println("Esperando peticion...");
                 Socket s1 = sv.accept();
                 mR=new BufferedReader(new InputStreamReader(s1.getInputStream()));
                 System.out.println(mR.readLine());
                 mAE=new PrintWriter(s1.getOutputStream(),true);
                 mAE.println("Su saldo es -> %s"+1000);

             }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
