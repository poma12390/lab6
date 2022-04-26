package lab6.common;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

public class Worker implements Comparable<Worker>, Serializable {
    public void setStats(String name, Coordinates coordinates, float salary, Date startDate, Date endDate, Position position, Person person) {
        this.name = name;
        this.coordinates = coordinates;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.person = person;
    }

    public Worker() {
        this.creationDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public float getSalary() {
        return salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Position getPosition() {
        return position;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Значение поля должно быть больше 0
    private java.util.Date startDate; //Поле не может быть null
    private java.util.Date endDate; //Поле может быть null
    private Position position; //Поле может быть null
    private Person person; //Поле может быть null

    @Override
    public int compareTo(Worker o) {
        int result = this.name.compareTo(o.name);

        if (result == 0) {
            result = Float.toString(this.salary).compareTo(Float.toString(o.salary));
        }
        if (result == 0) {
            result = Integer.toString(this.id).compareTo(Integer.toString(o.id));
        }
        return result;
    }
    static class SortByDate implements Comparator<Worker> {
        @Override
        public int compare(Worker a, Worker b) {
            return a.getEndDate().compareTo(b.getEndDate());
        }
    }

    @Override
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String strCreationDate = dateFormat.format(creationDate);

        String edate = "";
        String sdate ="";
        String crdate ="";
        String pattern = "dd.MM.yyyy";
        String birth = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateFormat df = new SimpleDateFormat(pattern);
        if (endDate!=null){
            edate =  df.format(endDate);

        }
        if (startDate != null){sdate = df.format(startDate);}
        birth = getPerson().getBirthday().format(formatter);
        String s = "";
        if (creationDate!=null){
            crdate =  df.format(creationDate);

        }

        if (name!=null) {s += name + ";";} else {s+=";";}
        if (coordinates.toString()!=null) {s +=coordinates.toString();} else {s+=";";}
        if (Float.toString(salary)!=null) {s += Float.toString(salary) + ";";} else {s+=";";}
        if (startDate!=null) {s += sdate + ";";} else {s+=";";}
        if (endDate!=null) {s += edate + ";";} else{s+=";";} ;
        if (getPerson().getBirthday()!=null) {s += birth + ";";} else{s+=";";} ;
        if (Float.toString(getPerson().getHeight())!=null) {s += Float.toString(getPerson().getHeight()) + ";";} else{s+=";";}
        if (Float.toString(getPerson().getWeight())!=null) {s += Float.toString(getPerson().getWeight()) + ";";} else{s+=";";}
        if (position!=null) {s +=position.toString() + ";";} else {s+=";";}
        if (id!=null){s += id.toString() + ";";} else {s+="lifehaack;";}
        if (creationDate!=null){s += crdate.toString() + "";} else {s+=new Date();}
        s+="\r\n";
        return s;
    }
}
