package com.navi.juego;

import java.util.Scanner;

public class IngresoDatos {
    static Scanner leer = new Scanner(System.in);

    public static int getInt(String titulo){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("[0-9 ]*$")){
                n = "";
            }
        }
        
        return Integer.parseInt(n);
    }

    public static int getIntRango(String titulo, int rango){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("[0-9]{"+rango+"}")){
                n = "";
            }
        }
        
        return Integer.parseInt(n);
    }

    public static String getString(String titulo){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("^[A-Za-z ]*$")){
                n = "";
            }
        }
        
        return n;
    }
}
