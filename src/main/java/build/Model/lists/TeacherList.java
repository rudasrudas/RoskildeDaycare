package build.Model.lists;

import build.Model.data.*;
import java.sql.*;
import java.util.*;

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
            statement.executeUpdate(sql1);

            for(Teacher t : teacherList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.teacher (Prefix, TeacherName, TeacherSurname, FK_Group, PhoneNumber, Email, FK_Address, FK_BankInfo)" +
                                "VALUES ('%s', '%s', '%s', '%d', '%s', '%s', '%d', '%d')",
                        t.getPrefix(),
                        t.getName(),
                        t.getSurname(),
                        (t.getGroup() == null ? -1 : t.getGroup().getId()),
                        t.getPhoneNumber(),
                        t.getEmail(),
                        (t.getAddress() == null ? -1 : t.getAddress()),
                        (t.getBankInfo() == null ? -1 : t.getBankInfo()));

                int id = statement.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);
                t.setId(id);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void add(Teacher teacher){
        teacherList.add(teacher);
    }
    public void remove(Teacher teacher){
        teacherList.remove(teacher);
    }

    public String toString(){
        String result = "";

        for (int i = 0; i < teacherList.size(); i++) {
            result += i + ". " + teacherList.get(i).toString() + "\n";
        }
        return result;
    }

    public Teacher select(Scanner scanner){

        int index;
        String input;

        do {
            try {
                System.out.println("Please select a teacher: ");
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
        while(index < 0 || index >= teacherList.size());

        return teacherList.get(index);
    }

    public String teachersInGroup(Group group){
        String result = "";
        for(Teacher c : teacherList){
            if(c.getGroup() == group) result += c + "\n";
        }

        return result;
    }
}
