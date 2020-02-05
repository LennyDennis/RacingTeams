package models;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MembersTest {
    @After
    public void tearDown(){
        Members.clearMembers();
    }

    @Test
    public void Members_getTheNameValue_name(){
        Members member = new Members("Lenny",23,"DRS","Corners","Ferrari");
        assertEquals("Lenny",member.getName());

    }
    @Test
    public void Members_getTheAgeValue_age(){
        Members member = new Members("Lenny",23,"DRS","Corners","Ferrari");
        assertEquals(23,member.getAge());

    }
    @Test
    public void Members_getThePowerValue_power(){
        Members member = new Members("Lenny",23,"DRS","Corners","Ferrari");
        assertEquals("DRS",member.getPower());

    }
    @Test
    public void Members_getWeaknessValue_weakness(){
        Members member = new Members("Lenny",23,"DRS","Corners","Ferrari");
        assertEquals("Corners",member.getWeakness());

    }
    @Test
    public void Member_getAllMemberInstances_members(){
        Members member1 = new Members("Lenny",23,"DRS","Corners","Ferrari");
        Members member2 = new Members("Lenny",23,"DRS","Corners","Ferrari");;
        assertTrue(Members.all().contains(member1));
        assertTrue(Members.all().contains(member2));
    }

    @Test
    public void Member_getIdOfTheMember_1(){
        Members member = new Members("Lenny",23,"DRS","Corners","Ferrari");
        assertEquals(1,member.getId());
    }

    @Test
    public void Member_deletesAllMembers_zeroSize(){
        Members member1 = new Members("Lenny",23,"DRS","Corners","Ferrari");
        Members member2 = new Members("Lenny",23,"DRS","Corners","Ferrari");;
        Members.clearMembers();
        assertEquals(0,Members.all().size());
    }

    @Test
    public void Member_getSpecificMember_2(){
        Members member1 = new Members("Lenny",23,"DRS","Corners","Ferrari");
        Members member2 = new Members("Lenny",23,"DRS","Corners","Ferrari");;
        assertEquals(member2,member2.find(member2.getId()));
    }

}