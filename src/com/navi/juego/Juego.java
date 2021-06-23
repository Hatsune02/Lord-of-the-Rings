package com.navi.juego;

import com.navi.personajes.heroe.*;
import com.navi.personajes.bestia.*;

public class Juego {
    /*
    Humano[] humanos = new Humano[10];
    Elfo[] elfos = new Elfo[10];
    Hobbit[] Hobbit = new Hobbit[10]; 
    Orco[] orcos = new Orco[10];
    Trasgo[] trasgos = new Trasgo[10];

    int cantidadHumanos = 0;
    int cantidadElfos = 0;
    int cantidadHobbits = 0;
    int cantidadOrcos = 0;
    int cantidadTrasgos = 0;
    int cantidadHeroes = 0;
    int cantidadBestias = 0;
    */

    Heroe[] heroes = new Heroe[10]; 
    Bestia[] bestias = new Bestia[10];
    int cantidadHeroes = 0;
    int cantidadBestias = 0;

    public void menu(){
        int opcion;
        do{
            System.out.println(" MENU____________________________________________  ");
            System.out.println("");
            System.out.println("1) Pelear");
            System.out.println("2) Crear party");
            System.out.println("3) MostrarParty");
            System.out.println("4) Salir");
            System.out.println("");
            opcion = IngresoDatos.getInt("Ingrese -->");

            if(opcion == 1){
                pelea();
            }
            else if(opcion==2){
                crearParty();

            }
            else if(opcion == 3){
                mostrarParty();
            }
        } while(opcion != 4);

    }

    public void pelea(){
        enemigos();

        int heroesPelea = cantidadHeroes;
        int bestiasPelea= cantidadBestias;
        int muertosHeroes = 0;
        int muertosBestias = 0;
        int peladores;
        boolean ganador = false;
        boolean ganadorHeroe = false;
        int turnos = 1;

        if(heroesPelea > bestiasPelea){
            peladores = bestiasPelea;
        }
        else{
            peladores = heroesPelea;
        }

        do{
            System.out.println("Turno " + turnos);
            mostrarPelea();
            for (int i = 0; i < peladores; i++) {
                int damageHeroe = heroes[i].atacar(bestias[i]);
                int damageBestia = bestias[i].atacar(heroes[i]);
                System.out.println((i+1) + ") Heroe " + heroes[i].getNombre() + " atacó a: " + bestias[i] + " con " + damageHeroe + " de daño de ataque");
                System.out.println((i+1) + ") Bestia " + bestias[i].getNombre() + " atacó a: " + heroes[i] + " con " + damageBestia + " de daño de ataque");
                if(heroes[i].getVida() <= 0){
                    moverAlFinalHeroes(i);
                    muertosHeroes++;
                    heroesPelea--;
                }
                else if(bestias[i].getVida() <= 0){
                    moverAlFinalBestias(i);
                    muertosBestias++;
                    bestiasPelea--;
                }

            }
            System.out.println("");
            if(heroesPelea > bestiasPelea){
                peladores = bestiasPelea;
            }
            else{
                peladores = heroesPelea;
            }

            if(muertosBestias == cantidadBestias){
                ganador = true;
                ganadorHeroe = true;
            }
            else if(muertosHeroes == cantidadHeroes){
                ganador = true;
                ganadorHeroe = false;
            }
            turnos++;
        } while(!ganador);

        if(ganadorHeroe){
            System.out.println("Ganaste la batalla! ");
        }
        else{
            System.out.println("Perdiste le batalla ");
        }

        for (int i = 0; i < cantidadHeroes; i++) {
            heroes[i].setVida(heroes[i].VIDAMAXIMA);
        }
        cantidadBestias = 0;

    }

