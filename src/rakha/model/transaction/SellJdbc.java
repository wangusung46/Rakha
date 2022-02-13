package rakha.model.transaction;

import java.util.List;

public interface SellJdbc {

    public abstract List<Sell> selectSells();

    public abstract void insertSell(Sell sell);
    
    public abstract void updateSell(Sell sell);
    
    public abstract void deleteSell(Long id);

}
