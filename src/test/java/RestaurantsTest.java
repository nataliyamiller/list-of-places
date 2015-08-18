import org.junit.*;
import static org.junit.Assert.*;

public class RestaurantsTest {

  @Test
  public void Restaurants_instantiatesCorrectly_true() {
    Restaurants myRestaurants = new Restaurants("Panera");
    assertEquals(true, myRestaurants instanceof Restaurants);
  }

  @Test
  public void Restaurants_instantiatesWithDescription_true() {
    Restaurants myRestaurants = new Restaurants("Panera");
    assertEquals("Panera", myRestaurants.getDescription());
  }

}
