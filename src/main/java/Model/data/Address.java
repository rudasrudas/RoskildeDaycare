package Model.data;

import Model.Model;

public class Address {
    private String city;
    private int postCode;
    private String streetName;
    private String streetNumber;
    private int floorNumber;
    private String apartmentNumber;
    private String careOfName;
    private String careOfSurname;

    public Address(String city,
                   int postCode,
                   String streetName,
                   String streetNumber,
                   int floorNumber,
                   String apartmentNumber,
                   String careOfName,
                   String careOfSurname) {
        this.city = city;
        this.postCode = postCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.floorNumber = floorNumber;
        this.apartmentNumber = apartmentNumber;
        this.careOfName = careOfName;
        this.careOfSurname = careOfSurname;
    }

    public String toString(){
        return streetName + " " +
                streetNumber + " " +
                floorNumber + "," +
                apartmentNumber + ", " +
                postCode;
    }
}
