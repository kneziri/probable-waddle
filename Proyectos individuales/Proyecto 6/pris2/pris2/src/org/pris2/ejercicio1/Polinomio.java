package org.pris2.ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Polinomio {

	// se guardara como orden de menor a mayor
	private List<Monomio> terminos;

	public List<Monomio> getTerminos() {
		return terminos;
	}

	/**
	 * Genera un objeto de tipo Polinomio a partir de un list de monomios
	 */
	public Polinomio(List<Monomio> terminos) {
		Collections.sort(terminos);
		this.terminos = terminos;
	}

	/**
	 * Genera un objeto de tipo Polinomio a partir de un array de coeficientes
	 * completo
	 */
	public Polinomio(Double[] coeficientes) {
		terminos = new ArrayList<Monomio>(coeficientes.length);
		for (int i = 0; i < coeficientes.length; i++)
			terminos.add(new Monomio(coeficientes[i], i, 'x'));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<Monomio> it = terminos.iterator(); it.hasNext();)
			sb.append(it.next());
		return sb.toString();
	}

	/**
	 * Añade un monomio al polinomio
	 */
	public void addMonomio(Monomio otro) {
		terminos.add(otro);
		Collections.sort(terminos);
	}

	/**
	 * Elimina un monomio del polinomio
	 */
	public boolean removeMonomio(Monomio otro) {
		return terminos.remove(otro);
	}

	/**
	 * Suma el polinomio this con otro
	 */
	public Polinomio sumar(Polinomio otro) {
		ArrayList<Monomio> termSumas = new ArrayList<Monomio>();
		Iterator<Monomio> it = terminos.iterator();
		Iterator<Monomio> it2 = otro.terminos.iterator();
		while (it.hasNext()) {
			Monomio aux = it.next();
			while (it2.hasNext())
				try {
					termSumas.add(aux.sumar(it2.next()));
					break;// ya ha encontrado comun me salgo
				} catch (Exception e) {
					if (!it2.hasNext())// si no hay comunes lo mete direc
						termSumas.add(aux);
				}
			it2 = otro.terminos.iterator();
		}
		return new Polinomio(termSumas);
	}
	/**
	 * divide el polinomio this con otro
	 */
	private Polinomio dividir(Polinomio otro) {
		ArrayList<Monomio> termDiv = new ArrayList<Monomio>();
		Iterator<Monomio> it = terminos.iterator();
		Iterator<Monomio> it2 = otro.terminos.iterator();
		
		
		return null;
	}
	/**
	 * Multiplica el polinomio this con otro
	 */
	public Polinomio mult(Polinomio otro) {
		ArrayList<Monomio> termMult = new ArrayList<Monomio>();
		Iterator<Monomio> it = terminos.iterator();
		Iterator<Monomio> it2 = otro.terminos.iterator();
		while (it.hasNext()) {
			Monomio aux = it.next();
			while (it2.hasNext())
				termMult.add(aux.mult(it2.next()));
			it2 = otro.terminos.iterator();
		}
		juntarComunes(termMult);
		return new Polinomio(termMult);
	}

	/**
	 * Dado una lista de monomios junta los comunes
	 */
	@SuppressWarnings("unchecked")
	public void juntarComunes(ArrayList<Monomio> terms) {
		ArrayList<Monomio> auxTerms = (ArrayList<Monomio>) terms.clone();
		terms.clear();// limpio terms, metere los validos
		Iterator<Monomio> it = auxTerms.iterator();
		ListIterator<Monomio> it2 = auxTerms.listIterator();
		Monomio aux, aux2, comunes;
		// itero comparando cada valor con todos los demas
		// cada vez que junte un comun lo elimina
		while (it.hasNext()) {
			aux = it.next();
			comunes = new Monomio(aux);// guardara los valores comunes
			while (it2.hasNext()) {
				aux2 = it2.next();
				if ((aux != aux2)) {// si no es él mismo
					try {
						comunes.addSumar(aux2);
						it2.remove();// delete ya estudiado
					} catch (Exception e) {
						continue;// continua iterando
					}
				}
			}
			terms.add(comunes);
			auxTerms.remove(aux);// del ya estudiado
			// reseteo iteradores
			it = auxTerms.iterator();
			it2 = auxTerms.listIterator();
			
		}
		
	}

	//para mostrar el polinomio simplificado
	public void juntarComunes2(ArrayList<Monomio> terms) {
		ArrayList<Monomio> auxTerms = (ArrayList<Monomio>) terms.clone();
		terms.clear();// limpio terms, metere los validos
		Iterator<Monomio> it = auxTerms.iterator();
		ListIterator<Monomio> it2 = auxTerms.listIterator();
		Monomio aux, aux2, comunes;
		// itero comparando cada valor con todos los demas
		// cada vez que junte un comun lo elimina
		while (it.hasNext()) {
			aux = it.next();
			comunes = new Monomio(aux);// guardara los valores comunes
			while (it2.hasNext()) {
				aux2 = it2.next();
				if ((aux != aux2)) {// si no es él mismo
					try {
						comunes.addSumar(aux2);
						it2.remove();// delete ya estudiado
					} catch (Exception e) {
						continue;// continua iterando
					}
				}
			}
			terms.add(comunes);
			auxTerms.remove(aux);// del ya estudiado
			// reseteo iteradores
			it = auxTerms.iterator();
			it2 = auxTerms.listIterator();
			System.err.print(comunes.toString());
		}
		
	}

	
	/**
	 * Suma dos Polinomios
	 */
	public static Polinomio sumar(Polinomio a, Polinomio b) {
		return a.sumar(b);
	}

	 /**
	 * Multiplica dos Polinomios
	 */
	public static Polinomio mult(Polinomio a, Polinomio b) {
		return a.mult(b);
	}
	/**
	 * divide polinomios
	 */
	public static Polinomio dividir(Polinomio a,Polinomio b){
		return a.dividir(b);
	}

	
	
}