package utilities;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

/**
 * The solution is taken from
 * <a href="https://github.com/selenide/selenide/issues/1692#issuecomment-1010965030">Comment by BorisOsipov</a>
 */
public class ScrollWebdriverListener implements WebDriverListener {
    public void beforeClick(WebElement element) {
        Point location = element.getLocation();
        Selenide.executeJavaScript("window.scrollTo(" + location.getX() + ", " + location.getY() + ')');
    }
}