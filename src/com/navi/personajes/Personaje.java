package com.navi.personajes;

public class Personaje {
    protected String nombre;
    protected int vida;
    protected int armadura;
    protected String raza;

    public void recibirDamage(int damage){
        vida = vida - damage;
    }

    public void muerte(){
        vida = 0;
    }

    public int getArmadura() {
        return armadura;
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return nombre + "(HP: " + vida + ", Armor: " + armadura + ", Raza: " + raza +")";
    }

}
