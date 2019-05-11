/**
 * Class for Blog website.
 * 
 * @author Theodore Preduta
 * @author Larry Yuan
 * 
 * @version 57
 */
import java.util.*;
public class BlogSite extends Website
{
	private String[] pageTitles;
	private String[] pageData;
	private String[][] comments;
	private int homepageID;
	private String style;

	/**
	 * Constructor for the blogsite object
	 *
	 * @param      IP          IP address
	 * @param      language    The language of the website
	 * @param      title       The title of the website
	 * @param      style       The css style to be applied to all pages
	 * @param      pageTitles  The page titles
	 * @param      contents    The page contents
	 */
	public BlogSite(String IP, int language, String title, String style, String[] pageTitles, String[] contents)
	{
		super(IP, language, "Java", title, null);
		pageData = contents;
		this.pageTitles = pageTitles;
		comments = new String[contents.length][0];
		homepageID = 0;
		this.style = style;
	}

	/**
	 * The constructor for the blogsite object
	 *
	 * @param      IP        The IP address
	 * @param      language  The language of the website
	 * @param      title     The title of the website
	 * @param      style     The css style to be applied to all pages
	 */
	public BlogSite(String IP, int language, String title, String style)
	{
		this(IP, language, title, style, new String[] {"New Webpage"}, new String[]{"<h1>It Worked</h1><br>You now have a website!"});
	}

	/**
	 * The constructor for the blogsite object
	 *
	 * @param      IP        The IP address
	 * @param      language  The language of the website
	 * @param      title     The title of the website
	 */
	public BlogSite(String IP, int language, String title)
	{
		this(IP, language, title, "");
	}

	/**
	 * Gets the content of the page.
	 *
	 * @param      pageID  The page id
	 *
	 * @return     The prepared contenet of the page, returns null if invalid page.
	 */
	public String getContent(int pageID)
	{
		try
		{
			String preparedPageContent = "<h1>" + pageTitles[pageID] + "</h1><hr>" + pageData[pageID] + "<h2>Comments</h2><hr>";
			for (int i = 0; i < comments[pageID].length; i++)
			{
				preparedPageContent += comments[pageID][i];
				preparedPageContent += "<hr>";
			}
			return "<!DOCTYPE html><html><head><title>" + getTitle() + "</title><style>" + style + "</style></head><body>" + preparedPageContent + "</body></html>";
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return null;
		}
	}

	/**
	 * Gets the content of the homepage
	 *
	 * @return     The content of the homepage.
	 */
	public String getContent()
	{
		return getContent(homepageID);
	}