    public void crearParty(){
        int opcion;
        do{
            System.out.println(" Escoger que clase de heroe quiere en su party, máximo de 10 heores por party  ");
            System.out.println("cantidad heroes " + cantidadHeroes);
            System.out.println("");
            System.out.println("1) Humano");
            System.out.println("2) Elfo");
            System.out.println("3) Hobbit");
            System.out.println("4) Terminar la party");
            System.out.println("");
            opcion = IngresoDatos.getInt("Ingrese -->");

            if(opcion == 1){
                String nombre = IngresoDatos.getString("Ingrese el nombre del Humano: ");
                heroes[cantidadHeroes] = new Humano(nombre);
                cantidadHeroes++;

            }
            else if(opcion==2){
                String nombre = IngresoDatos.getString("Ingrese el nombre del Elfo: ");
                heroes[cantidadHeroes] = new Elfo(nombre);
                cantidadHeroes++;
            }
            else if(opcion == 3){
                String nombre = IngresoDatos.getString("Ingrese el nombre del Hobbit: ");
                heroes[cantidadHeroes] = new Hobbit(nombre);
                cantidadHeroes++;
            }
            else if(opcion == 4){
                break;
            }
        } while(cantidadBestias < 10);

    }

    public void enemigos(){
        int opcion;
        System.out.println(" Escoger la dificultad de los enemigos ");
        System.out.println("");
        System.out.println("1) Facil");
        System.out.println("2) Medio");
        System.out.println("3) Dificil");
        System.out.println("");
        opcion = IngresoDatos.getInt("Ingrese -->");

        if(opcion == 1){
            bestias[cantidadBestias] = new Orco("Grom");
            cantidadBestias++;
            bestias[cantidadBestias] = new Trasgo("Thurg");
            cantidadBestias++;
        }
        else if(opcion==2){
            bestias[cantidadBestias] = new Orco("Grom");
            cantidadBestias++;
            bestias[cantidadBestias] = new Orco("Thrum");
            cantidadBestias++;
            bestias[cantidadBestias] = new Trasgo("Drog");
            cantidadBestias++;
            bestias[cantidadBestias] = new Trasgo("Thurg");
            cantidadBestias++;
        }
        else if(opcion == 3){
            bestias[cantidadBestias] = new Orco("Grom");
            cantidadBestias++;
            bestias[cantidadBestias] = new Orco("Thrum");
            cantidadBestias++;
            bestias[cantidadBestias] = new Orco("Drog");
            cantidadBestias++;
            bestias[cantidadBestias] = new Trasgo("Thurg");
            cantidadBestias++;
            bestias[cantidadBestias] = new Trasgo("Karg");
            cantidadBestias++;
            bestias[cantidadBestias] = new Trasgo("Igrim");
            cantidadBestias++;
            bestias[cantidadBestias] = new Trasgo("Dragga");
            cantidadBestias++;
        }
    }

    public void mostrarPelea(){
        if(cantidadHeroes > cantidadBestias){
            for (int i = 0; i < cantidadHeroes; i++) {
                if(bestias[i] != null){
                    System.out.println((i+1) + ")  " + heroes[i].toString() + "\t\t\t" + bestias[i].toString());
                }
                else{
                    System.out.println((i+1) + ")  " + heroes[i].toString() + "\t\t\t\t\t\t\t\t\t\t\t\t");
                }
            }
        }
        else{
            for (int i = 0; i < cantidadBestias; i++) {
                if(heroes[i] != null){
                    System.out.println((i+1) + ")  " + heroes[i].toString() + "\t\t\t" + bestias[i].toString());
                }
                else{
                    System.out.println((i+1) + ")  \t\t\t\t\t\t\t\t\t\t" + bestias[i].toString());
                }
            }
        }

    }

    public void moverAlFinalHeroes(int posicion){
        for (int i = 0; i < cantidadHeroes - 1; i++) {
            if(i >= posicion){
                Heroe aux = heroes[i];
                heroes[i] = heroes[i+1];
                heroes[i+1] = aux;
            }
        }
    }

    public void moverAlFinalBestias(int posicion){
        for (int i = 0; i < cantidadBestias - 1; i++) {
            if(i >= posicion){
                Bestia aux = bestias[i];
                bestias[i] = bestias[i+1];
                bestias[i+1] = aux;
            }
        }
    }

    public void mostrarParty(){

        System.out.println("  NOMBRE\t\tVIDA\t\tARMADURA\t\tRAZA");
        for (int i = 0; i < cantidadHeroes; i++) {
            System.out.println((i+1) + ") " + heroes[i].getNombre() + "\t\t" + heroes[i].getVida() + "\t\t\t\t" + heroes[i].getArmadura() + "\t\t\t"+ heroes[i].getRaza());
        }
    }
}
