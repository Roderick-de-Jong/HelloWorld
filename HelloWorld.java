/**
 * Iemand is docs vergeten toe te voegen
 *
 * @version 1.0
 * @author EmVeDee
 */ 
public class HelloWorld {

   private String _sTitle;

   public HelloWorld() {
       _sTitle = new String("Hello World");
   }

   public void setTitle(String title) {
       _sTitle = title;
   }

   public String getTitle() {
      return _sTitle;
   }
	public void sayHello() {
		System.out.println(_sTitle + "!!!");
	}
	
	public void sayQuote() {
		Quote quote = Quote.getRandomQuote();
		if(quote != null) {
			System.out.println("Quote of the Day:");
			System.out.println("   \"" + quote.citation + "\"  - " + quote.author);
		}
	}
	
	public static void main(String[] arguments) {
		
		HelloWorld helloWorld = new HelloWorld();
		
		helloWorld.sayHello();
		helloWorld.sayQuote();
	}
}
