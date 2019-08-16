import com.google.gson.Gson;
import javax.swing.text.BadLocationException;

import static spark.Spark.*;

public class SparkRestful {

    public static void main(String[] args) {

        // creo una instancia de tipo SiteServiceMapImpl
        final ISiteService service = new SiteServiceMapImpl();
        // Elijo el puerto donde quiero crear el servicio
        port(8080);

        // Del static spark, llamo los dos metodos get que necesito
        get("/sites", (req,res)->{
            // Seteo el response como un application/json
            res.type("application/json");
            try {
                // Retorno del metodo de getSites del metodo
                return service.getSites();

            } catch (BadLocationException e){
                res.status(500);
                return null;
            }
        });

        get("/sites/:id/categories", (req,res)->{
            res.type("application/json");
            try {
                return service.getCategories(req.params(":id"));
            } catch (BadLocationException e){
                res.status(500);
                return null;
            }
        });

        // Si escribe cualquier cosa que retorne un 404
        get("/*",(req, res) ->{
            res.status(404);
            return null;

        });
    }
}
