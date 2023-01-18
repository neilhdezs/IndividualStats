package es.nhs.utils.modelsAux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 24/12/2022
 */
public class ResultListPossessionFilter
{

    int posession;
    String team;
    List<String> actions;
    List<List<Double>> location;
    List<String> player_name;
    List<Integer> minute;
    List<Integer> second;


    public ResultListPossessionFilter()
    {
        this.actions = new ArrayList<>();
        this.location = new ArrayList<>();
        this.player_name = new ArrayList<>();
        this.minute = new ArrayList<>();
        this.second = new ArrayList<>();

    }

    public ResultListPossessionFilter(int posession, String team, List<String> actions)
    {
        this.posession = posession;
        this.team = team;
        this.actions = actions;
    }

    public int getPosession()
    {
        return posession;
    }

    public void setPosession(int posession)
    {
        this.posession = posession;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public List<String> getActions()
    {
        return actions;
    }

    public void setActions(List<String> actions)
    {
        this.actions = actions;
    }

    public List<List<Double>> getLocation()
    {
        return location;
    }

    public void setLocation(List<List<Double>> location)
    {
        this.location = location;
    }

    public List<String> getPlayer_name()
    {
        return player_name;
    }

    public void setPlayer_name(List<String> player_name)
    {
        this.player_name = player_name;
    }

    public List<Integer> getMinute()
    {
        return minute;
    }

    public void setMinute(List<Integer> minute)
    {
        this.minute = minute;
    }

    public List<Integer> getSecond()
    {
        return second;
    }

    public void setSecond(List<Integer> second)
    {
        this.second = second;
    }

    @Override
    public String toString()
    {
        return "ResultListPosesionFilter{" +
                "posession=" + posession +
                ", team='" + team + '\'' +
                ", actions=" + actions +
                ", location=" + location +
                '}';
    }
}
