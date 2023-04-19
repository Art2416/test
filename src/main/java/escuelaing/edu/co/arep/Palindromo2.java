package escuelaing.edu.co.arep;

import static spark.Spark.get;
import static spark.Spark.port;

public class Palindromo2 {
    public static void main(String[] args) {
        port(getPort());
        get("/espalindromo",(req, res) -> {
            String response = answer(req.queryParams("value"));
            res.type("application/json");
            return "{\"output\":"+ "\"" + response +"\"}";
        });
    }

    private static String answer(String input) {
        String changeWord = new StringBuilder(input).reverse().toString();
        if (changeWord.equals(input)) {
            return "Si es Palindromo";
        } else {
            return "No es Palindromo";
        }
    }

    public static Integer getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5002;
    }
}
