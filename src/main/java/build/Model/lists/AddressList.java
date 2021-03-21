package build.Model.lists;

import build.Model.data.Address;
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
            statement.executeQuery(sql1);

            for(Address a : addressList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.address (City, Postcode, StreetName, StreetNumber, FloorNumber, ApartmentNumber, CareOfName, CareOfSurname)" +
                                "VALUES (%s, %s, %s, %d, %d, %d)",
                        a.getCity(),
                        a.getPostCode(),
                        a.getStreetName(),
                        a.getStreetNumber(),
                        a.getFloorNumber(),
                        a.getApartmentNumber(),
                        a.getCareOfName(),
                        a.getCareOfSurname());

                statement.executeQuery(sql2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
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
            result += i + ". " + addressList.get(i).toString();
        }
        return result;
    }

    public Address selectAddress(Scanner scanner){

        int index;
        String input;

        do {
            try {
                System.out.println("Please select an address: ");
                System.out.println(toString());
                input = scanner.nextLine();

                if(input == "") return null;

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
