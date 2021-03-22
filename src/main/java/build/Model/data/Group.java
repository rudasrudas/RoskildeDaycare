package build.Model.data;

public class Group {
    private int id;
    private String groupName;

    public Group(int id, String groupName)
    {
        this.id = id;
        this.groupName = groupName;
    }

    public String toString(){
        return groupName;
    }

    public int getId(){
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

