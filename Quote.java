import java.io.*;
import java.util.*;

/**
 * Represents a quotation/citation, and can load random quotes from a file.
 * 
 * Not tested for thread-safety, so probably not thread-safe!
 */
public class Quote {
	
	/**
	 * The name of the person who spoke or wrote the quoted words.
	 */
	public String author;
	
	/**
	 * The actual text that was spoken or written by the author.
	 */
	public String citation;
	
	
	///// Static members /////
	
	/**
	 * Returns a random quote from file "data/quotes.txt", or null if no quotes can be found.
	 *
	 * Actually loads quotes from a quotes cache, which is loaded from the quote file upon
	 * the first call to getRandomQuote() by _loadQuotes().
	 */
	public static Quote getRandomQuote() {
		_loadQuotes();
		if(_quotes.size() == 0)
			return null; // No quotes available (empty or malformed quotes file, or I/O error)
		if(_random == null)
			_random = new Random();
		
		return _quotes.elementAt(_random.nextInt(_quotes.size()));
	}
	
	/**
	 * Loads quotes from file "data/quotes.txt" and stores them in an array.
	 */
	protected static void _loadQuotes() {
	
		if(_quotes == null) {
			
			// Open file
			_quotes = new Vector<Quote>();
			BufferedReader quoteFile = null;
			try {
				quoteFile = new BufferedReader(new FileReader("data/quotes.txt"));
			} catch(FileNotFoundException fnfe) {
				System.err.println(fnfe.toString());
				try { quoteFile.close(); } catch(Exception e) { }
				return;
			}
			
			// Read quotes
			String line = null;
			int separatorLocation = 0;
			do {
				try {
					line = quoteFile.readLine();
				} catch (IOException ioe) {
					System.err.println(ioe.toString());
					try { quoteFile.close(); } catch(Exception e) { }
					return; // getRandomQuote() will have to make do with the quotes we've loaded thus far
				}
				if(line != null && (separatorLocation = line.indexOf(';')) != -1
				                &&  separatorLocation < line.length()) {
					Quote quote = new Quote();
					quote.author = line.substring(0, separatorLocation);
					quote.citation = line.substring(separatorLocation + 1);
					_quotes.add(quote);
				}
			} while(line != null); // Indicates end-of-file
			
			// Close
			try {
				quoteFile.close();
			} catch(Exception e) {
				System.err.println(e.toString());
			}
		}
	}
	
	/**
	 * The cached quote database, read by _loadQuotes.
	 * Used by getRandomQuote() as a source for quotes.
	 */
	protected static Vector<Quote> _quotes = null;
	
	/**
	 * The random number generator used to select quotes.
	 */
	protected static Random _random = null;
}
