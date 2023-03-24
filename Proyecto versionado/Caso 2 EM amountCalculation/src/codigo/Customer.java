package codigo;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

private String name;
private ArrayList<Rental> rentals = new ArrayList<Rental>();

public Customer (String inname){
name = inname;
}

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
	double thisAmount;
	Rental each =  itrentals.next();
	//determine amounts for each line
	thisAmount = amountOf(each);
	// add frequent renter points
	frequentRenterPoints ++;
	// add bonus for a two day new release rental
	if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
	&&
	each.getDaysRented() > 1){ 
		frequentRenterPoints ++;
		}
	//show figures for this rental
	result += "   " + each.getMovie().getTitle()+ " " +
	thisAmount + "\n";
	totalAmount += thisAmount;
	}
	//add footer lines
	result += "Amount owed is " + totalAmount +
	"\n";
	result += "You earned " + frequentRenterPoints
	+
	" frequent renter points";
	return result;
	}

private double amountOf(Rental aRental) {
	double thisAmount = 0;
	switch (aRental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (aRental.getDaysRented() > 2){
			thisAmount += (aRental.getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			thisAmount += aRental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (aRental.getDaysRented() > 3){
				thisAmount += (aRental.getDaysRented() - 3) * 1.5;
			}
			break;
		default: break;
	}
	return thisAmount;
}	
	
} 