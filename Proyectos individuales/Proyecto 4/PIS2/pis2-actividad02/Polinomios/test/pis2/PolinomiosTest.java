package pis2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import pis2.Polinomio.PolynominalTooLongError;

public class PolinomiosTest {

	@Test
	public void testSumaIguales()
	{
		
		ArrayList<Integer> uno = new ArrayList<Integer>();
		ArrayList<Integer> dos = new ArrayList<Integer>();
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		ArrayList<Integer> solucion1 = new ArrayList<Integer>();
		
		uno.add(1);
		uno.add(2);
		uno.add(3);
		
		dos.add(1);
		dos.add(2);
		dos.add(3);
		
		solucion.add(2);
		solucion.add(4);
		solucion.add(6);
		
		solucion1=Polinomio.suma(uno, dos);
		assertEquals(solucion,solucion1);
	}
	
	@Test
	public void testSumaPrimeroMayor()
	{
		ArrayList<Integer> uno = new ArrayList<Integer>();
		ArrayList<Integer> dos = new ArrayList<Integer>();
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		ArrayList<Integer> solucion1 = new ArrayList<Integer>();
		
		uno.add(1);
		uno.add(2);
		uno.add(3);
		
		dos.add(1);
		dos.add(2);
		
		solucion.add(2);
		solucion.add(4);
		solucion.add(3);
		
		solucion1=Polinomio.suma(uno, dos);
		assertEquals(solucion,solucion1);
	}
	
	@Test
	public void testSumaSegundoMayor()
	{
		ArrayList<Integer> uno = new ArrayList<Integer>();
		ArrayList<Integer> dos = new ArrayList<Integer>();
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		ArrayList<Integer> solucion1 = new ArrayList<Integer>();
				
		uno.add(1);
		uno.add(2);
				
		dos.add(1);
		dos.add(2);
		uno.add(3);
		
		solucion.add(2);
		solucion.add(4);
		solucion.add(3);
		
		solucion1=Polinomio.suma(uno, dos);
		assertEquals(solucion,solucion1);
	}
	
	@Test
	public void testProducto(){
		
		ArrayList<Integer> uno = new ArrayList<Integer>();
		ArrayList<Integer> dos = new ArrayList<Integer>();
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		ArrayList<Integer> solucion1 = new ArrayList<Integer>();
		
		uno.add(1);
		uno.add(2);
		uno.add(3);
		
		dos.add(1);
		dos.add(2);
		dos.add(3);
		
		solucion.add(1);
		solucion.add(4);
		solucion.add(10);
		solucion.add(12);
		solucion.add(9);
		
		solucion1 = Polinomio.product(uno, dos);
		assertEquals(solucion, solucion1);
	}
	
	@Test
	public void testDivision() throws PolynominalTooLongError{
		
		ArrayList<Integer> uno = new ArrayList<Integer>();
		ArrayList<Integer> dos = new ArrayList<Integer>();
		ArrayList<Integer> solucion = new ArrayList<Integer>();
		ArrayList<Integer> solucion1 = new ArrayList<Integer>();
		
		uno.add(4);
		uno.add(13);
		uno.add(0);
		uno.add(8);
		uno.add(5);
		
		dos.add(3);
		dos.add(1);
		dos.add(3);
		
		try{
			solucion1 = Polinomio.divide_by(uno, dos);
		}catch(Exception e){
			assertTrue(true);
		}
		
		dos.remove(dos.size()-1);
		
		solucion.add(154);
		solucion.add(-50);
		solucion.add(21);
		solucion.add(-7);
		solucion.add(5);
		
		solucion1 = Polinomio.divide_by(uno, dos);
		
		assertEquals(solucion, solucion1);
		
	}
}
