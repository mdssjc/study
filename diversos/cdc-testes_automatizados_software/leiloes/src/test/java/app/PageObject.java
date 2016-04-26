package app;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {

  protected WebDriver driver;

  public PageObject(final WebDriver driver) {
    this.driver = driver;
  }

  public abstract String url();

  public void visita() {
    this.driver.get(url());
  }
}
