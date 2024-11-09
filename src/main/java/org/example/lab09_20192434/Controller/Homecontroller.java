package org.example.lab09_20192434.Controller;

import org.example.lab09_20192434.Dao.CoctelDao;
import org.example.lab09_20192434.Entity.Coctel;
import org.example.lab09_20192434.Entity.CoctelResponse;
import org.example.lab09_20192434.Entity.FavoriteCoctel;
import org.example.lab09_20192434.Repository.FavoriteCoctelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/coctel")
public class Homecontroller {

    @Autowired
    private CoctelDao coctelDao;

    private final FavoriteCoctelRepository favoriteCoctelRepository;

    public Homecontroller(FavoriteCoctelRepository favoriteCoctelRepository) {
        this.favoriteCoctelRepository = favoriteCoctelRepository;
    }

    //Listamos los primeros 16 cocteles de la lista
    @GetMapping("/list")
    public String listarCocteles(Model model) {
        //Listamos
        model.addAttribute("cocteles", coctelDao.listarCocteles());
        return "index";
    }

    //Detalles del cóctel
    @GetMapping("/detail/{id}")
    public String detailCocteles(@PathVariable("id") String id, Model model) {
        Coctel coctel = coctelDao.buscarCoctel(id);
        model.addAttribute("coctel", coctel);
        return "detail";
    }

    //Guardar favorito
    @PostMapping("/favorite/{id}")
    public String agregarAFavoritos(@PathVariable("id") String id) {

        // URL del servicio externo para obtener detalles del cóctel
        String url = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + id;

        // Utiliza RestTemplate para obtener los datos del cóctel desde la API externa
        RestTemplate restTemplate = new RestTemplate();
        CoctelResponse response = restTemplate.getForObject(url, CoctelResponse.class);

        if (response != null && !response.getDrinks().isEmpty()) {
            // Obtén el primer cóctel de la respuesta
            Coctel coctel = response.getDrinks().get(0);

            // Crea y guarda la entidad FavoriteCoctel con los detalles obtenidos
            FavoriteCoctel favoriteCoctel = new FavoriteCoctel();
            favoriteCoctel.setIdDrink(coctel.getIdDrink());
            favoriteCoctel.setStrDrink(coctel.getStrDrink());
            favoriteCoctel.setStrDrinkThumb(coctel.getStrDrinkThumb());
            favoriteCoctel.setStrCategory(coctel.getStrCategory());
            favoriteCoctel.setStrAlcoholic(coctel.getStrAlcoholic());
            favoriteCoctel.setStrGlass(coctel.getStrGlass());
            favoriteCoctel.setStrInstructions(coctel.getStrInstructions());
            favoriteCoctel.setStrInstructionsES(coctel.getStrInstructionsES());
            favoriteCoctel.setStrIngredient1(coctel.getStrIngredient1());
            favoriteCoctel.setStrIngredient2(coctel.getStrIngredient2());
            favoriteCoctel.setStrIngredient3(coctel.getStrIngredient3());
            favoriteCoctel.setStrIngredient4(coctel.getStrIngredient4());
            favoriteCoctel.setStrIngredient5(coctel.getStrIngredient5());
            favoriteCoctel.setStrIngredient6(coctel.getStrIngredient6());
            favoriteCoctel.setStrIngredient7(coctel.getStrIngredient7());
            favoriteCoctel.setStrIngredient8(coctel.getStrIngredient8());
            favoriteCoctel.setStrIngredient9(coctel.getStrIngredient9());
            favoriteCoctel.setStrIngredient10(coctel.getStrIngredient10());
            favoriteCoctel.setStrMeasure1(coctel.getStrMeasure1());
            favoriteCoctel.setStrMeasure2(coctel.getStrMeasure2());
            favoriteCoctel.setStrMeasure3(coctel.getStrMeasure3());
            favoriteCoctel.setStrMeasure4(coctel.getStrMeasure4());
            favoriteCoctel.setStrMeasure5(coctel.getStrMeasure5());
            favoriteCoctel.setStrMeasure6(coctel.getStrMeasure6());
            favoriteCoctel.setStrMeasure7(coctel.getStrMeasure7());
            favoriteCoctel.setStrMeasure8(coctel.getStrMeasure8());
            favoriteCoctel.setStrMeasure9(coctel.getStrMeasure9());
            favoriteCoctel.setStrMeasure10(coctel.getStrMeasure10());
            favoriteCoctel.setStrImageSource(coctel.getStrImageSource());
            favoriteCoctel.setStrImageAttribution(coctel.getStrImageAttribution());
            favoriteCoctel.setDateModified(coctel.getDateModified());

            favoriteCoctelRepository.save(favoriteCoctel);
            return "redirect:/coctel/list";
        } else {
            return "redirect:/coctel/detail/{id}";
        }
    }
}
