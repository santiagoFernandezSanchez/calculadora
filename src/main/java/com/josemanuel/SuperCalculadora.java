package com.josemanuel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.josemanuel.funcion.FuncionArea;
import com.josemanuel.funcion.FuncionExitMenu;
import com.josemanuel.funcion.FuncionResta;
import com.josemanuel.funcion.FuncionSuma;
import com.josemanuel.menu.ExitMenuException;
import com.josemanuel.menu.ItemMenu;
import com.josemanuel.menu.Menu;

public class SuperCalculadora 
{

    //iniciamos la calculadora con su constructor
    public SuperCalculadora() {
        sc = new Scanner(System.in);
        this.inicializaMenus();
    }

    private Scanner sc;//es por donde introduciremos los datos
    private Menu menuPrincipal;//creamos el menu principal

    //esta es la clase main
    public static void main( String[] args ) 
    {
        SuperCalculadora superCalculadora = new SuperCalculadora();
        
        try {
            superCalculadora.getMenuPrincipal().bucle();
        } catch(ExitMenuException eme) {
            System.out.println("FIN SUPERCALCULADORA");
            superCalculadora.getSc().close();
        }

    }
 //esta funcion inicia el menu
    private void inicializaMenus() {
        
        String introOpc = "Introduzca opción:";
        ItemMenu itemMenuExit = new ItemMenu("Salir", new FuncionExitMenu());
        //Pone valores con el map a cada item del menu
        Map<String, ItemMenu> mapItemMenuAritmetica = new HashMap<String, ItemMenu>();
        mapItemMenuAritmetica.put("1", new ItemMenu("Operación suma", new FuncionSuma()));
        mapItemMenuAritmetica.put("2", new ItemMenu("Operación resta", new FuncionResta()));
        mapItemMenuAritmetica.put("X", itemMenuExit);

        Menu menuAritmetica = new Menu("Menú de Aritmética", introOpc, mapItemMenuAritmetica, this.sc);

        
        Map<String, ItemMenu> mapItemMenuAreaPi = new HashMap<String, ItemMenu>();
        mapItemMenuAreaPi.put("1", new ItemMenu("Área polígono regular", new FuncionArea()));
        mapItemMenuAreaPi.put("X", itemMenuExit);
        //mapItemMenuAreaPi.put("2", new ItemMenu("Tm. de Pitágoras", new FuncionResta()));

        Menu menuAreaPi = new Menu("Menú de área y Tm. de Pitágoras", introOpc, mapItemMenuAreaPi, this.sc);
        //hace lo msmo que arriba pero sin los numeros, controla que no puedas meter letras minusculas
        Map<String, ItemMenu> mapItemMenuPrincipal = new HashMap<String, ItemMenu>();
        mapItemMenuPrincipal.put("A", new ItemMenu("Aritmética", menuAritmetica));
        mapItemMenuPrincipal.put("B", new ItemMenu("Área polígono regular y Tm. de Pitágoras", menuAreaPi));
        mapItemMenuPrincipal.put("X", itemMenuExit);

        this.menuPrincipal = new Menu("Menú principal de Supercalculadora", introOpc, mapItemMenuPrincipal, this.sc);

    }

    //obtienes el menu principal
    public Menu getMenuPrincipal() {
        return menuPrincipal;
    }

    //obtienes la entrada de datos
    public Scanner getSc() {
        return sc;
    }

}
