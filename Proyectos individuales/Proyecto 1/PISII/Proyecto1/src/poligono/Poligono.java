package poligono;

import java.util.ArrayList;

public class Poligono {

	ArrayList<Punto> poligono;
	
	public Poligono(ArrayList<Punto> poligon) {
		poligono = poligon;
	}
	
	public boolean concavo(){
		Vector vec1, vec2;
		
		//Comprobamos el signo del primer producto vectorial
		int i = 0;
		//Creamos vectores a partir de los primeros puntos
		vec1 = new Vector(poligono.get(i), poligono.get(i+1));
		vec2 = new Vector(poligono.get(i+1), poligono.get(i+2));
		double prodVectorial = vec1.productoVectorial(vec2);
		boolean positivo = prodVectorial >= 0;
		
		//Calculamos el signo de los demás productos vectoriales
		for (i = 1; i < poligono.size()-2; i++) {
			vec1 = new Vector(poligono.get(i), poligono.get(i+1));
			vec2 = new Vector(poligono.get(i+1), poligono.get(i+2));
			prodVectorial = vec1.productoVectorial(vec2);
			//Si tienen distinto signo es cóncavo
			if (positivo != (prodVectorial >= 0)) {
				return true;
			}
		}
		//Calculamos el producto vectorial del último y el primer vector
		vec1 = new Vector(poligono.get(i+1), poligono.get(0));
		prodVectorial = vec2.productoVectorial(vec1);
		if (positivo != (prodVectorial >= 0)) {
			return true;
		}
		return false;
	}
	
	public Punto centroide(){
		double X=0, Y=0, A=0;
		int mod = poligono.size();
		for (int k = 0; k < poligono.size(); k++) {
			A+=poligono.get(k).getPosX()*poligono.get((k+1)%mod).getPosY()-poligono.get((k+1)%mod).getPosX()*poligono.get(k).getPosY();
		}
		A=A/2;
		
		for (int k = 0; k < poligono.size(); k++) {
			X+=(poligono.get(k).getPosX()+poligono.get((k+1)%mod).getPosX())*(poligono.get(k).getPosX()*poligono.get((k+1)%mod).getPosY()-poligono.get((k+1)%mod).getPosX()*poligono.get(k).getPosY());
		}
		X=X/(6*A);
		
		for (int k = 0; k < poligono.size(); k++) {
			Y+=(poligono.get(k).getPosY()+poligono.get((k+1)%mod).getPosY())*(poligono.get(k).getPosX()*poligono.get((k+1)%mod).getPosY()-poligono.get((k+1)%mod).getPosX()*poligono.get(k).getPosY());
		}
		Y=Y/(6*A);
		return new Punto((int) X, (int)Y);
	}
	
	public String toString(){
		return poligono.toString();
	}


}
