/**
 * Iemand is docs vergeten toe te voegen
 *
 * @version 1.0
 * @author EmVeDee
 */ 
public class HelloWorld {

   private String sTitle = null;

   public void HelloWorld() {
       sTitle = "Hello World";
   }

   public void setTitle(String _title) {
       sTitle = _title;
   }

   public String getTitle() {
      return sTitle;
   }

	public static void main(String[] arguments) {
		System.out.println("Hello World!");
		
		Quote quote = Quote.getRandomQuote();
		if(quote != null) {
			System.out.println("Quote of the Day:");
			System.out.println("   \"" + quote.citation + "\"  - " + quote.author);
		}
	}
}
