package com.navi.personajes.bestia;

import com.navi.personajes.Personaje;

public class Bestia extends Personaje{
    
    public Bestia(int vida, String nombre, int armadura){
        this.vida = vida;
        this.nombre = nombre;
        this.armadura = armadura;
    }

    public int atacar(Personaje personaje2){

        int dado1 = generaNumeroR(0,100);
        if(this instanceof Orco){
            dado1 = (int) (dado1 + (personaje2.getArmadura() * 0.1));
            System.out.println("Orco Atacando, daño ignorando el 10% de la armadura del objetivo");
        }
        dado1 = dado1 - personaje2.getArmadura();
        if(dado1 < 0){
            dado1 = 0;
        }
        personaje2.recibirDamage(dado1);
            if(personaje2.getVida() < 0){
                personaje2.muerte();
            }
        return dado1;
    }

    public int generaNumeroR(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;

    }
}
