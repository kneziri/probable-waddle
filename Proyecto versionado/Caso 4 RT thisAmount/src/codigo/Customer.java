package codigo;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

private String name;
private ArrayList rentals = new ArrayList();

public Customer (String inname){
name = inname;
};

public void addRental(Rental arg) {
	rentals.add(arg);
}
public String getName (){
return name;
}

public String statement() {
double totalAmount = 0;
int frequentRenterPoints = 0;

Iterator<Rental> itrentals = rentals.iterator();

String result = "Rental Record for " + getName() + "\n";

while (itrentals.hasNext()) {
	Rental each =  itrentals.next();
	
	// add frequent renter points
	frequentRenterPoints ++;
	// add bonus for a two day new release rental
	if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
	&&
	each.getDaysRented() > 1) frequentRenterPoints ++;
	//show figures for this rental
	result += "   " + each.getMovie().getTitle()+ " " +
	each.getCharge() + "\n";
	totalAmount += each.getCharge();
	}
	//add footer lines
	result += "Amount owed is " + totalAmount +
	"\n";
	result += "You earned " + frequentRenterPoints
	+
	" frequent renter points";
	return result;
	}

} 