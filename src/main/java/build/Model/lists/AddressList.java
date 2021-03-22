package build.Model.lists;

import build.Model.data.Address;
import build.Model.data.BankInfo;
import build.Model.data.Child;
import build.Model.data.Parent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressList {
    private ArrayList<Address> addressList;

    public AddressList(Statement statement){
        addressList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.address";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                addressList.add(new Address(rs.getInt("PK_Address"),
                        rs.getString("City"),
                        rs.getInt("PostCode"),
                        rs.getString("StreetName"),
                        rs.getInt("StreetNumber"),
                        rs.getInt("FloorNumber"),
                        rs.getInt("ApartmentNumber"),
                        rs.getString("CareOfName"),
                        rs.getString("CareOfSurname")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.address";
            statement.executeUpdate(sql1);

            for(Address a : addressList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.address (City, Postcode, StreetName, StreetNumber, FloorNumber, ApartmentNumber, CareOfName, CareOfSurname)" +
                                "VALUES ('%s', '%s', '%s', '%d', '%d', '%d')",
                        a.getCity(),
                        a.getPostCode(),
                        a.getStreetName(),
                        a.getStreetNumber(),
                        a.getFloorNumber(),
                        a.getApartmentNumber(),
                        a.getCareOfName(),
                        a.getCareOfSurname());

                statement.executeUpdate(sql2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void add(Address address){ addressList.add(address); }
    public void remove(Address address){ addressList.remove(address); }

    public static int locateID(Statement statement, Address address){
        if(address == null) return -1;

        String sql = String.format("SELECT * FROM roskildedaycare1.address WHERE City = '%s' AND Postcode = '%d' AND StreetName = '%s' AND StreetNumber = '%d' AND FloorNumber = '%d' AND ApartmentNumber = '%d' AND CareOfName = '%s' AND CareOfSurname = '%s'",
                address.getCity(),
                address.getPostCode(),
                address.getStreetName(),
                address.getStreetNumber(),
                address.getFloorNumber(),
                address.getApartmentNumber(),
                address.getCareOfName(),
                address.getCareOfSurname());
        try{
            ResultSet rs = statement.executeQuery(sql);
            if(rs == null){
                return -1; //if no address is found, dont bother
            }

            return rs.getInt("PK_Address");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }

    public Address getAddress(int id){
        for(Address g : addressList){
            if(g.getId() == id) return g;
        }

        return null;
    }

    public String toString(){
        String result = "";

        for (int i = 0; i < addressList.size(); i++) {
            result += i + ". " + addressList.get(i).toString() + "\n";
        }
        return result;
    }

    public Address select(Scanner scanner){

        int index;
        String input;

        do {
            try {
                System.out.println("Please select an address: ");
                System.out.println(toString());
                input = scanner.nextLine();

                if(input.equals("")) return null;

                index = Integer.valueOf(input);
            }
            catch (Exception e){
                System.out.println("Input is incorrect. Try again.");
                index = -1;
            }
        }
        while(index >= 0 && index < addressList.size());

        return addressList.get(index);
    }
}
