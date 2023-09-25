import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaCEP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String busca = sc.nextLine();
        List<Cep> ceps = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() // deixava em formato de json
                .create();

        while (!busca.equalsIgnoreCase("sair")){
            System.out.print("• Digite o CEP: ");
            String local = sc.nextLine();

            if(local.equalsIgnoreCase("sair")){
                break;
            }

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://viacep.com.br/ws/"+ local +"/json/"))
                        .build();
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                FileWriter escrita  = new FileWriter("Endereco.json");
                escrita.write(gson.toJson(json));
                escrita.close(); // se não não faz o flush
                System.out.println("O programa finalizou corretamente");


            }catch (Exception e){
                System.out.println("Erro");

            }
        }

    }
}

