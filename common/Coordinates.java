package lab6.common;


import java.io.Serializable;

public class Coordinates implements Serializable {
    public void setXY(long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString(){
        String s = "";
        s+=Long.toString(x)+";";
        s+=Integer.toString(y)+";";

        return s;
    }

    private long x;
    private Integer y; //Поле не может быть null
}
