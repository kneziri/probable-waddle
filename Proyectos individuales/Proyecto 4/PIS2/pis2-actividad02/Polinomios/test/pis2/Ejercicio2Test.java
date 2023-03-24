package pis2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Ejercicio2Test {

	@Test
	public void testEstable() {
		
		Ejercicio2 ej2 = new Ejercicio2();
		ArrayList<Double> polinomio = new ArrayList<Double>();
		ArrayList<Double> s0 = new ArrayList<Double>();
		ArrayList<Double> s1 = new ArrayList<Double>();
		ArrayList<Double> s2 = new ArrayList<Double>();
		ArrayList<Double> s3 = new ArrayList<Double>();
		ArrayList<Double> s4 = new ArrayList<Double>();
		
		polinomio.add(1.0);
		polinomio.add(10.0);
		polinomio.add(35.0);
		polinomio.add(50.0);
		polinomio.add(124.0);
		
		s0.add(124.0);
		
		s1.add(8.666666666666666);
		
		s2.add(30.0);
		s2.add(124.0);
		
		s3.add(10.0);
		s3.add(50.0);
		
		s4.add(1.0);
		s4.add(35.0);
		s4.add(124.0);
		
		ej2.routhHurwitz(polinomio);
		
		//mostrar matriz de Routh
		System.out.println(ej2.s4);
		System.out.println(ej2.s3);
		System.out.println(ej2.s2);
		System.out.println(ej2.s1);
		System.out.println(ej2.s0);
		
		//comprobar matriz de Routh
		assertEquals(s4, ej2.s4);
		assertEquals(s3, ej2.s3);
		assertEquals(s2, ej2.s2);
		assertEquals(s1, ej2.s1);
		assertEquals(s0, ej2.s0);
		
		System.out.println("Sistema estable. "
				+ "No hay raíces en semiplano derecho");
		
		System.out.println("\n");
	}
	
	@Test
	public void testDegeneracion() {
		
		Ejercicio2 ej2 = new Ejercicio2();
		ArrayList<Double> polinomio = new ArrayList<Double>();
		ArrayList<Double> s2 = new ArrayList<Double>();
		ArrayList<Double> s3 = new ArrayList<Double>();
		ArrayList<Double> s4 = new ArrayList<Double>();
		
		polinomio.add(1.0);
		polinomio.add(3.0);
		polinomio.add(2.0);
		polinomio.add(6.0);
		polinomio.add(3.0);
		polinomio.add(3.0);
		
		s2.add(0.0);
		s2.add(2.0);
		
		s3.add(3.0);
		s3.add(6.0);
		s3.add(3.0);
		
		s4.add(1.0);
		s4.add(2.0);
		s4.add(3.0);
		
		ej2.routhHurwitz(polinomio);
		
		//mostrar matriz de Routh
		System.out.println(ej2.s4);
		System.out.println(ej2.s3);
		System.out.println(ej2.s2);
		
		//comprobar matriz de Routh
		assertEquals(s4, ej2.s4);
		assertEquals(s3, ej2.s3);
		assertEquals(s2, ej2.s2);
		
		System.out.println("Degeneración en el cálculo. "
				+ "Primer elemento de fila es cero");
		
		System.out.println("\n");
	}

	@Test
	public void testInestable() {
		
		Ejercicio2 ej2 = new Ejercicio2();
		ArrayList<Double> polinomio = new ArrayList<Double>();
		ArrayList<Double> s0 = new ArrayList<Double>();
		ArrayList<Double> s1 = new ArrayList<Double>();
		ArrayList<Double> s2 = new ArrayList<Double>();
		ArrayList<Double> s3 = new ArrayList<Double>();
		ArrayList<Double> s4 = new ArrayList<Double>();
		double n0 = 6.0;
		
		polinomio.add(1.0);
		polinomio.add(4.0);
		polinomio.add(2.0);
		polinomio.add(5.0);
		polinomio.add(3.0);
		polinomio.add(6.0);
		
		s0.add(3.0);
		
		s1.add(-3.0);
		s1.add(6.0);
		
		s2.add(0.75);
		s2.add(1.5);
		
		s3.add(4.0);
		s3.add(5.0);
		s3.add(6.0);
		
		s4.add(1.0);
		s4.add(2.0);
		s4.add(3.0);
		
		ej2.routhHurwitz(polinomio);
		
		//mostrar matriz de Routh
		System.out.println(ej2.s4);
		System.out.println(ej2.s3);
		System.out.println(ej2.s2);
		System.out.println(ej2.s1);
		System.out.println(ej2.s0);
		System.out.println(ej2.n0);
		
		//comprobar matriz de Routh
		assertEquals(s4, ej2.s4);
		assertEquals(s3, ej2.s3);
		assertEquals(s2, ej2.s2);
		assertEquals(s1, ej2.s1);
		assertEquals(s0, ej2.s0);
		assertEquals(n0, ej2.n0, 0);
		
		System.out.println("Sistema inestable. "
				+ "Dos raíces positivas (hay dos cambios de signo en primera columna)");
		
		System.out.println("\n");
	}
	
	@Test
	public void testCritico() {
		
		Ejercicio2 ej2 = new Ejercicio2();
		ArrayList<Double> polinomio = new ArrayList<Double>();
		ArrayList<Double> s0 = new ArrayList<Double>();
		ArrayList<Double> s1 = new ArrayList<Double>();
		ArrayList<Double> s2 = new ArrayList<Double>();
		ArrayList<Double> s3 = new ArrayList<Double>();
		ArrayList<Double> s4 = new ArrayList<Double>();
		double n0 = 18.0;
		
		polinomio.add(1.0);
		polinomio.add(2.0);
		polinomio.add(11.0);
		polinomio.add(18.0);
		polinomio.add(18.0);
		
		s0.add(4.0);
		
		s1.add(0.0);
		
		s2.add(2.0);
		s2.add(18.0);
		
		s3.add(2.0);
		s3.add(18.0);
		
		s4.add(1.0);
		s4.add(11.0);
		s4.add(18.0);
		
		ej2.routhHurwitz(polinomio);
		
		//mostrar matriz de Routh
		System.out.println(ej2.s4);
		System.out.println(ej2.s3);
		System.out.println(ej2.s2);
		System.out.println(ej2.s1);
		System.out.println(ej2.s0);
		System.out.println(ej2.n0);
		
		//comprobar matriz de Routh
		assertEquals(s4, ej2.s4);
		assertEquals(s3, ej2.s3);
		assertEquals(s2, ej2.s2);
		assertEquals(s1, ej2.s1);
		assertEquals(s0, ej2.s0);
		assertEquals(n0, ej2.n0, 0);
		
		System.out.println("Sistema críticamente estable. "
				+ "Fila cero. No hay raíces positivas");
		
		System.out.println("\n");
	}
}
