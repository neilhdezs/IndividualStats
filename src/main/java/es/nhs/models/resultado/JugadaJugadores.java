package es.nhs.models.resultado;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 09/01/2023
 */
public class JugadaJugadores
{

    private String action;

    private List<Double> location;

    public JugadaJugadores(String action, List<Double> location)
    {
        this.action = action;
        this.location = location;
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
        return "JugadaJugadores{" +
                "action='" + action + '\'' +
                ", location=" + location +
                '}';
    }

}
