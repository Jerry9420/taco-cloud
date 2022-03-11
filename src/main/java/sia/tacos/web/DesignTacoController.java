package sia.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import sia.tacos.Ingredient;
import sia.tacos.Ingredient.Type;
import sia.tacos.Taco;
import sia.tacos.TacoOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * design taco controller
 *
 * @author mingming zhu
 * @date 2022-03-11 14:42
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToOrder(Model model){

        List<Ingredient> ingredients= Arrays.asList(new Ingredient("FLTO","Flour Tortilla",Type.WRAP),
                                                    new Ingredient("COTO","Corn Tortilla",Type.WRAP),
                                                    new Ingredient("GRBF","Grounid beef",Type.PROTEIN),
                                                    new Ingredient("CARN","Carnitas",Type.PROTEIN),
                                                    new Ingredient("TMTO","Diced Tomatoes",Type.VEGGIES),
                                                    new Ingredient("LETC","Lettuce",Type.VEGGIES),
                                                    new Ingredient("CHED","Cheddar",Type.CHEESE),
                                                    new Ingredient("JACK","Monterrey Jack",Type.CHEESE),
                                                    new Ingredient("SLSA","Salsa", Type.SAUCE),
                                                    new Ingredient("SRCR","Sour Cream", Type.SAUCE));
        Type[] types=Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }


    }

    @ModelAttribute(name="taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute(name="tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients,Type type) {
        return ingredients.stream().filter(x->x.getType().equals(type)).collect(Collectors.toList());
    }
}
