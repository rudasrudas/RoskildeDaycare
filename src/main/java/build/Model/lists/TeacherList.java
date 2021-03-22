package build.Model.lists;

import build.Model.data.*;
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

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.teacher";
            statement.executeQuery(sql1);

            for(Teacher t : teacherList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.teacher (Prefix, TeacherName, TeacherSurname, FK_Group, PhoneNumber, Email, FK_Address, FK_BankInfo)" +
                                "VALUES (%s, %s, %s, %d, %s, %s, %d, %d)",
                        t.getPrefix(),
                        t.getName(),
                        t.getSurname(),
                        GroupList.locateID(statement, t.getGroup()),
                        t.getPhoneNumber(),
                        t.getEmail(),
                        AddressList.locateID(statement, t.getAddress()),
                        BankInfoList.locateID(statement, t.getBankInfo()));

                statement.executeQuery(sql2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String toString(){
        String result = "";

        for (int i = 0; i < teacherList.size(); i++) {
            result += i + ". " + teacherList.get(i).toString();
        }
        return result;
    }}