	/**
	 * Sets the page data for the specified page.
	 *
	 * @param      contents  The new contents of the page
	 * @param      pageID    The page id that is wished to be modified
	 *
	 * @return     whether or not the page has been changed
	 */
	public boolean setPageData(String contents, int pageID)
	{
		try
		{
			if (contents == null)
				return false;
			pageData[pageID] = contents;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
		return true;
	}

	/**
	 * Sets the page data for the homepage.
	 *
	 * @param      contents  The new contents of the page
	 *
	 * @return     whether or not the page has been changed
	 */
	public boolean setPageData(String contents)
	{
		return setPageData(contents, homepageID);
	}

	/**
	 * Adds a comment to the specified page
	 *
	 * @param      name     The name of the user
	 * @param      message  The comment message
	 * @param      pageID   The page id
	 *
	 * @return     wether or not the comment was added
	 */
	public boolean addComment(String name, String message, int pageID)
	{
		try
		{
			String[] newComments = new String[comments[pageID].length + 1];
			for (int i = 0; i < comments[pageID].length; i++)
				newComments[i] = comments[pageID][i];
			newComments[newComments.length - 1] = "<b>" + name + "</b>: " + message;
			comments[pageID] = newComments;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
		return true;
	}

	/**
	 * Adds a comment to the specified page
	 *
	 * @param      name     The name of the user
	 * @param      message  The comment message
	 *
	 * @return     wether or not the comment was added
	 */
	public boolean addComment(String name, String message)
	{
		return addComment(name, message, homepageID);
	}

	/**
	 * Gets the current homepage id.
	 *
	 * @return     The current homepage id.
	 */
	public int getHomepageID()
	{
		return homepageID;
	}

	/**
	 * Sets the hompage id.
	 *
	 * @param      newID  The new id for the homepage
	 *
	 * @return     Wheter or not the cahnge was successful
	 */
	public boolean setHompageID(int newID)
	{
		try
		{
			pageData[newID] = pageData[newID];
			homepageID = newID;
			return true;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
	}

	/**
	 * Gets the page title.
	 *
	 * @param      pageID  The page id that you want the tile for
	 *
	 * @return     The page title or null if unsuccessful.
	 */
	public String getPageTitle(int pageID)
	{
		try
		{
			return pageTitles[pageID];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return null;
		}
	}

	/**
	 * Sets the page title.
	 *
	 * @param      pageID    The page id
	 * @param      newTitle  The new page title
	 *
	 * @return     Wether or not the cahange was successful
	 */
	public boolean setPageTitle(int pageID, String newTitle)
	{
		try
		{
			if (newTitle == null)
				return false;
			pageTitles[pageID] = newTitle;
			return true;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return false;
		}
	}

	/**
	 * Adds a page.
	 *
	 * @param      title    The title of the new page
	 * @param      content  The content of the new page
	 *
	 * @return     The id of the new page, or -1 if unsucessful
	 */
	public int addPage(String title, String content)
	{
		if (title == null || content == null)
			return -1;
		// update comments
		String[] newTitles = new String[pageTitles.length + 1];
		for (int i = 0; i < pageTitles.length; i++)
			newTitles[i] = pageTitles[i];
		newTitles[newTitles.length - 1] = title;
		pageTitles = newTitles;
		// update contents
		String[] newContents = new String[pageData.length + 1];
		for (int i = 0; i < pageData.length; i++)
			newContents[i] = pageData[i];
		newContents[newContents.length - 1] = content;
		pageData = newContents;
		// update comments
		String[][] newComments = new String[comments.length + 1][];
		for (int i = 0; i < comments.length; i++)
			newComments[i] = comments[i];
		newComments[newComments.length - 1] = new String[0];
		comments = newComments;

		return newTitles.length - 1;
	}

	/**
	 * Removes a page.
	 *
	 * @param      pageID  The page id to be removed
	 *
	 * @return     Wether or not the ooperation was successful
	 */
	public boolean removePage(int pageID)
	{
		if (pageID < 0 || pageID >= pageData.length || pageData.length == 1)
			return false;
		// update titles
		String[] newTitles = new String[pageTitles.length - 1];
		for (int i = 0; i < pageID; i++)
			newTitles[i] = pageTitles[i];
		for (int i = pageID + 1; i < pageTitles.length; i++)
			newTitles[i - 1] = pageTitles[i];
		pageTitles = newTitles;
		// update contents
		String[] newContents = new String[pageData.length - 1]; // AAAAAAA
		for (int i = 0; i < pageID; i++)
			newContents[i] = pageData[i];
		for (int i = pageID + 1; i < pageData.length; i++)
			newContents[i - 1] = pageData[i];
		pageData = newContents;
		// update comments
		String[][] newComments = new String[comments.length - 1][];
		for (int i = 0; i < pageID; i++)
			newComments[i] = comments[i];
		for (int i = pageID + 1; i < comments.length; i++)
			newComments[i - 1] = comments[i];
		comments = newComments;
		// check homepage number
		if (homepageID <= pageData.length)
			homepageID = 0;
		return true;
	}

	/**
	 * Gets the css style.
	 *
	 * @return     The style that's applied to all pages.
	 */
	public String getStyle()
	{
		return style;
	}

	/**
	 * Sets the css style.
	 *
	 * @param      newStyle  The new style to be applied to all pages
	 *
	 * @return     wether or not the action was completed successfully 
	 */
	public boolean setStyle(String newStyle)
	{
		if (newStyle == null)
			return false;
		style = newStyle;
		return true;
	}

	/**
	 * Gets the number of webpages. The pages are indexed 0-N where N is the value returned by this fucntion
	 *
	 * @return     The number of webpages.
	 */
	public int getNumberOfPages()
	{
		return pageTitles.length;
	}

	/**
	 * Returns all the pages in html in an array of length getNumberOfPages()
	 *
	 * @return     The rendered pages
	 */
	public String[] renderAllPages()
	{
		String[] pages = new String[getNumberOfPages()];
		for (int i = 0; i < getNumberOfPages(); i++)
			pages[i] = getContent(i);
		return pages;
	}
}