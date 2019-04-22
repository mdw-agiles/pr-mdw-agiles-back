package es.upm.miw.dtos;


import javax.validation.constraints.NotNull;

public class HotelChainDto {

    @NotNull
    private String name;

    public HotelChainDto() {
        // Empty for framework
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "HotelChainDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
