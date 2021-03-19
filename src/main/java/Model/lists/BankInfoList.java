package Model.lists;

import Model.data.BankInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.sql.SQLException;

public class BankInfoList {

    private ArrayList<BankInfo> bankInfoList;

    public BankInfoList(Statement statement){
        bankInfoList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.bankinfo";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                bankInfoList.add(new BankInfo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public BankInfo getBankInfo(int id){
        for(BankInfo g : bankInfoList){
            if(g.getId() == id) return g;
        }

        return null;
    }

    public String toString(){
        String result = "";

        for (int i = 0; i < bankInfoList.size(); i++) {
            result += i + ". " + bankInfoList.get(i).toString();
        }
        return result;
    }

}
