package models;

import org.eclipse.jetty.server.PushBuilder;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class Teams {
    private String mName;
    private String mCause;
    private int mNumber;
    private int mId;
    private static List<Teams> instances = new ArrayList<>();
    private List<Members> mMembers;

    public Teams(String name, String cause, int number) {
        this.mName = name;
        this.mCause = cause;
        this.mNumber = number;
        instances.add(this);
        mId = instances.size();
        mMembers = new ArrayList<Members>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getCause() {
        return mCause;
    }

    public void setCause(String cause) {
        this.mCause = cause;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        this.mNumber = number;
    }

    public static List<Teams> all(){
        return instances;
    }

    public int getId(){
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public static Teams find(int id){
        return instances.get(id-1);
    }

    public static void clearTeams(){
        instances.clear();
    }
    public void deleteTeam(){
        instances.remove(mId-1);
    }

    public List<Members> getMembers() {
        return mMembers;
    }

    public void addMember(Members member){
        mMembers.add(member);
    }

    public void removeMember(Members member){
        mMembers.remove(member);
    }
}
