package org.example.commands.MongoDB;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JokesConnector {

    public static String joke() throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.configure().filename("token").load();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(dotenv.get("JOKE_LINK")))
                .header(dotenv.get("JOKE_API_HEADING"), dotenv.get("JOKE_API"))
                .header(dotenv.get("JOKE_HOST"), dotenv.get("JOKE_HOST_KEY"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        JsonArray array = jsonObject.get("body").getAsJsonArray();
        System.out.println(array.get(0));
        String setup = array.get(0).getAsJsonObject().get("setup").getAsString();
        String punchline = array.get(0).getAsJsonObject().get("punchline").getAsString();
        System.out.println(setup);
        System.out.println(punchline);
        return setup + "\n" + punchline;
    }

}
