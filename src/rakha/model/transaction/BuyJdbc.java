package rakha.model.transaction;


import java.util.List;

/**
 *
 * @author Khanza
 */
public interface BuyJdbc {

    public abstract List<Buy> selectBuys();
    
    public abstract Buy selectBuy(Long id);

}
