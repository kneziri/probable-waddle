package pis2;

import java.util.ArrayList;

public class Polinomio {

	ArrayList<Integer> polinomio = new ArrayList<Integer>();
	
	public static ArrayList<Integer> suma (ArrayList<Integer> uno, ArrayList<Integer> dos)
	{
	
		ArrayList<Integer> sol = new ArrayList<Integer>();
		//Return the sum of itself and other polynomial
		if (uno.size() > dos.size()){
			
			int aux = (uno.size() - dos.size());
			for (int i=0; i<aux;i++)
				
				dos.add(0);
			for (int i=0; i<uno.size();i++)
			{
				sol.add(uno.get(i)+dos.get(i));
				
				
			}
			
		}
		else if (uno.size() < dos.size()){
			int aux = (dos.size() - uno.size());
			for (int i=0; i<aux;i++)
				uno.add(0);
			for (int i=0; i<dos.size();i++){
				sol.add(dos.get(i)+uno.get(i));
			}
		}
		
		else 
		{
			for (int i=0; i<dos.size();i++){
				sol.add(dos.get(i)+uno.get(i));
			}
		}
		
		
		return sol;
	}
	
	public static ArrayList<Integer> product(ArrayList<Integer> uno, ArrayList<Integer> dos) {
		// Return the product of itself and other polynomial

		ArrayList<Integer> sol = new ArrayList<Integer>();
		int aux = (uno.size() + dos.size()-2);
		for (int i = 0; i <= aux; i++)
			sol.add(0);
		for (int i = 0; i < uno.size(); i++) {
			for (int j = 0; j < dos.size(); j++) {
				sol.set(i + j, (uno.get(i) * dos.get(j))+sol.get(i+j));
			}
		}
		return sol;
	}

	public static ArrayList<Integer> divide_by (ArrayList<Integer> uno, ArrayList<Integer> dos) throws PolynominalTooLongError{
		//Return a tuple with the quotient and remainder		
		
		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int i=0; i<uno.size();i++)
			sol.add(0);
		if (dos.size() > 2)
			throw new PolynominalTooLongError();
		int carry = 0;
		int divisor = -dos.get(0);
		for(int i = uno.size()-1; i>=0 ; i--){
			sol.set(i, (carry + uno.get(i)));
			carry = sol.get(i)*divisor;
		}
				
		return sol;
		
	}
	
	public static ArrayList<Integer> derivate (ArrayList<Integer> uno){
		//Return an array with the derivated polynome.
		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int i=0; i<uno.size()-1; i++)
			sol.add(0);
		
		for (int i =1, j =0; i<uno.size();i++, j++){
			sol.set(j, (i*uno.get(i)));
		}		
		return sol;
	}
		 
	static class PolynominalTooLongError extends Exception
	{
	      //Parameterless Constructor
	      public PolynominalTooLongError() {}

	      //Constructor that accepts a message
	      public PolynominalTooLongError(String message)
	      {
	         super(message);
	      }
	 }
	
}
