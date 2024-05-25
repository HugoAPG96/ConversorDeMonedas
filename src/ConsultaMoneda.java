import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda(String consulMoneda1, String consulMoneda2, Double cantidad){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a9aea5d235955e26c0e054a9/pair/"+consulMoneda1+"/"+consulMoneda2+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(direccion)))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Moneda.class);
        } catch (Exception e){
            throw new RuntimeException("No encontre esa moneda.");
        }
    }
}
