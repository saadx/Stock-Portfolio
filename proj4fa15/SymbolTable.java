package proj4fa15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>Title: Symboltable.java</p> 
 * <p>Description: Creates an ArrayUnorderedList that can store address of SymbolPair objects.
 * 					Also contains a findCompany method that return the company name of the
 * 					ticker name being searched for, if found. </p>
 *
 * @author Saad Ahmad
 */

public class SymbolTable
{
	// instance variable
	private ArrayUnorderedList<SymbolPair> symbolPairs;

	/**
	 * Parameterized constructor -- Reads data from the file, creates a
	 * SysmbolPair object with that data and store in the ArrayUnorderedList
	 * symbolPairs.
	 * 
	 * @param fileName
	 *            - store the name of the file containing the symbol data
	 * @throws FileNotFoundException
	 *             if data file couldn't be located
	 */
	public SymbolTable(File fileName) throws FileNotFoundException
	{
		symbolPairs = new ArrayUnorderedList<SymbolPair>();
		Scanner fileScan = new Scanner(fileName);

		SymbolPair pair1;
		String[] tokenArray;
		while (fileScan.hasNextLine())
		{
			tokenArray = fileScan.nextLine().split(" ", 2);
			pair1 = new SymbolPair(tokenArray[0], tokenArray[1]);
			symbolPairs.addToRear(pair1);
		}
		fileScan.close();
	}

	/**
	 * findCompany method -- Compares the ticker symbols in the array to the
	 * ticker symbol received in argument, returns the company if a match is
	 * found
	 * 
	 * @param ticker
	 *            - stores the ticker symbol to be searched for
	 * @throws InvalidSaleException if company is not found
	 */
	public String findCompany(String ticker)
	{
		for (int i = 0; i < symbolPairs.size(); i++)
		{
			SymbolPair pair = symbolPairs.get(i);
			if (pair.getTickerSymbol().equalsIgnoreCase(ticker))
			{
				return pair.getCompanyName();
			}
		}
		throw new InvalidSaleException("Company not found");
	}
}
