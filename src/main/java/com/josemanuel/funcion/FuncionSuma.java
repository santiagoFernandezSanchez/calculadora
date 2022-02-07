package com.josemanuel.funcion;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;

//Es una clase bastante sencilla con un solo metodo que realiza la suma en nuestra aplicacion
//tampoco controla la inserccion de datos incorrectos
public class FuncionSuma implements Function<Scanner, Void>{

    @Override
    public Void apply(Scanner sc) {
        
        System.out.println("\nOperación seleccionada suma:\n");
        System.out.println("A + B\n");
        
        System.out.println("Introduzca A:");
        String aStr = sc.next();
        BigDecimal aBD = new BigDecimal(aStr);

        System.out.println("Introduzca B:");
        String bStr = sc.next();
        BigDecimal bBD = new BigDecimal(bStr);

        System.out.println("\nResultado: " + aBD.add(bBD).toString() + "\n");

        return null;
    }

}
