package build.Model.data;

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


    public String toString() {
        return streetName + " " +
                streetNumber + " " +
                floorNumber + "," +
                apartmentNumber + ", " +
                postCode;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getCareOfName() {
        return careOfName;
    }

    public String getCareOfSurname() {
        return careOfSurname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setCareOfName(String careOfName) {
        this.careOfName = careOfName;
    }

    public void setCareOfSurname(String careOfSurname) {
        this.careOfSurname = careOfSurname;
    }
}