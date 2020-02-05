package models;

import java.util.ArrayList;
import java.util.List;

public class Members {
    private String mName;
    private int mAge;
    private String mPower;
    private String mWeakness;
    private String mTeam;
    private static List<Members> instances = new ArrayList<Members>();
    private int mId;

    public Members(String name, int age, String power, String weakness,String team) {
        this.mName = name;
        this.mAge = age;
        this.mPower = power;
        this.mWeakness = weakness;
        this.mTeam = team;
        instances.add(this);
        mId = instances.size();
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        this.mAge = age;
    }

    public String getPower() {
        return mPower;
    }

    public void setPower(String power) {
        this.mPower = power;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public void setWeakness(String weakness) {
        this.mWeakness = weakness;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getTeam(){
        return mTeam;
    }

    public static List<Members> all(){
        return instances;
    }

    public int getId(){
        return mId;
    }

    public static void clearMembers(){
        instances.clear();
    }

    public static Members find(int id){
        return instances.get(id-1);
    }
}
