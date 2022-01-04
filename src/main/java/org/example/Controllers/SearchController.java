package org.example.Controllers;

import org.example.Models.Search;
import org.example.Models.data.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("search")
public class SearchController {
      @Autowired
      private SearchRepository searchRepository;

    static HashMap<String, String> recipeChoices = new HashMap<>();

    public SearchController() {
        recipeChoices.put("chicken", "Chicken");
        recipeChoices.put("salmon", "Salmon");
        recipeChoices.put("pork", "Pork");
        recipeChoices.put("lamb", "Lamb");
        recipeChoices.put("beef", "beef");
    }

    @RequestMapping("")
    public String search(Model model) {
        String name = "UserName";
        model.addAttribute("name", name);
        return "search";
    }


    @PostMapping("results")
    public String getSearchResults(@ModelAttribute Search searchRecipe, @RequestParam String searchItem, Model model) {
          // Iterable<Search> chickenAgain = new ArrayList<>();
           String entryItem;
        if (searchItem.toLowerCase().equals("chicken")) {
            Search recipeDesire = searchRepository.save(searchRecipe);
               model.addAttribute("chickenAgain", recipeDesire);
        }
        else {
             entryItem = searchItem;
             model.addAttribute("entry", entryItem);
        }
           // model.addAttribute("recipes", recipeChoices);


            return "results";

    }
    }






/* try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }  */

/* URI myURI = new URI(url);
        JSONParser parser = new JSONParser(String.valueOf(get(url))); */

/*JSONParser parser = new JSONParser();
      JSONObject json2 = new JSONObject(get(url2)).getJSONObject("SharesStats");
        */