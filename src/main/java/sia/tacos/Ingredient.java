package sia.tacos;

import lombok.Data;

/**
 * ingredient
 *
 * @author mingming zhu
 * @date 2022-03-11 14:13
 */
@Data
public class Ingredient {
    public final String id;
    public final String name;
    public final Type type;

    public enum Type {
        WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
    }

}
