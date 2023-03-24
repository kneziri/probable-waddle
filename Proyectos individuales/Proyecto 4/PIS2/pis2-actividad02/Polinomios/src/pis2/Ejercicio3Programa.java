package pis2;

import java.util.List;
import java.util.Scanner;

public class Ejercicio3Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ejercicio3 ej3 = new Ejercicio3();
		double[] arrayResultado = null;
		List<Double> listaResultado = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introducir xizq:");
		double xizq = sc.nextDouble();
		System.out.println("Introducir xder:");
		double xder = sc.nextDouble();
		System.out.println("Introducir precision:");
		int precision = sc.nextInt();
		
		listaResultado = ej3.comprobarRaiz(xizq, xder, precision);
		//System.out.println(listaResultado);
		
		boolean hayraiz = ej3.hayraiz;
		
		System.out.println("Valor de xr: " + listaResultado.get(0));
		
		if(hayraiz) {
			System.out.println("Valor de f(xr): " + listaResultado.get(1));
		}
	}

}
