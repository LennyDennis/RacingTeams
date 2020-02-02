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
        Members member = new Members("Lenny",23,"DRS","Corners");
        assertEquals("Lenny",member.getName());

    }
    @Test
    public void Members_getTheAgeValue_age(){
        Members member = new Members("Lenny",23,"DRS","Corners");
        assertEquals(23,member.getAge());

    }
    @Test
    public void Members_getThePowerValue_power(){
        Members member = new Members("Lenny",23,"DRS","Corners");
        assertEquals("DRS",member.getPower());

    }
    @Test
    public void Members_getWeaknessValue_weakness(){
        Members member = new Members("Lenny",23,"DRS","Corners");
        assertEquals("Corners",member.getWeakness());

    }
    @Test
    public void Member_getAllMemberInstances_members(){
        Members member1 = new Members("Lenny",23,"DRS","Corners");
        Members member2 = new Members("Lenny",23,"DRS","Corners");
        assertTrue(Members.all().contains(member1));
        assertTrue(Members.all().contains(member2));
    }

    @Test
    public void Member_getIdOfTheMember_1(){
        Members member = new Members("Lenny",23,"DRS","Corners");
        assertEquals(1,member.getId());
    }

    @Test
    public void Member_deletesAllMembers_zeroSize(){
        Members member1 = new Members("Lenny",23,"DRS","Corners");
        Members member2 = new Members("Lenny",23,"DRS","Corners");
        Members.clearMembers();
        assertEquals(0,Members.all().size());
    }

    @Test
    public void Member_getSpecificMember_2(){
        Members member1 = new Members("Lenny",23,"DRS","Corners");
        Members member2 = new Members("Lenny",23,"DRS","Corners");
        assertEquals(member2,member2.find(member2.getId()));
    }

}