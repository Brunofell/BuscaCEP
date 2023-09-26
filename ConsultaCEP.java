import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsultaCEP {

    public Endereco buscaEndereco(String cep){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ cep +"/json/"))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception e) {
            throw new RuntimeException("NÃO OBTIVE ENDEREÇO A PARTIR DESTE CEP;");
        }


    }

}


