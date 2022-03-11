package sia.tacos;
import java.util.ArrayList;
import java.util.List;


/**
 * tacoorder
 *
 * @author mingming zhu
 * @date 2022-03-11 14:20
 */
public class TacoOrder {
    public String deliveryName;
    public String deliveryStreet;
    public String deliveryCity;
    public String deliveryState;
    public String deliveryZip;
    public String ccNumber;
    public String ccExpiration;
    public String ccCVV;

    public List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

}
