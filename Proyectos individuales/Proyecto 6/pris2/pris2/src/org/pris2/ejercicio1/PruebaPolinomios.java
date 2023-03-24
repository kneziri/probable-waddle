
package org.pris2.ejercicio1;

import java.util.ArrayList;
import java.util.List;


public class PruebaPolinomios {

	public static void main(String[] args) {
		
		List<Monomio> coefisVariao = new ArrayList<Monomio>();
		coefisVariao.add(new Monomio(1.0, 2, 'x'));
		coefisVariao.add(new Monomio(3.0, 3, 'x'));
		coefisVariao.add(new Monomio(5.0, 4, 'x'));
		coefisVariao.add(new Monomio(2.0, 2, 'x'));
		coefisVariao.add(new Monomio(6.0, 3, 'x'));
		coefisVariao.add(new Monomio(4.0, 7, 'x'));
		Polinomio p2 = new Polinomio(coefisVariao);
		
		System.out.println("Polinomio 1:");
		System.out.println(p2);
		System.out.println("polinomio 1 simplificado: ");
		p2.juntarComunes2((ArrayList<Monomio>) coefisVariao);
		System.out.println(" ");
		
		List<Monomio> coefisVariao2 = new ArrayList<Monomio>();
		coefisVariao2.add(new Monomio(1.0, 2, 'x'));
		coefisVariao2.add(new Monomio(3.0, 3, 'x'));
		coefisVariao2.add(new Monomio(5.0, 4, 'x'));
		coefisVariao2.add(new Monomio(2.0, 2, 'x'));
		coefisVariao2.add(new Monomio(6.0, 3, 'x'));
		coefisVariao2.add(new Monomio(4.0, 7, 'x'));
		Polinomio p3 = new Polinomio(coefisVariao);
		System.out.println("Polinomio 2:");
		System.out.println(p2);
		System.out.println("polinomio 2 simplificado: ");
		p3.juntarComunes2((ArrayList<Monomio>) coefisVariao2);
		System.out.println(" ");
		
		System.out.println("Suma:");
		System.out.print("(" + p3 + ")+(" + p2 + ") = ");
		System.out.println(Polinomio.sumar(p3,p2));

		
		System.out.println("Multiplicacion:");
		System.out.print("(" + p3 + ")*(" + p2 + ") = ");
		System.out.println(p3.mult(p2));

		
		
	}

}