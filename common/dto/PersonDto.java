package lab6.common.dto;

import java.time.ZonedDateTime;

public class PersonDto extends AbstractDto{
    private java.time.ZonedDateTime birthday;

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    private float height;
    private Float weight;
}
