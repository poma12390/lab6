package lab6.common;

import lab6.common.dto.CommandRequestDto;
import lab6.common.dto.CoordinatesDto;
import lab6.common.dto.PersonDto;
import lab6.common.dto.WorkerDto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Transformer {

    ObjectInput in;
    public static WorkerDto WorkerToWorkerDto(Worker bum){
        WorkerDto man = new WorkerDto();
        man.setName(bum.getName());
        man.setCoordinates(CoordinatesToCoordinatesDto(bum.getCoordinates()));
        man.setCreationDate(bum.getCreationDate());
        man.setSalary(bum.getSalary());
        man.setId(bum.getId());
        man.setStartDate(bum.getStartDate());
        man.setEndDate(bum.getEndDate());
        man.setPerson(PersonToPersonDto(bum.getPerson()));
        man.setPosition(bum.getPosition());
        return man;
    }

    public byte[] Serialize(Serializable obj){
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object DeSerialize(byte[] arr ){
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        try(ObjectInputStream in = new ObjectInputStream(bis)) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException  e) {
            throw new RuntimeException(e);
        }
    }
    public CommandRequestDto<? extends Serializable> Testdes(byte[] arr){
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        try(ObjectInput in = new ObjectInputStream(bis)) {
            return (CommandRequestDto<? extends Serializable>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }public static Worker WorkerDtoToWorker(WorkerDto man){
        Worker bum = new Worker();
        bum.setName(man.getName());
        bum.setCoordinates(CoordinatesDtoToCoordinates(man.getCoordinates()));
        bum.setCreationDate(man.getCreationDate());
        bum.setSalary(man.getSalary());
        bum.setId(man.getId());
        bum.setStartDate(man.getStartDate());
        bum.setEndDate(man.getEndDate());
        bum.setPerson(PersonDtoToPerson(man.getPerson()));
        bum.setPosition(man.getPosition());

        return bum;
    }
    public static PersonDto PersonToPersonDto(Person person){
        PersonDto pers = new PersonDto();
        pers.setBirthday(person.getBirthday());
        pers.setHeight(person.getHeight());
        pers.setWeight(person.getWeight());
        return pers;
    }
    public static Person PersonDtoToPerson(PersonDto pers){
        Person person = new Person();
        person.setBirthday(pers.getBirthday());
        person.setHeight(pers.getHeight());
        person.setWeight(pers.getWeight());
        return person;
    }
    public static Coordinates CoordinatesDtoToCoordinates(CoordinatesDto coordto){
        Coordinates coordinates = new Coordinates();
        coordinates.setXY(coordto.getX(), coordto.getY());
        return coordinates;
    }
    public static CoordinatesDto CoordinatesToCoordinatesDto(Coordinates coordinates){
        CoordinatesDto coords = new CoordinatesDto();
        coords.setX(coordinates.getX());
        coords.setY(coordinates.getY());
        return coords;
    }
    public static Worker WorkerToWorker(Worker bum, Worker bum1){
        bum.setCoordinates(bum1.getCoordinates());
        bum.setPerson(bum1.getPerson());
        bum.setEndDate(bum1.getEndDate());
        bum.setName(bum1.getName());
        bum.setStartDate(bum1.getStartDate());
        bum.setPosition(bum1.getPosition());
        bum.setStartDate(bum1.getStartDate());
        return bum;
    }

}
