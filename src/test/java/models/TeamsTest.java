package models;


import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeamsTest {
    @After
    public void tearDown(){
        Teams.clearTeams();
    }
    @Test
    public void Teams_getTheName_Mercedes(){
        Teams team1 = new Teams("Mercedes","Engine Power",10);
        assertEquals("Mercedes",team1.getName());
    }

    @Test
    public void Teams_getTheCause_EnginePower(){
        Teams team1 = new Teams("Mercedes","Engine Power",10);
        assertEquals("Engine Power",team1.getCause());
    }

    @Test
    public void Teams_getTheNumber_10(){
        Teams team1 = new Teams("Mercedes","Engine Power",10);
        assertEquals(10,team1.getNumber());
    }

    @Test
    public void Teams_getAllTeamInstances_instances(){
        Teams team1 = new Teams("Mercedes","Engine Power",10);
        Teams team2 = new Teams("Mercedes","Engine Power",10);
        assertTrue(Teams.all().contains(team1) );
        assertTrue(Teams.all().contains(team2) );
    }
    @Test
    public void Teams_getTheTeamId_1(){
        Teams team = new Teams("Mercedes","Engine Power",10);
        assertEquals(1,team.getId());
    }
    @Test
    public void Teams_deleteAllTheTeams_0(){
        Teams team = new Teams("Mercedes","Engine Power",10);
        Teams.clearTeams();
        assertEquals(0,Teams.all().size());
    }
}