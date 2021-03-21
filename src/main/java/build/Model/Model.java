package build.Model;

import build.Model.lists.*;
import java.sql.*;

public class Model {
    private GroupList groupList;
    private AddressList addressList;
    private BankInfoList bankInfoList;
    private ParentList parentList;
    private UserAccountList userAccountList;

    private TeacherList teacherList;
    private ChildList childList;
    private WaitingList waitingList;

    public Model(Statement statement){
        groupList = new GroupList(statement);
        addressList = new AddressList(statement);
        bankInfoList = new BankInfoList(statement);
        parentList = new ParentList(statement);
        userAccountList = new UserAccountList(statement);

        teacherList = new TeacherList(statement, groupList, addressList, bankInfoList);
        childList = new ChildList(statement, groupList, parentList);
        waitingList = new WaitingList(statement, parentList);
    }

    public void saveModel(Statement statement){

        childList.saveToDatabase(statement);
    }

    public GroupList getGroupList() {
        return groupList;
    }

    public AddressList getAddressList() {
        return addressList;
    }

    public BankInfoList getBankInfoList() {
        return bankInfoList;
    }

    public ParentList getParentList() {
        return parentList;
    }

    public UserAccountList getUserAccountList() {
        return userAccountList;
    }

    public TeacherList getTeacherList() {
        return teacherList;
    }

    public ChildList getChildList() {
        return childList;
    }

    public WaitingList getWaitingList() {
        return waitingList;
    }
}
