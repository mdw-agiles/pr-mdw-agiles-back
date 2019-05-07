package es.upm.miw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class HotelChain {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    public HotelChain(){
        // Empty for framework
    }

    public HotelChain(String name) {
        this();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelChain)) return false;
        HotelChain that = (HotelChain) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "HotelChain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
