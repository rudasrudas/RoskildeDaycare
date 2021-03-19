package Model.lists;

import Model.data.*;
import java.sql.*;
import java.util.ArrayList;

public class TeacherList {
    private ArrayList<Teacher> teacherList;

    public TeacherList(Statement statement, GroupList groupList, AddressList addressList, BankInfoList bankInfoList){
        teacherList = new ArrayList<Teacher>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.teacher";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                int GroupID = rs.getInt("FK_Group");
                int AddressID = rs.getInt("FK_Address");
                int BankInfoID = rs.getInt("FK_BankInfo");

                teacherList.add(new Teacher(rs.getInt("PK_Teacher"),
                        rs.getString("Prefix"),
                        rs.getString("TeacherName"),
                        rs.getString("TeacherSurname"),
                        groupList.getGroup(GroupID),
                        rs.getString("PhoneNumber"),
                        rs.getString("Email"),
                        addressList.getAddress(AddressID),
                        bankInfoList.getBankInfo(BankInfoID)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
