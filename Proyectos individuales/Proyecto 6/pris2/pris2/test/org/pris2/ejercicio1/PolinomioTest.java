package org.pris2.ejercicio1;

import java.util.ArrayList;
import java.util.List;

import org.pris2.ejercicio1.Monomio;
import org.pris2.ejercicio1.Polinomio;

import junit.framework.*;

public class PolinomioTest extends TestCase {
	
	Monomio monomio1 = new Monomio(5.0, 5, 'x');
	Monomio monomio2 = new Monomio(5.0,5,'x');
	Monomio monomio3 = new Monomio(7.0,2,'x');
	Monomio monomio4 = new Monomio(1.0,9,'x');
	Monomio monomio5 = new Monomio(-5.0,9,'x');
	
	public void testMonomio(){
		assertEquals(0, monomio1.compareTo(monomio2));
		assertEquals(1, monomio1.compareTo(monomio3));
		assertEquals(-1, monomio1.compareTo(monomio4));
		
		assertEquals(monomio1.toString(), "+5x^5");
	}
	
	public void testPolinomio(){
		//crear polinomios
			//polinomio1
		List<Monomio> mono=new ArrayList<Monomio>();
		mono.add(monomio1);
		mono.add(monomio2);
		mono.add(monomio3);
		mono.add(monomio4);
		mono.add(monomio5);
		Polinomio polinomio1 = new Polinomio(mono);
			//polinomio2
		List<Monomio> mono2=new ArrayList<Monomio>();
		mono2.add(monomio1);
		mono2.add(monomio2);
		mono2.add(monomio3);
		Polinomio polinomio2=new Polinomio(mono2);
		
		
		//System.out.println(polinomio1.toString());
		//prueba toString
		assertEquals("+7x^2+5x^5+5x^5+1x^9-5x^9", polinomio1.toString());
		//prueba simplificar
		polinomio1.juntarComunes((ArrayList<Monomio>) mono);
		polinomio2.juntarComunes((ArrayList<Monomio>) mono2);
		assertEquals("+7x^2+10x^5-4x^9", polinomio1.toString());
		System.out.println("p1:    "+polinomio1.toString());
		System.out.println("p2:    "+polinomio2.toString());
		System.out.println("------");
		
		//prueba suma
	
		Polinomio suma=polinomio1.sumar(polinomio2);
		assertEquals("+14x^2+20x^5-4x^9",suma.toString());
		System.out.println("suma p1+p2:     "+suma.toString());
		System.out.println("------");
		
		//prueba multiplicar
		
		Polinomio multiplicacion=polinomio1.mult(polinomio2);
		assertEquals("+49x^4+140x^7+100x^10-28x^11-40x^14",multiplicacion.toString());
		System.out.println("multiplica p1 * p2:     "+multiplicacion.toString());
		System.out.println("------");
		
	}

}
