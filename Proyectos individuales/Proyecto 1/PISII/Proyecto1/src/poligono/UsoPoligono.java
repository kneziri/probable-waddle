package poligono;

import java.util.ArrayList;

public class UsoPoligono {

	public static void main(String[] args) {

		//Creamos 7 puntos
		Punto puntoA = new Punto(2, 10);
		Punto puntoB = new Punto(0, 5);
		Punto puntoC = new Punto(2, 0);
		Punto puntoD = new Punto(8, 0);
		Punto puntoE = new Punto(10, 5);
		Punto puntoF = new Punto(8, 10);
		Punto puntoP = new Punto(5, 5);

		Vector vector1 = new Vector(puntoA, puntoB);
		Vector vector2 = new Vector(puntoB, puntoC);
		
		//Creamos un polígono cóncavo
		ArrayList<Punto> poligon = new ArrayList<Punto>(7);
		poligon.add(puntoA);
		poligon.add(puntoB);
		poligon.add(puntoC);
		poligon.add(puntoD);
		poligon.add(puntoE);
		poligon.add(puntoF);
		poligon.add(puntoP);
		Poligono poligono1 = new Poligono(poligon);
		
		//Creamos un cuadrado (convexo)
		poligon = new ArrayList<Punto>(4);
		poligon.add(puntoA);
		poligon.add(puntoC);
		poligon.add(puntoD);
		poligon.add(puntoF);
		Poligono poligono2 = new Poligono(poligon);
		
		Linea ln = new Linea(1, new Punto (1, 1));
		Linea ln2 = new Linea(2, new Punto (0, 0));

		System.out.println(puntoA);
		System.out.println(puntoB);
		System.out.println(puntoC);
		System.out.println(vector1);
		System.out.println(vector2);
		System.out.println(poligono1.concavo());
		System.out.println(poligono2.concavo());
		System.out.println(poligono2.centroide());
		System.out.println(ln);
		System.out.println(ln2);
		System.out.println(ln.puntoCorte(ln2));

	}

}
