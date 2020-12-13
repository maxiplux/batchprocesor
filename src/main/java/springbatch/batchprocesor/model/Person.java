package springbatch.batchprocesor.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "people")
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;



    private String lastName;
    private String firstName;

    @Id
    private Long id;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }


}
