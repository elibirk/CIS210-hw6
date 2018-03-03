package hw6_perry_leah;

	import java.util.Scanner;
	import java.io.*;

	public class StockPriceSimulator {
		/*PROGRAM: StockPriceSimulator / Assignment 6 
		 * AUTHOR: Leah Perry
		 * Due Date: October 15, 2015
		 * SUMMARY: Simulates random changes over 30 days in stocks based on user input
		 */
		
			public static void main(String[]args) throws IOException {
				Scanner keyboard = new Scanner(System.in);
				
				String stockName;
				String stockSymbol;
				double oldPrice;
				double newPrice;
				
				
				System.out.println("Please enter the stock's information:\nYou may enter \"NONE\", "
						+ "\"NA\", and 0.0 to use default values.\nName: ");
				stockName = keyboard.next();
				System.out.println("Symbol: ");
				stockSymbol = keyboard.next();
				System.out.println("Yesterday's Price: ");
				oldPrice = keyboard.nextDouble();
				
				if(stockName != "NONE" || stockSymbol != "NA" || oldPrice != 0.0) {
					Stock userStock = new Stock(stockName, stockSymbol, oldPrice, oldPrice);
				}//if there are values set them as the stock values
				else {
					Stock userStock = new Stock();//else use defaults
				}
				
				System.out.println(Stock.getName());
				Stock.SimulatePrice();
				System.out.printf("%.2f", Stock.getNextPrice());
				
				System.out.printf("\nSTOCK\t\tSYMBOL\tYESTERDAY'S_PRICE\tTODAY'S_PRICE\tPRICE_MOVEMENT"
						+ "\tCHANGE_PERCENT");
				for(int days = 1; days < 31; days++){//for 30 days...
					Stock.SimulatePrice();
					System.out.printf("\n%s\t%s\t%.2f\t\t\t%.2f\t\t%.2f\t\t%.2f",
					Stock.getName(), Stock.getSymbol(), Stock.getCurrentPrice(), 
					Stock.getNextPrice(), Stock.getPriceChange(), Stock.getPriceChangePercentage());
				}//end for loop

				System.out.println("\n\nGood bye!");
				
				
		
			
				keyboard.close();//keyboard.close(); //closes keyboard Scanner object to prevent memory leaks
			}	//end main
			

}
