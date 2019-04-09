package es.upm.miw.documents;

import es.upm.miw.business_services.Encrypting;
import es.upm.miw.exceptions.BadRequestException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Document
public class Ticket {

    private static final String DATE_FORMAT = "yyyyMMdd";

    @Id
    private String id;

    private LocalDateTime creationDate;

    private String reference;

    private Shopping[] shoppingList;

    private BigDecimal cash;

    private BigDecimal card;

    private BigDecimal voucher;

    private String note;

    @DBRef
    private User user;

    public Ticket() {
        this.creationDate = LocalDateTime.now();
        this.reference = new Encrypting().encryptInBase64UrlSafe();
        this.note = "";
        this.card = BigDecimal.ZERO;
        this.cash = BigDecimal.ZERO;
        this.voucher = BigDecimal.ZERO;
    }

    public Ticket(int idOfDay, BigDecimal card, BigDecimal cash, BigDecimal voucher, Shopping[] shoppingList, User user) {
        this();
        this.id = new SimpleDateFormat(DATE_FORMAT).format(new Date()) + idOfDay;
        this.shoppingList = shoppingList;
        this.user = user;
        this.addPay(card, cash, voucher);
    }

    public void addPay(BigDecimal card, BigDecimal cash, BigDecimal voucher) {
        this.card = this.card.add(card);
        this.cash = this.cash.add(cash);
        this.voucher = this.voucher.add(voucher);
        if (this.pay().compareTo(this.getTotalCommited()) < 0) {
            throw new BadRequestException("Dinero inferior al material entregado");
        }
    }

    public BigDecimal pay() {
        return this.cash.add(this.card).add(this.voucher);
    }

    public BigDecimal debt() {
        return this.getTotal().subtract(this.pay());
    }

    public boolean isDebt() {
        return this.pay().compareTo(this.getTotal()) < 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int simpleId() {
        return Integer.parseInt(String.valueOf(id).substring(DATE_FORMAT.length()));
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Shopping[] getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(Shopping[] shoppingList) {
        this.shoppingList = shoppingList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getCard() {
        return card;
    }

    public void setCard(BigDecimal card) {
        this.card = card;
    }

    public BigDecimal getVoucher() {
        return voucher;
    }

    public void setVoucher(BigDecimal voucher) {
        this.voucher = voucher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Shopping shopping : shoppingList) {
            total = total.add(shopping.getShoppingTotal());
        }
        return total;
    }

    public BigDecimal getTotalCommited() {
        BigDecimal total = new BigDecimal(0);
        for (Shopping shopping : shoppingList) {
            if (ShoppingState.COMMITTED.equals(shopping.getShoppingState())) {
                total = total.add(shopping.getShoppingTotal());
            }
        }
        return total;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && id.equals(((Ticket) obj).id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", reference='" + reference + '\'' +
                ", shoppingList=" + Arrays.toString(shoppingList) +
                ", cash=" + cash +
                ", card=" + card +
                ", voucher=" + voucher +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }
}
