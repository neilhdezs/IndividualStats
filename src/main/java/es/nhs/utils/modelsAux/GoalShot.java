package es.nhs.utils.modelsAux;

import es.nhs.models.events.Event;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 09/01/2023
 */
public class GoalShot
{

    private int shot;

    private int goal;

    private String team;

    public GoalShot(int shot, int goal, String team)
    {
        this.shot = shot;
        this.goal = goal;
        this.team = team;
    }

    public int getShot()
    {
        return shot;
    }

    public void setShot(int shot)
    {
        this.shot = shot;
    }

    public int getGoal()
    {
        return goal;
    }

    public void setGoal(int goal)
    {
        this.goal = goal;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    @Override
    public String toString()
    {
        return "GoalShot{" +
                "shot=" + shot +
                ", goal=" + goal +
                '}';
    }
}
