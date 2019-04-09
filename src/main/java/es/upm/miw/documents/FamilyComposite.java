package es.upm.miw.documents;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "articlesFamily")
public class FamilyComposite extends ArticlesFamily {

    private String reference;

    private String description;

    @DBRef(lazy = true)
    private List<ArticlesFamily> articlesfamilyList;

    public FamilyComposite() {
        super(FamilyType.ARTICLES);
        this.articlesfamilyList = new ArrayList<>();
    }

    public FamilyComposite(FamilyType familyType, String reference, String description) {
        super(familyType);
        this.reference = reference;
        this.description = description;
        this.articlesfamilyList = new ArrayList<>();
    }

    @Override
    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getStock() {
        return null;
    }

    @Override
    public void add(ArticlesFamily articlesFamilyList) {
        this.articlesfamilyList.add(articlesFamilyList);
    }

    @Override
    public void remove(ArticlesFamily articlesFamilyList) {
        this.articlesfamilyList.remove(articlesFamilyList);
    }

    public List<ArticlesFamily> getFamilyCompositeList() {
        return articlesfamilyList;
    }

    public void setFamilyCompositeList(List<ArticlesFamily> familyCompositeList) {
        this.articlesfamilyList = familyCompositeList;
    }

    @Override
    public List<ArticlesFamily> getArticlesFamilyList() {
        return this.articlesfamilyList;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && this.getId().equals(((FamilyComposite) obj).getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), reference, description, articlesfamilyList);
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        for (ArticlesFamily item : articlesfamilyList) {
            list.add("DBref:" + item.getId());
        }
        return "FamilyComposite [" + super.toString() + " reference=" + reference + ", description=" + description
                + ", articlesFamilyList=" + list + "]";
    }

    @Override
    public List<String> getArticleIdList() {
        List<String> articleIdList = new ArrayList<>();
        for (ArticlesFamily articlesFamily : this.articlesfamilyList) {
            articleIdList.addAll(articlesFamily.getArticleIdList());
        }
        return articleIdList;
    }

}
