package DemoPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser brw = pw.chromium().launch(lp);
		Page pg = brw.newPage();
		pg.navigate("https://www.amazon.com");
		
		//pg.pause();
		
		String title = pg.title();
		System.out.println("Page title is:"+title);
		
		String url = pg.url();
		System.out.println("Page URL is:"+url);
		
		brw.close();
		pw.close();

	}

}

//Browser brw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//https://playwright.dev/java/docs/intro
//~/Library/Caches/ms-playwright on MacOS
//mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install --help"
//// Can be "msedge", "chrome-beta", "msedge-beta", "msedge-dev", etc.
//mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen wikipedia.org"


