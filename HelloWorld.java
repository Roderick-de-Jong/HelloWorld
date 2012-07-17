 
public class HelloWorld {
	public static void main(String[] arguments) {
		System.out.println("Hello World!!!");
		
		Quote quote = Quote.getRandomQuote();
		if(quote != null) {
			System.out.println("Quote of the Day:");
			System.out.println("   \"" + quote.citation + "\"  - " + quote.author);
		}
	}
}
