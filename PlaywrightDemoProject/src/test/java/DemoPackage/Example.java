package DemoPackage;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      BrowserContext context = browser.newContext();

      // Open new page
      Page page = context.newPage();

      // Go to https://www.amazon.in/
      page.navigate("https://www.amazon.in/");

      // Click [aria-label="Search"]
      page.click("[aria-label=\"Search\"]");
     // page.locator("[aria-label=\"Search\"]").click();

      // Fill [aria-label="Search"]
      page.locator("[aria-label=\"Search\"]").fill("toys");

      // Press Enter
      page.locator("[aria-label=\"Search\"]").press("Enter");
      assertThat(page).hasURL("https://www.amazon.in/s?k=toys&crid=17ISTBW0MSU4H&sprefix=toys%2Caps%2C220&ref=nb_sb_noss_1");

      // Click img[alt="Sponsored Ad - Mirana Usb Rechargeable Battery Powered Hover Football Indoor Floating Hoverball Soccer \| Air Football Pro\.\.\."]
      Page page1 = page.waitForPopup(() -> {
        page.locator("img[alt=\"Sponsored Ad - Mirana Usb Rechargeable Battery Powered Hover Football Indoor Floating Hoverball Soccer \\| Air Football Pro\\.\\.\\.\"]").click();
      });
      assertThat(page).hasURL("https://www.amazon.in/Rechargeable-Football-Floating-Hoverball-Original/dp/B099DTMGZV/ref=sr_1_1_sspa?crid=17ISTBW0MSU4H&keywords=toys&qid=1663852475&smid=A2MWQIWQF44JBM&sprefix=toys%2Caps%2C220&sr=8-1-spons&psc=1");

      // Go to https://www.amazon.in/Rechargeable-Football-Floating-Hoverball-Original/dp/B099DTMGZV/ref=sr_1_1_sspa?crid=17ISTBW0MSU4H&keywords=toys&qid=1663852475&smid=A2MWQIWQF44JBM&sprefix=toys%2Caps%2C220&sr=8-1-spons&th=1
      page1.navigate("https://www.amazon.in/Rechargeable-Football-Floating-Hoverball-Original/dp/B099DTMGZV/ref=sr_1_1_sspa?crid=17ISTBW0MSU4H&keywords=toys&qid=1663852475&smid=A2MWQIWQF44JBM&sprefix=toys%2Caps%2C220&sr=8-1-spons&th=1");

      // Click #zeitgeistBadge_feature_div >> text=in Kids' Football Toys
      page1.locator("#zeitgeistBadge_feature_div >> text=in Kids' Football Toys").click();
      assertThat(page1).hasURL("https://www.amazon.in/gp/bestsellers/toys/1378557031/ref=zg_b_bs_1378557031_1");

      // Click text=Toyshine Edu-Sports Kids Football Soccer Educational Toy Ball Size 3, 4-8 Year K
      page1.locator("text=Toyshine Edu-Sports Kids Football Soccer Educational Toy Ball Size 3, 4-8 Year K").click();
      assertThat(page1).hasURL("https://www.amazon.in/Toyshine-Edu-Sports-Football-Soccer-Educational/dp/B09DKWT88P/ref=zg_bs_1378557031_sccl_3/262-0882925-2015209?pd_rd_i=B09DKWT88P&psc=1");

      // Go to https://www.amazon.in/Toyshine-Edu-Sports-Football-Soccer-Educational/dp/B09DKWT88P/ref=zg_bs_1378557031_sccl_3/262-0882925-2015209?pd_rd_i=B09DKWT88P&th=1
      page1.navigate("https://www.amazon.in/Toyshine-Edu-Sports-Football-Soccer-Educational/dp/B09DKWT88P/ref=zg_bs_1378557031_sccl_3/262-0882925-2015209?pd_rd_i=B09DKWT88P&th=1");

      // Click span[role="radio"]:has-text("Add to Wish List")
      page1.locator("span[role=\"radio\"]:has-text(\"Add to Wish List\")").click();
      assertThat(page1).hasURL("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Faw%2Fd%2FB09DKWT88P&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inamazon&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
    }
  }
}
