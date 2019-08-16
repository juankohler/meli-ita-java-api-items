import com.google.gson.Gson;
import static spark.Spark.*;
import com.google.gson.JsonElement;
import spark.Spark;


public class ItemRestFul {


    public static void main(String[] args) {
    final ItemServiceMapImpl service = new ItemServiceMapImpl();
        Spark.port(8090);

        // Devuelve token
        post("/users", (req,res) -> {
            res.type("application/json");
            User user = new Gson().fromJson(req.body(),User.class);
            System.out.println(user);
            String response = service.loginUser("http://localhost:8095/user");
            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(response)));
        });

        // Devuelve sitios
        get("/sites",(req,res) -> {
            res.type("application/json");
            String response = service.getSites("http://localhost:8095/users/sites");
            System.out.println(response);
            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(response)));
        });

        // Devuelve sitios
        get("/sites/:id/categories",(req,res) -> {
            res.type("application/json");
            String response = service.getCategories("http://localhost:8083/sites/:id/categories");
            System.out.println(response);
            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(response)));
        });

        /*

        // Devuelve categorias
        get("/sites/:id/categories",(req,res) -> {
            res.type("application/json");

            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(categories)));
        });

        //Post Item

        //Devuelve todos los items
        get("/items",(req,res) -> {
            res.type("application/json");

            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(categories)));
        });

        //devuelve items de un usuario
        get("/items/:id",(req,res) -> {
            res.type("application/json");

            return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(categories)));
        });
        */
    }
}


