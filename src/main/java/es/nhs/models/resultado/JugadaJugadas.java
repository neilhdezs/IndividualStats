package es.nhs.models.resultado;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 09/01/2023
 */
public class JugadaJugadas
{

    private String player_name;

    private String action;

    private List<Double> location;

    public JugadaJugadas()
    {

    }

    public JugadaJugadas(String player_name, String action, List<Double> location)
    {
        this.player_name = player_name;
        this.action = action;
        this.location = location;
    }

    public String getPlayer_name()
    {
        return player_name;
    }

    public void setPlayer_name(String player_name)
    {
        this.player_name = player_name;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public List<Double> getLocation()
    {
        return location;
    }

    public void setLocation(List<Double> location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "JugadaJugadas{" +
                "player_name='" + player_name + '\'' +
                ", action='" + action + '\'' +
                ", location=" + location +
                '}';
    }
}
