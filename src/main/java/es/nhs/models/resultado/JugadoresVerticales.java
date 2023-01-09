package es.nhs.models.resultado;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 09/01/2023
 */
public class JugadoresVerticales
{

    private int minute;

    private int second;

    private String team;

    private String player_name;

    private List<JugadaJugadores> jugada;

    public JugadoresVerticales(int minute, int second, String team, String player_name, List<JugadaJugadores> jugada)
    {
        this.minute = minute;
        this.second = second;
        this.team = team;
        this.player_name = player_name;
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

    public String getPlayer_name()
    {
        return player_name;
    }

    public void setPlayer_name(String player_name)
    {
        this.player_name = player_name;
    }

    public List<JugadaJugadores> getJugada()
    {
        return jugada;
    }

    public void setJugada(List<JugadaJugadores> jugada)
    {
        this.jugada = jugada;
    }

    @Override
    public String toString()
    {
        return "JugadoresVerticales{" +
                "minute=" + minute +
                ", second=" + second +
                ", team='" + team + '\'' +
                ", player_name='" + player_name + '\'' +
                ", jugada=" + jugada +
                '}';
    }

}
