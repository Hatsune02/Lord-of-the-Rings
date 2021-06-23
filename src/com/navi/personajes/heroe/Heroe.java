package com.navi.personajes.heroe;

import com.navi.personajes.Personaje;
import com.navi.personajes.bestia.Orco;
import com.navi.personajes.bestia.Trasgo;

public class Heroe extends Personaje {
    public final int VIDAMAXIMA;

    public Heroe(int vida, String nombre, int armadura, int vidaMaxima){
        this.vida = vida;
        this.nombre = nombre;
        this.armadura = armadura;
        VIDAMAXIMA = vidaMaxima;
    }

    public int atacar(Personaje personaje2){

        int dado1 = generaNumeroR(0,100);
        int dado2 = generaNumeroR(0,100);
        int ataque;
        if(dado1 > dado2){
            ataque = dado1;
        }
        else{
            ataque = dado2;
        }

        if(this instanceof Elfo && personaje2 instanceof Orco){
            ataque = ataque + 10;
            System.out.println("Elfo atacando a un Orco, +10 al daño del Elfo");
        }
        else if(this instanceof Hobbit && personaje2 instanceof Trasgo){
            System.out.println("Hobbit atacando a un Trasgo, -5 al daño del Hobbit");
            ataque = ataque - 5;
        }
        ataque = ataque - personaje2.getArmadura();
        if(ataque < 0){
            ataque = 0;
        }
        personaje2.recibirDamage(ataque);
        if(personaje2.getVida() < 0){
            personaje2.muerte();
        }
        return ataque;
    }

    public int generaNumeroR(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;

    }

}
