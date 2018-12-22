package mainUtilities.basicPages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import mainUtilities.pageNavigation.Domain;
import mainUtilities.pageNavigation.PageToOpenURL;
import mainUtilities.urlChecker.URLPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class BasePage<T> {

    static {
        Configuration.browser = "chrome";
    }

    protected String getUrlToOpen() {
        String adress = null;
        if(this.getClass().isAnnotationPresent(Domain.class)) {
            adress = this.getClass().getAnnotation(Domain.class).value();
        } else {
            adress = System.getProperty("webdriver.base.url");
        }
        if(this.getClass().isAnnotationPresent(PageToOpenURL.class)){
            adress = adress + this.getClass().getAnnotation(PageToOpenURL.class).value();
        }
        return adress;
    }

    protected String getParamURLToOpen(String urlTemplate, String... parameters) {
        String adress = null;
        try {
            if (this.getClass().isAnnotationPresent(Domain.class)) {
                adress = this.getClass().getAnnotation(Domain.class).value();
            } else {
                adress = System.getProperty("webdriver.base.url");
            }
            for (int i = 0; i < parameters.length; i++) {
                urlTemplate = urlTemplate.replace("%".concat(Integer.toString(i + 1)),
                        parameters[i]);
            }
            adress = adress + urlTemplate;
        } catch (Exception error){
            System.out.println("Domain or template is not given.");
        }
        return adress;
    }

    protected T open() {
        Selenide.open(getUrlToOpen());
        return (T) this;
    }

    protected T openParamUrl(String urlTemplate, String... parameters) {
        Selenide.open(getParamURLToOpen(urlTemplate, parameters));
        return (T) this;
    }

    protected T isURLValid(){
        boolean result = false;
        try{
            if( this.getClass().isAnnotationPresent(URLPattern.class) ) {
                Pattern urlPattern = Pattern.compile(this.getClass().getAnnotation(URLPattern.class).value());
                Matcher urlMatcher = urlPattern.matcher(WebDriverRunner.url());
                result = urlMatcher.matches();
            } else {
                throw new Exception();
            }
        } catch (Exception error){
            System.out.println("URL pattern is not given.");
        }
        assertTrue("Ссылка требуемого формата не открылась.", result);
        return (T) this;
    }

    /*public KidsMainPage checkURLFormat(){
        Pattern pattern = Pattern.compile("https:\\/\\/deti\\.mail\\.ru\\/[^ \\/]+\\/[^ \\/]+\\/");
        Matcher matcher = pattern.matcher(WebDriverRunner.url());
        System.out.println(WebDriverRunner.url());
        assertTrue("Ссылка требуемого формата не открылась.", matcher.matches());
        return this;
    }*/



}
