package es.upm.miw.data_services;

import es.upm.miw.documents.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGraph {
    private List<Article> articleList;
    private List<Budget> budgetList;
    private List<FamilyArticle> familyArticleList;
    private List<FamilyComposite> familyCompositeList;
    private List<Invoice> invoiceList;
    private List<Order> orderList;
    private List<Provider> providerList;
    private List<Shopping> shoppingList;
    private List<Tag> tagList;
    private List<Ticket> ticketList;
    private List<User> userList;
    private List<Voucher> voucherList;

    public DatabaseGraph() {
        this.articleList = new ArrayList<>();
        this.budgetList = new ArrayList<>();
        this.familyArticleList = new ArrayList<>();
        this.familyCompositeList = new ArrayList<>();
        this.invoiceList = new ArrayList<>();
        this.orderList = new ArrayList<>();
        this.providerList = new ArrayList<>();
        this.shoppingList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        this.ticketList = new ArrayList<>();
        this.voucherList = new ArrayList<>();
        this.userList = new ArrayList<>();
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Budget> getBudgetList() {
        return budgetList;
    }

    public void setBudgetList(List<Budget> budgetList) {
        this.budgetList = budgetList;
    }

    public List<FamilyArticle> getFamilyArticleList() {
        return familyArticleList;
    }

    public void setFamilyArticleList(List<FamilyArticle> familyArticleList) {
        this.familyArticleList = familyArticleList;
    }

    public List<FamilyComposite> getFamilyCompositeList() {
        return familyCompositeList;
    }

    public void setFamilyCompositeList(List<FamilyComposite> familyCompositeList) {
        this.familyCompositeList = familyCompositeList;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

    public List<Shopping> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Shopping> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Voucher> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }
}
