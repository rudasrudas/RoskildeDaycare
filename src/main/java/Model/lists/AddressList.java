package Model.lists;

import Model.data.Address;
import Model.data.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public Address getAddress(int id){
        for(Address g : addressList){
            if(g.getId() == id) return g;
        }

        return null;
    }
}