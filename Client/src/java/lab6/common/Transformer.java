package lab6.common;

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


    public static WorkerDto WorkerToWorkerDto(Worker bum) {
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

    public byte[] Serialize(Serializable obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object DeSerialize(byte[] arr) {
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        try (ObjectInputStream in = new ObjectInputStream(bis)) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static PersonDto PersonToPersonDto(Person person) {
        PersonDto pers = new PersonDto();
        pers.setBirthday(person.getBirthday());
        pers.setHeight(person.getHeight());
        pers.setWeight(person.getWeight());
        return pers;
    }


    public static CoordinatesDto CoordinatesToCoordinatesDto(Coordinates coordinates) {
        CoordinatesDto coords = new CoordinatesDto();
        coords.setX(coordinates.getX());
        coords.setY(coordinates.getY());
        return coords;
    }


}
