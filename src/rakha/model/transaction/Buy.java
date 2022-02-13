package rakha.model.transaction;

import java.math.BigDecimal;

public class Buy {

    private Long id;
    private String nameitem;
    private Integer countItem;
    private BigDecimal sellPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameitem() {
        return nameitem;
    }

    public void setNameitem(String nameitem) {
        this.nameitem = nameitem;
    }

    public Integer getCountItem() {
        return countItem;
    }

    public void setCountItem(Integer countItem) {
        this.countItem = countItem;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "Buy{" + "id=" + id + ", nameitem=" + nameitem + ", countItem=" + countItem + ", sellPrice=" + sellPrice + '}';
    }

}
