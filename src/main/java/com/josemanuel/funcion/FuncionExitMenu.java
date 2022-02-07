package com.josemanuel.funcion;

import java.util.Scanner;
import java.util.function.Function;

import com.josemanuel.menu.ExitMenuException;

//Es una clase con un solo metodo que simplemente sirve para salir de un menu
public class FuncionExitMenu implements Function<Scanner, Void>{

    @Override
    public Void apply(Scanner t) {
        //esta es una clase de la carpeta menu que hace la salida
        throw new ExitMenuException();

        //return null;
    }
    
}
