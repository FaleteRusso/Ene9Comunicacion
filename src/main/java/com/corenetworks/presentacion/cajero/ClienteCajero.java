package com.corenetworks.presentacion.cajero;

import com.corenetworks.modelo.CuentaBancaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ClienteCajero {
    public static void main(String[] args) {
        while (true) {
            CuentaBancaria cB1 = solicitarDatos();
            if (cB1.getTipoOperacion() == null) {
                break;
            }
            System.out.println(cB1.toString());
            try (Socket cl = new Socket("localhost", 3000);) {
                PrintWriter mAE = new PrintWriter(cl.getOutputStream(), true);
                mAE.println(cB1.getTipoOperacion() + "," + cB1.getId() + "," + cB1.getCantidad());
                System.out.println("Esperando respuesta del servidor...");
                BufferedReader mR = new BufferedReader(new InputStreamReader(cl.getInputStream()));
                System.out.println(mR.readLine());
            } catch (UnknownHostException e) {
                System.out.println(e.toString());
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }
    private static CuentaBancaria solicitarDatos() {
        CuentaBancaria cB1= new CuentaBancaria();
        int tipoOperacion=0;
        Scanner sc = new Scanner(System.in);

            System.out.printf("%s %n", "-".repeat(50));
            System.out.printf("%s %n", "MENU BANCARIO");
            System.out.printf("%s %n", "-".repeat(50));
            System.out.printf("%s %n", "1) Consultar Saldo");
            System.out.printf("%s %n", "2) Retirar efectivo");
            System.out.printf("%s %n", "3) Ingresar efectivo");
            System.out.printf("%s %n", "4) Salir");
            System.out.printf("Escriba la opción -> ");
            tipoOperacion = sc.nextInt();
            sc.nextLine();
            if(tipoOperacion ==4){
                return cB1;
            }
            System.out.printf("Escriba la cuenta -> ");
            cB1.setId(sc.nextLine());
            if (tipoOperacion == 2 || tipoOperacion == 3) {
                System.out.printf("Eescriba la cantidad -> ");
                cB1.setCantidad(sc.nextDouble());
            }
            cB1.setTipoOperacion(Integer.toString(tipoOperacion));
            return  cB1;
    }
}
