package es.upm.miw.documents;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Shopping {

    private String description;

    private BigDecimal retailPrice;

    private Integer amount;

    private BigDecimal discount;

    private ShoppingState shoppingState;

    @DBRef
    private Article article;

    public Shopping() {
    }

    public Shopping(Integer amount, BigDecimal discount, Article article) {
        this.amount = amount;
        this.setDiscount(discount);
        this.article = article;
        this.description = article.getDescription();
        this.retailPrice = article.getRetailPrice();
        this.shoppingState = ShoppingState.COMMITTED;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        if (discount == null) {
            discount = BigDecimal.ZERO;
        }
        this.discount = discount.setScale(2, RoundingMode.HALF_UP);
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public ShoppingState getShoppingState() {
        return shoppingState;
    }

    public void setShoppingState(ShoppingState shoppingState) {
        this.shoppingState = shoppingState;
    }

    public BigDecimal getShoppingTotal() {
        return retailPrice.multiply(new BigDecimal(amount))
                .multiply(new BigDecimal("1").subtract(this.discount.divide(new BigDecimal("100"))));
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "description='" + description + '\'' +
                ", retailPrice=" + retailPrice +
                ", amount=" + amount +
                ", discount=" + discount +
                ", shoppingState=" + shoppingState +
                ", articleCode=" + article.getCode() +
                '}';
    }
}
