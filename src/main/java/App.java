import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("restaurants", request.session().attribute("restaurants"));

    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/restaurants", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    ArrayList<Restaurants> restaurants = request.session().attribute("restaurants");

    if(restaurants == null) {
      restaurants = new ArrayList<Restaurants>();
      request.session().attribute("restaurants", restaurants);
    }

    String description = request.queryParams("description");
    Restaurants newRestaurants = new Restaurants(description);

    restaurants.add(newRestaurants);

    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

 }
}
