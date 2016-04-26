package com.github.mdssjc.cdc.tas.capitulo1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

  @Test
  public void principal() {
    final FirefoxDriver driver = new FirefoxDriver();
    driver.get("http://www.google.com.br/");

    final WebElement campoDeTexto = driver.findElement(By.name("q"));

    campoDeTexto.sendKeys("Caelum");

    campoDeTexto.submit();
  }
}
