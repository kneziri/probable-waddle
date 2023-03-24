package org.pris2.ejercico3;

import org.pris2.ejercicio3.Ejercicio3;

import junit.framework.TestCase;

public class Ejercicio3Test extends TestCase {
	int xizq=0;
    int xder=0;
    double precision=0.0;
    double xr=0.0;
    double funcionDer=0.0;
    double funcionIzq=0.0;
    double funcionRaiz=0.0;
    
    public void testEjercicio3XIzq(){
    	xizq=5;
    	xder=84;
    	precision=2.5;
    	Ejercicio3 ejer=new Ejercicio3();
    	ejer.funcionIzquierda(xizq);
    	assertEquals(2622.0,ejer.funcionIzquierda(xizq));
    	
    }
    public void testEjercicio3XDer(){
    	xizq=5;
    	xder=84;
    	precision=2.5;
    	Ejercicio3 ejer=new Ejercicio3();
    	ejer.funcionDerecha(xder);
    	assertEquals(4.132924989E9,ejer.funcionDerecha(xder));
    	
    }
    public void testXr(){
    	xizq=5;
    	xder=84;
    	precision=2.5;
    	funcionIzq=2622.0;
    	funcionDer=4.132924989E9;
    	Ejercicio3 ejer=new Ejercicio3();
    	ejer.xr(xizq, xder, funcionIzq, funcionDer);
    	assertEquals(4.999949880984545,ejer.xr(xizq, xder, funcionIzq, funcionDer));
    	
    }
    public void testFuncionRaiz(){
    	xizq=5;
    	xder=84;
    	precision=2.5;
    	funcionIzq=2622.0;
    	funcionDer=4.132924989E9;
    	xr=4.999949880984545;
    	Ejercicio3 ejer=new Ejercicio3();
    	
    	assertEquals(2621.864681459028,ejer.funcionRaiz(xr));
    	
    }

}
