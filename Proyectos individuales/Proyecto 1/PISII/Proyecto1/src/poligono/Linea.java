package poligono;

//Linea creada a partir de la pendiente y un punto.
public class Linea {
	private int n, x;
	
	public Linea (int m, Punto punto){
		x = m;
		n = -m*punto.getPosX() + punto.getPosY();
	}
	
	public String toString(){
		return "y = "+x+"x + ("+n+")";
	}
	
	public String implicita(){
		return x+"x - y ("+n+") = 0";
	}
	
	public String puntoCorte(Linea otra){
		double coordenadaX, coordenadaY;
		if (this.x == otra.x) {
			return "paralelas o coincidentes";
		}
		coordenadaX = (this.n-otra.n)/(this.x-otra.x)*(-1);
		coordenadaY = this.x*coordenadaX+this.n;
		return "("+coordenadaX+", "+coordenadaY+")";
	}

}
