
/*
 * Problem statement
This assessment consists in writing a simple application that prints out the details of a
receipt containing items purchased by a customer. The receipt should list the number of
items, the name, the final price (including taxes) of each of the item purchased, plus two
extra lines showing the total amount of the receipt and the total amount of taxes.
Taxes are calculated with a rate of 17.5%, rounding the result to the upper 0.05. Please note
that medical products are exempt and an additional 1.25 fixed amount is added as an extra
tax on CDs
What you need to provide
We expect you to provide a working solution to the problem, at least for the scenarios
provided; it may just consist of hard coded data in a set of unit tests. Please note that
input/output or persistency are NOT required, concentrate your efforts on a good design.
 */
import java.util.*;
public class Shop {
	
	static class items
	{
		int number;
		String prod_name;
		double price;
		public items(int number, String prod_name, double price)
		{
			this.number = number;
			this.prod_name = prod_name;
			this.price = price;
		}
		public items() {
			
		}
	}
	static class receipt
	{
		items myitems[] ;
		
		double sales_tax = 0;
		double total = 0;
		public receipt(int length)
		{
			myitems = new items[length];
			for(int j = 0; j < length ; j++)
			{
				myitems[j]= new items();
			}
			
		}
		
		public void calculate(items mylist[])
		{
			double price = 0;
			for(int i=0; i< mylist.length; i++)
			{
				if(((mylist[i].prod_name.contains("pills")) != true) && ((mylist[i].prod_name.contains("medicine")) != true))
				{
						price = mylist[i].price;
						this.myitems[i].number = mylist[i].number;
						this.myitems[i].price = price + mylist[i].price * (.175)*(myitems[i].number);
						if(mylist[i].prod_name.contains("CD") == true)
						{
							myitems[i].price = myitems[i].price + 1.25;
							this.sales_tax = this.sales_tax + 1.25;
						}
						this.myitems[i].prod_name = mylist[i].prod_name;
						this.sales_tax = this.sales_tax + mylist[i].price * (.175)*(myitems[i].number);
				}
				else
				{
					this.myitems[i].number = mylist[i].number;
					this.myitems[i].prod_name = mylist[i].prod_name;
					this.myitems[i].price = mylist[i].price;
					
				}
				
				this.total = this.total + myitems[i].price;
				
			}
		}
		
		public void display()
		{
			for(int i=0; i < myitems.length; i++)
			{
				System.out.println(myitems[i].number + " " + myitems[i].prod_name + " " + myitems[i].price);
			}
			System.out.println("Sales Taxes" + " " + this.sales_tax);
			System.out.println("Total" + " " + this.total);
		}
	}

	public static void main(String[] args) {
		
		int number_of_items_prchased = 4;
		receipt r = new receipt(number_of_items_prchased);
		int Customer_List = 1;
		items item_list[] = new items[number_of_items_prchased];
		for(int i=0;i< Customer_List; i++)
		{
			item_list[i] = new items(1,"bottle of wine",20.99);
			item_list[i+1] = new items(1,"box of tooth ache pills",4.15);
			item_list[i+2] = new items(1,"box of pins",11.25);
			item_list[i+3] = new items(1,"music CD",14.99);
		}
		r.calculate(item_list);
		r.display();
	    //{new items(1,"bottle of wine",20.99), new items(1,"box of tooth ache pills",4.15), new items(1,"box of pins","11.25")};

	}

}
