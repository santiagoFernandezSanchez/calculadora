package com.josemanuel.funcion;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Function;


//Esta es una clase sencilla para calcular el area de un triangulo
public class FuncionArea implements Function<Scanner, Void>{

    //solo tiene un metodo el cual te hace la cuenta y te pide los datos para calcular el area
    //Es una funcion que solo pide un parametro de entrada que sera por teclado y que devuelve un valor vacio

    //Un detalle importante es que a pesar de que controle varias cosas no controla si el usuario introduce un dato como un string y salta el error
    @Override
    public Void apply(Scanner sc) {
        
        System.out.println(" P * A / 2");
        
        System.out.println("Introduzca (P)erímetro:");
        String pStr = sc.next();
        BigDecimal pBD = new BigDecimal(pStr);

        System.out.println("Introduzca (A)potema:");
        String aStr = sc.next();
        BigDecimal aBD = new BigDecimal(aStr);

        System.out.println("Resultado" + pBD.multiply(aBD).divide(BigDecimal.valueOf(2)).toString());

        return null;
    }

    
}
