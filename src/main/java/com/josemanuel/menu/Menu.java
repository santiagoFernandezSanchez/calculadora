package com.josemanuel.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
//esta es la clase para crear el menu 
public class Menu {

    private Scanner sc; //la variable de salida y entrada de datos 
    private String titulo; //el titutlo del menu de la funcion
    private String input; //un input del menu
    private Map<String, ItemMenu> mapItemMenu;//Un objeto que une una clave a un valor
    
    //este es el constructor para crear una instancia de un menu
    public Menu(String titulo, String input, Map<String, ItemMenu> mapItemMenu, Scanner sc) {

        this.sc = sc;
        this.mapItemMenu = mapItemMenu;
        this.titulo = titulo;
        this.input = input;

    }

    //te muestra el titulo y las opciones del menu
    public void renderiza() {

        System.out.println(titulo);
         
        this.mapItemMenu.forEach((k, v) -> {
            System.out.println(k + ".- " + v.getMensajeMenu());
        });

        System.out.println(this.input);

    }

    //este bucle te va creando el anidado de menus segun la opcion que escojas
    public void bucle() throws ExitMenuException {

        
        do{

            this.renderiza();            
            String next = sc.next();
            ItemMenu itemMenuSelect = this.mapItemMenu.get(next);
            if (itemMenuSelect != null) {
                Menu subMenu;
                if ((subMenu = itemMenuSelect.getSubMenu())!= null) {                
                    try {
                        subMenu.bucle();
                    } catch(ExitMenuException eme) {                    
                    }
                } 

                Function<Scanner, Void> itemMenuFuncion;
                if ((itemMenuFuncion = itemMenuSelect.getItemMenuFuncion()) != null) {
                    itemMenuFuncion.apply(sc);
                }
                  
            } else {
                System.out.println("Opción no válida, intente de nuevo");
            }
            
        } while(true);

    }



    
    
}
