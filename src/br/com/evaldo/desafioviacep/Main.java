package br.com.evaldo.desafioviacep;

import br.com.evaldo.desafioviacep.entradas.Endereco;
import br.com.evaldo.desafioviacep.entradas.JsonCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        int cep;

        System.out.println("**************************************** \n");
        System.out.println("Bem-vindo ao busca cep!");
        System.out.println("**************************************** \n");
        System.out.println("Entre com numero do cep desejado (Apenas os numero)");
        cep=entrada.nextInt();
        System.out.println(cep);

        String endereco = "https://viacep.com.br/ws/"+cep +"/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();
        //System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        JsonCep meuCep = gson.fromJson(json, JsonCep.class);
        System.out.println("Logradouro: " + meuCep.logradouro());
        System.out.println(meuCep);
        //Endereco meuEndereco =  new Endereco(meuCep);
        //System.out.println(meuEndereco);













    }
}

