package fit.se.tuan06.model;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String city = "Ho Chi Minh";
    private String state = "South";
    private String country = "Vietnam";

    @Override
    public String toString() {
        return city + ", " + state + ", " + country;
    }
}