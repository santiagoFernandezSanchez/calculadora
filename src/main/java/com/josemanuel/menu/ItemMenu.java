package com.josemanuel.menu;

import java.util.Scanner;
import java.util.function.Function;
//este es el objeto o clase menu, con sus multiples metodos y atributos
public class ItemMenu {

    private String mensajeMenu; //es el mensaje del menu
    private Menu subMenu; //te crea una instancia del objeto menu
    private Function<Scanner, Void> itemMenuFuncion; //Representa una funcion que permite un valor y una salida


    //uno de los constructores de la clase
    //en este constructor te crea un item del menu que sea un sub menu con su mensaje
    public ItemMenu(String mensajeMenu, Menu subMenu) {
        this.subMenu = subMenu;
        this.mensajeMenu = mensajeMenu;        
    }

    //el segundo de los constructores
    //este item simplemente representa una de las opciones del menu
    public ItemMenu(String mensajeMenu, Function<Scanner, Void> itemMenuFuncion) {
        this.mensajeMenu = mensajeMenu;
        this.itemMenuFuncion = itemMenuFuncion;
    }

    public Menu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Menu subMenu) {
        this.subMenu = subMenu;
    }

    public String getMensajeMenu() {
        return mensajeMenu;
    }

    public void setMensajeMenu(String mensajeMenu) {
        this.mensajeMenu = mensajeMenu;
    }

    public Function<Scanner, Void> getItemMenuFuncion() {
        return itemMenuFuncion;
    }

}
