import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.ArrayList;

import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Restaurants List");
  }

  @Test
  public void restaurantIsCreated() {
    goTo("http://localhost:4567/");
    fill("#description").with("Panera");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

  @Test
  public void restaurantIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#description").with("Panera");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("Panera");
  }
  }
