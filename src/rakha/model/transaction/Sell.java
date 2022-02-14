package rakha.model.transaction;

import java.math.BigDecimal;

/**
 *
 * @author Rakha
 */
public class Sell {

    private Long id;
    private Integer sellAmount;
    private Long idBuy;
    private String name;
    private BigDecimal cash;
    private BigDecimal sellPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(Integer sellAmount) {
        this.sellAmount = sellAmount;
    }

    public Long getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Long idBuy) {
        this.idBuy = idBuy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "Sell{" + "id=" + id + ", sellAmount=" + sellAmount + ", idBuy=" + idBuy + ", name=" + name + ", cash=" + cash + ", sellPrice=" + sellPrice + '}';
    }

}
