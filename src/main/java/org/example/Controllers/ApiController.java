package org.example.Controllers;


import com.google.gson.Gson;
import org.example.Models.API;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Controller
@RequestMapping("api")
public class ApiController {


    @RequestMapping("")
    public String search(Model model) {
        String name = "UserName";
        model.addAttribute("name", name);
        return "api";
    }


    public String getRecipeInfo(URI uri) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        String actualResponse = response.body();


        return actualResponse;
    }

    @PostMapping("")
    public Object getApiResults(Model model, @RequestParam String searchString) throws Exception {
        // URI url2 = new URI("https://eodhistoricaldata.com/api/fundamentals/AAPL.US?api_token=OeAFFmMliFG5orCUuwAKQ8l4WWFQ67YX");
        URI url = new URI("https://api.edamam.com/api/recipes/v2?type=public&q="+searchString+"&app_id=98848355&app_key=a2eab94993145d573991625b087c0ac9");
        Gson gson = new Gson();
       API api = gson.fromJson(getRecipeInfo(url), API.class);

        model.addAttribute("results", api.getHits());

        return "api";
    }

    }


