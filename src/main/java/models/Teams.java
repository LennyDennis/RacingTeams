package models;

import java.util.ArrayList;
import java.util.List;

public class Teams {
    private String mName;
    private String mCause;
    private int mNumber;
    private int mId;
    private static List<Teams> instances = new ArrayList<>();
    private List<Members> mMembers;

    public Teams(String mName, String mCause, int mNumber) {
        this.mName = mName;
        this.mCause = mCause;
        this.mNumber = mNumber;
        instances.add(this);
        mId = instances.size();
        mMembers = new ArrayList<Members>();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCause() {
        return mCause;
    }

    public void setmCause(String mCause) {
        this.mCause = mCause;
    }

    public int getmNumber() {
        return mNumber;
    }

    public void setmNumber(int mNumber) {
        this.mNumber = mNumber;
    }
}
