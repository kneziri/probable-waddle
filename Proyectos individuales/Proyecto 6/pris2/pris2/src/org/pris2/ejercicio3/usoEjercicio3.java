package org.pris2.ejercicio3;
 
import java.util.Scanner;
 
public class usoEjercicio3 {
    public static void main(String[] args) {
       Ejercicio3 ejer=new Ejercicio3();
        int xizq=0;
        int xder=0;
        double precision=0.0;
        double xr=0.0;
        double funcionDer=0.0;
        double funcionIzq=0.0;
        double funcionRaiz=0.0;
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el valor del extremo de la izquierda: ");
        xizq=in.nextInt();
        System.out.println("Introduzca el valor del extremo de la derecha: ");
        xder=in.nextInt();
        System.out.println("El intervalo es ["+xizq+","+xder+"]");
        System.out.println("Introduzca la precisión deseada: ");
        precision=in.nextDouble();
       
       funcionDer= ejer.funcionDerecha(xder);
       funcionIzq= ejer.funcionIzquierda(xizq);
       xr= ejer.xr( xizq, xder,funcionIzq,funcionDer);
     funcionRaiz=   ejer.funcionRaiz(xr);
       
        /**Si f(xizq)*f(xr)<0redefinir límite derecho del intervalo: xderxr
        Si f(xizq)*f(xr)>0redefinir límite izquierdo del intervalo: xizqxr
        Si f(xizq)*f(xr)=0hay una raíz en xr**/
        while(funcionRaiz<precision){
        if((funcionIzq*funcionRaiz)<0){
            System.out.println("Vuelva a introducir el límite derecho del intervalo: ");
            xder=in.nextInt();
            System.out.println("El intervalo es ["+xizq+","+xder+"]");
            funcionDer=Math.pow(xder, 5)-Math.pow(xder, 4)+Math.pow(xder, 3)-3;
            System.out.println("f(xder)="+funcionDer);
           
            funcionIzq=Math.pow(xizq, 5)-Math.pow(xizq, 4)+Math.pow(xizq, 3)-3;
            System.out.println("f(xizq)="+funcionIzq);
       
            xr=xder-funcionDer*(xizq-xder)/(funcionIzq-funcionDer);
            System.out.println("xr="+xr);
           
            funcionRaiz=Math.pow(xr, 5)-Math.pow(xr, 4)+Math.pow(xr, 3)-3;
            System.out.println("f(xr)="+xr);
           
        }else if ((funcionIzq*funcionRaiz)>0){
            System.out.println("Vuelva a introducir el límite izquierdo del intervalo: ");
            xizq=in.nextInt();
            System.out.println("El intervalo es ["+xizq+","+xder+"]");
            funcionDer=Math.pow(xder, 5)-Math.pow(xder, 4)+Math.pow(xder, 3)-3;
            System.out.println("f(xder)="+funcionDer);
           
            funcionIzq=Math.pow(xizq, 5)-Math.pow(xizq, 4)+Math.pow(xizq, 3)-3;
            System.out.println("f(xizq)="+funcionIzq);
       
            xr=xder-funcionDer*(xizq-xder)/(funcionIzq-funcionDer);
            System.out.println("xr="+xr);
           
            funcionRaiz=Math.pow(xr, 5)-Math.pow(xr, 4)+Math.pow(xr, 3)-3;
            System.out.println("f(xr)="+xr);
           
        }else if((funcionIzq*funcionRaiz)==0){
            System.out.println("La raíz es: "+xr);
           
        }
        }
       
       
       
       
 
    }
 
}