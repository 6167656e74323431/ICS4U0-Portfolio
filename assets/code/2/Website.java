/**
 * Class to simulate a website.
 * 
 * @author Theodore Preduta
 * @author Larry Yuan
 * 
 * @version 8
 */
public class Website
{
	public static final int ENGLISH = 0;
	public static final int FRENCH = 1;
	public static final int SPANISH = 2;
	public static final int CHINESE = 3;

	private String IPAddress;
	private String programmingLanguage;
	private String title;
	private String pageData;
	private int language;

	/**
	 * The constructor for the website object
	 *
	 * @param      IP    The IP address of the website
	 */
	public Website(String IP)
	{
		IPAddress = IP;
		language = ENGLISH;
		programmingLanguage = "html";
		title = "New Website";
		pageData = "<h1>It Worked</h1><br>You now have a website!";
	}

	/**
	 * Constructor for the website object
	 *
	 * @param      IP                   The IP address of the website
	 * @param      language             The language of the website
	 * @param      programmingLanguage  The programming language the website is written in
	 */
	public Website(String IP, int language, String programmingLanguage)
	{
		this(IP);
		this.language = language;
		this.programmingLanguage = programmingLanguage;
	}

	/**
	 * Constructor for the website object
	 *
	 * @param      IP                   The IP address of the website
	 * @param      language             The language of the website
	 * @param      programmingLanguage  The programming language the website is written in
	 * @param      title                The title of the webpage
	 * @param      content              The inital webpage content
	 */
	public Website(String IP, int language, String programmingLanguage, String title, String content)
	{
		this(IP, language, programmingLanguage);
		this.title = title;
		pageData = content;
	}

	/**
	 * Constructor for the website object
	 *
	 * @param      IP                   The IP address of the websbite
	 * @param      language             The language of the website
	 * @param      title                The title of the webpage
	 * @param      content              The inital webpage content
	 */
	public Website(String IP, int language, String title, String content)
	{
		this(IP, language, "html", title, content);
	}

	/**
	 * Gets the title of the webpage.
	 *
	 * @return     The title of the webpage.
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Sets the title of the webpage. Only succeeds when the string is not null and is not empty.
	 *
	 * @param      t     New title of the webpage.
	 *
	 * @return     Whether the operation has succeeded.
	 */
	public boolean setTitle(String t) {
		if (t == null || t.length() == 0) {
			return false;
		}
		title = t;
		return true;
	}

	/**
	 * Gets the content of the webpage.
	 *
	 * @return     The content of the webpage.
	 */
	public String getContent()
	{
		return pageData;
	}

	/**
	 * Sets the data of the webpage. Only succeeds when the data is not null.
	 *
	 * @param      c     The data of the webpage.
	 *
	 * @return     Whether the operation has succeeded.
	 */
	public boolean setPageData(String c) {
		if (c == null) {
			return false;
		}
		pageData = c;
		return true;
	}

	/**
	 * Sets the language of the webpage. The languages are constants specified in Website.ENGLISH,
	 *  Website.FRENCH, Website.SPANISH and Website.CHINESE.
	 *
	 * @param      l     The language
	 *
	 * @return     Whether the operation has succeeded or not (passing an invalid language fails)
	 */
	public boolean setLanguage(int l) {
		if (l < 0 || l > 3) { // check for invalid language
			return false;
		}
		language = l;
		return true;
	}

	/**
	 * Gets the language of the webpage as a name.
	 *
	 * @return     The language name.
	 */
	public String getLanguage() {
		if (language == 0) {
			return "ENGLISH";
		} else if (language == 1) {
			return "FRENCH";
		} else if (language == 2) {
			return "SPANISH";
		} else if (language == 3) {
			return "CHINESE";
		}
		return null;
	}

	/**
	 * Gets the IP address of the website.
	 *
	 * @return     The IP address.
	 */
	public String getIPAddress() {
		return IPAddress;
	}

	/**
	 * Gets the programming language.
	 *
	 * @return     The programming language.
	 */
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
}