package org.pris2.ejercicio3;

public class Ejercicio3 {
	int xizq=0;
    int xder=0;
    double precision=0.0;
    double xr=0.0;
    double funcionDer=0.0;
    double funcionIzq=0.0;
    double funcionRaiz=0.0;
    
    public Ejercicio3(int izq,int der,double pre,double xr,double fd,double fi,double fraiz){
    	this.xizq=izq;
    	this.xder=der;
    	this.precision=pre;
    	this.xr=xr;
    	this.funcionDer=fd;
    	this.funcionIzq=fi;
    	this.funcionRaiz=fraiz;
    }
    public Ejercicio3() {
		// TODO Auto-generated constructor stub
    	int xizq=0;
        int xder=0;
        double precision=0.0;
        double xr=0.0;
        double funcionDer=0.0;
        double funcionIzq=0.0;
        double funcionRaiz=0.0;
	}
	public Double funcionDerecha(int xderecha){
    	funcionDer=Math.pow(xderecha, 5)-Math.pow(xderecha, 4)+Math.pow(xderecha, 3)-3;
        System.out.println("f(xder)="+funcionDer);
        return funcionDer;
    }
    
    public Double funcionIzquierda(int xizquierda){
    	funcionIzq=Math.pow(xizquierda, 5)-Math.pow(xizquierda, 4)+Math.pow(xizquierda, 3)-3;
        System.out.println("f(xizquierda)="+funcionIzq);
        return funcionIzq;
    }
    
    public Double xr(int xizq,int xder,double funcionIzq,Double funcionDer)
    {

        xr=xder-funcionDer*(xizq-xder)/(funcionIzq-funcionDer);
        System.out.println("xr="+xr);
        return xr;
    }
    
   public Double funcionRaiz(double xr){
	   funcionRaiz=Math.pow(xr, 5)-Math.pow(xr, 4)+Math.pow(xr, 3)-3;
       System.out.println("f(xr)="+funcionRaiz);
       return funcionRaiz;
   }
}
