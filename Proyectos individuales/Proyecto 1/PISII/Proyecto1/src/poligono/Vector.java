package poligono;

public class Vector {

	Punto punto1;
	Punto punto2;
	
	
	public Vector(Punto punto1,Punto punto2){
		this.punto1=punto1;
		this.punto2=punto2;
	}
	
	public int coordenadaX(){
		return punto2.posX - punto1.posX;
	}
	
	public int coordenadaY(){
		return punto2.posY - punto1.posY;
	}
	
	public double modulo(){
		return Math.sqrt(Math.pow(coordenadaX(), 2)+Math.pow(coordenadaY(), 2));
	}
	
	public int productoVectorial(Vector vector){
		return this.coordenadaX()*vector.coordenadaY()-this.coordenadaY()*vector.coordenadaX();
	}
	
	public String toString(){
		return "y="+(punto2.getPosX()-punto1.getPosX())+"x+"+(punto2.getPosY()-punto1.getPosY());
	}
}
