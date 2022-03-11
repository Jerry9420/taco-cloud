package sia.tacos;

import lombok.Data;

import java.util.List;

/**
 * taco
 *
 * @author mingming zhu
 * @date 2022-03-11 14:16
 */
@Data
public class Taco {
    public String name;

    private List<Ingredient> ingredients;

}
