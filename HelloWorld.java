/**
 * Iemand is docs vergeten toe te voegen
 *
 * @version 1.0
 * @author EmVeDee
 */ 
public class HelloWorld {

   private String _sTitle = null;

   public void HelloWorld() {
       _sTitle = "Hello World";
   }

   public void setTitle(String title) {
       _sTitle = title;
   }

   public String getTitle() {
      return _sTitle;
   }

	public static void main(String[] arguments) {
		System.out.println(_sTitle + "!!!");
		
		Quote quote = Quote.getRandomQuote();
		if(quote != null) {
			System.out.println("Quote of the Day:");
			System.out.println("   \"" + quote.citation + "\"  - " + quote.author);
		}
	}
}
