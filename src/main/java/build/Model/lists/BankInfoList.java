package build.Model.lists;

import build.Model.data.Address;
import build.Model.data.BankInfo;
import build.Model.data.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

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
            statement.executeUpdate(sql1);

            for(BankInfo b : bankInfoList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.bankinfo (BankName, AccountName, AccountSurname, AccountNumber, RegNumber, KontoNumber)" +
                                "VALUES ('%s', '%s', '%s', '%d', '%d', '%d')",
                        b.getBankName(),
                        b.getAccountName(),
                        b.getAccountSurname(),
                        b.getAccountNumber(),
                        b.getRegNumber(),
                        b.getKontoNumber());

                statement.executeUpdate(sql2);
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
        if(bankInfo == null) return -1;

        String sql = String.format("SELECT * FROM roskildedaycare1.bankinfo WHERE BankName = '%s' AND AccountName = '%s' AND AccountSurname = '%s' AND AccountNumber = '%s' AND RegNumber = '%s' AND KontoNumber = '%s'",
                bankInfo.getBankName(),
                bankInfo.getAccountName(),
                bankInfo.getAccountSurname(),
                bankInfo.getAccountNumber(),
                bankInfo.getRegNumber(),
                bankInfo.getKontoNumber());
        try{
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())return rs.getInt("PK_BankInfo");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }

    public void add(BankInfo bankInfo){ bankInfoList.add(bankInfo); }
    public void remove(BankInfo bankInfo){ bankInfoList.remove(bankInfo); }

    public String toString(){
        String result = "";

        for (int i = 0; i < bankInfoList.size(); i++) {
            result += i + ". " + bankInfoList.get(i).toString() + "\n";
        }
        return result;
    }

    public BankInfo select(Scanner scanner){

        int index;
        String input;

        do {
            try {
                System.out.println("Please select a bank account: ");
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
        while(index < 0 || index >= bankInfoList.size());

        return bankInfoList.get(index);
    }
}
