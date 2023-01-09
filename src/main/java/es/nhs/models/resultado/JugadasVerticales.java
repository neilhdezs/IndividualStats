package es.nhs.models.resultado;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 09/01/2023
 */
public class JugadasVerticales
{

    private int minute;

    private int second;

    private String team;

    private List<JugadaJugadas> jugada;

    public JugadasVerticales(int minute, int second, String team, List<JugadaJugadas> jugada)
    {
        this.minute = minute;
        this.second = second;
        this.team = team;
        this.jugada = jugada;
    }

    public int getMinute()
    {
        return minute;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public int getSecond()
    {
        return second;
    }

    public void setSecond(int second)
    {
        this.second = second;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public List<JugadaJugadas> getJugada()
    {
        return jugada;
    }

    public void setJugada(List<JugadaJugadas> jugada)
    {
        this.jugada = jugada;
    }

    @Override
    public String toString()
    {
        return "JugadasVerticales{" +
                "minute=" + minute +
                ", second=" + second +
                ", team='" + team + '\'' +
                ", jugada=" + jugada +
                '}';
    }

}
