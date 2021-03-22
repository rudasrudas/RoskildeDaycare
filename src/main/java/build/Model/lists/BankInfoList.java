package build.Model.lists;

import build.Model.data.Address;
import build.Model.data.BankInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

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
                        rs.getInt(7)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.bankinfo";
            statement.executeQuery(sql1);

            for(BankInfo b : bankInfoList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.bankinfo (BankName, AccountName, AccountSurname, AccountNumber, RegNumber, KontoNumber)" +
                                "VALUES (%s, %s, %s, %d, %d, %d)",
                        b.getBankName(),
                        b.getAccountName(),
                        b.getAccountSurname(),
                        b.getAccountNumber(),
                        b.getRegNumber(),
                        b.getKontoNumber());

                statement.executeQuery(sql2);
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

    public static int locateID(Statement statement, BankInfo bankInfo){
        String sql = String.format("SELECT * FROM roskildedaycare1.bankinfo WHERE BankName = %s AND AccountName = %s AND AccountSurname = %s AND AccountNumber = %s AND RegNumber = %s AND KontoNumber = %s",
                bankInfo.getBankName(),
                bankInfo.getAccountName(),
                bankInfo.getAccountSurname(),
                bankInfo.getAccountNumber(),
                bankInfo.getRegNumber(),
                bankInfo.getKontoNumber());
        try{
            ResultSet rs = statement.executeQuery(sql);
            if(rs == null){
                return -1; //if no bankinfo is found, dont bother
            }

            return rs.getInt("PK_BankInfo");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }

    public String toString(){
        String result = "";

        for (int i = 0; i < bankInfoList.size(); i++) {
            result += i + ". " + bankInfoList.get(i).toString();
        }
        return result;
    }

}
