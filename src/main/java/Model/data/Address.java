package Model.data;

import Model.Model;

public class Address {
    private int id;
    private String city;
    private int postCode;
    private String streetName;
    private int streetNumber;
    private int floorNumber;
    private int apartmentNumber;
    private String careOfName;
    private String careOfSurname;

    public Address(int id,
                   String city,
                   int postCode,
                   String streetName,
                   int streetNumber,
                   int floorNumber,
                   int apartmentNumber,
                   String careOfName,
                   String careOfSurname) {
        this.id = id;
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

    public int getId(){
        return id;
    }
}
