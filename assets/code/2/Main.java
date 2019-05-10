import java.io.*;
/**
 * Main driver class
 * <br>
 * HINT: you can tell who’s code it is based on the curly brace style
 * <br> Theodore uses <br>
 * if (x)<br>
 * {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;y;<br>
 * }<br>
 * While larry uses<br>
 * if (x) {<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;y;<br>
 * }<br>
 * 
 * @author Theodore Preduta
 * @author Larry Yuan
 * 
 * @version 4
 */
class Main
{
	/**
	 * Tests the BlogSite class
	 *
	 * @param      args  The command line arguments (not used)
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Adding and rendering the blog...");
		BlogSite site = new BlogSite("1.1.1.1", BlogSite.ENGLISH, "Larry's New Website");
		// Adding styles
		site.setStyle("*{font-family: 'Arial'}");
		site.setStyle(site.getStyle() + "\n" + "h1{line-height: 1em}");
		System.out.println("Added default styles.");
		// Adding pages
		int homepage = site.addPage("Home Page", "<p>Welcome to Larry's new Website!</p><br><a href='2.html'>My First Post!</a><br><a href='1.html'>Click here to see something interesting.</a>");
		System.out.println("Added homepage with ID " + homepage + " and name " + site.getPageTitle(homepage));
		int funpage = site.addPage("Fun Page", "<img src='https://thumbs.gfycat.com/IdealisticHighDassie-size_restricted.gif'>");
		System.out.println("Added funpage with ID " + funpage + " and rendered content of " + site.getContent(funpage));
		int post1 = site.addPage("My First Post", "Hmmm this website is interesting!");
		System.out.println("Added first blog post.");
		// Adding comments
		site.addComment("Theodore Preduta", "This website is very good!", homepage);
		System.out.println("Added a comment by Theodore Albert Preduta");
		site.addComment("Noam", "Astounding! This groundbreaking new website defies all expectations!!!", post1);
		System.out.println("Added a comment by Noam");
		site.addComment("Larry", "Hahaha! This is so funny!", funpage);
		System.out.println("Added a comment by Larry");
		site.removePage(0); // removes the default page.
		String[] renderedPages = site.renderAllPages();
		for (int i = 0; i < renderedPages.length; i++) {
			System.out.println("Rendered page with ID " + i);
			PrintWriter writer = new PrintWriter(new FileWriter("pages/" + i + ".html"));
			writer.println(renderedPages[i]);
			writer.close();
		}
		System.out.println("Successfully rendered and saved " + renderedPages.length + " pages.");
		System.out.println("Please open 0.html in the pages directory.");
	}
}