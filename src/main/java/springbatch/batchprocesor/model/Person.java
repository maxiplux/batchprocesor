package springbatch.batchprocesor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String lastName;
    private String firstName;


    private byte[] fileData;

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

    public Byte[] getFileAsBinaryArray(){

        Byte[] bytes = new Byte[this.fileData.length];
        Arrays.setAll(bytes, n -> this.fileData[n]);
        return bytes;

    }



}
