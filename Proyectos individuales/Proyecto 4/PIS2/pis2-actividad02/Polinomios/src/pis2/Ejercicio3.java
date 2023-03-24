package pis2;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
	
	private ArrayList<Integer> polinomio;
	static boolean hayraiz = false;
	
	public Ejercicio3 () {
		this.polinomio = new ArrayList<Integer>();
		
		polinomio.add(-3);
		polinomio.add(0);
		polinomio.add(0);
		polinomio.add(1);
		polinomio.add(-1);
		polinomio.add(1);	
	}
	
	/***
	 * Interpolating method
	 * @param xizq: start of the interval
	 * @param xder: end of the interval
	 * @param count: count of output interpolated numbers
	 * @return array of interpolated number with specified count
	 */
	public double[] interpolate(double xizq, double xder, int count) {
	    if (count < 2) {
	        throw new IllegalArgumentException("interpolate: illegal count!");
	    }
	    double[] array = new double[count + 1];
	    for (int i = 0; i <= count; ++ i) {
	        array[i] = xizq + i * (xder - xizq) / count;
	    }
	    return array;
	}
	
	public ArrayList<Double> comprobarRaiz(double xizq, double xder, int precision) {
		
		double[] array = null;
		
		ArrayList<Double> solucion = new ArrayList<Double>();
		double fxizq = 0, fxder = 0;
		double parcialIzq, parcialDer;
		ArrayList<Double> izquierda = new ArrayList<Double>();
		ArrayList<Double> derecha = new ArrayList<Double>();
		ArrayList<Double> raiz = new ArrayList<Double>();
		double xr, fxr = 0;
		double r;
		
		//añadir a lista soluciones
		for(int i=0; i<polinomio.size(); i++) {
			parcialIzq = Math.pow(xizq * polinomio.get(i), i);
			izquierda.add(parcialIzq);
		}
		for(int i=0; i<polinomio.size(); i++) {
			parcialDer = Math.pow(xder * polinomio.get(i), i);
			derecha.add(parcialDer);
		}
		
		//sumar de lista soluciones
		for(int i = 0; i < izquierda.size(); i++) {
		    fxizq += izquierda.get(i);
		}
		for(int i = 0; i < derecha.size(); i++) {
		    fxder += derecha.get(i);
		}
		System.out.println("Valor de fxizq: " + fxizq);
		System.out.println("Valor de fxder: " + fxder);
		
		//xr = xder – f(xder)*(xizq-xder)/(f(xizq)-f(xder))
		xr = xder - fxder * (xizq - xder) / (fxizq - fxder);
		
		//array = interpolate(fxizq, fxder, precision);
		//solucion = arrayAsList(array);
		
		solucion.add(xr);
		//System.out.println(xr);
		
		//añadir a lista raiz
		for(int i=0; i<polinomio.size(); i++) {
			r = Math.pow(xr * polinomio.get(i), i);
			raiz.add(r);
		}
		
		//sumar de lista raiz
		for(int i = 0; i < raiz.size(); i++) {
		    fxr += raiz.get(i);
		}
		
		boolean evaluaciones = evaluaciones(fxizq, fxr);
		if(evaluaciones) {
			solucion.add(fxr);
		}
		//System.out.println(fxr);
		
		return solucion;
	}
	
	public boolean evaluaciones(double fxizq, double fxr) {
		/**
		 * 	EVALUACIONES
		 * 	Si f(xizq)*f(xr)<0 : redefinir límite derecho del intervalo: xder - xr
			Si f(xizq)*f(xr)>0 : redefinir límite izquierdo del intervalo: xizq - xr
			Si f(xizq)*f(xr)=0 : hay una raíz en xr
		 */
		
		if((fxizq * fxr) < 0) {
			System.out.println("valores incorrectos.");
		}
		else {
			if((fxizq * fxr) > 0) {
				System.out.println("hay una raiz en xr.");
				hayraiz = true;
			}
			else {
				System.out.println("no existe raiz en xr.");
			}
		}
		return hayraiz;
	}

	public ArrayList<Double> arrayAsList(double[] array) {
	    ArrayList<Double> lista = new ArrayList<Double>();
	    for (int index = 0; index < array.length; index++)
	    {
	        lista.add(array[index]);
	    }
	    return lista;
	}
}
