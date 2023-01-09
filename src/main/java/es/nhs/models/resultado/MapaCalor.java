package es.nhs.models.resultado;

import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 09/01/2023
 */
public class MapaCalor
{

    private String team;

    private String player_name;

    private List<List<Double>> jugada;

    public MapaCalor(String team, String player_name, List<List<Double>> jugada)
    {
        this.team = team;
        this.player_name = player_name;
        this.jugada = jugada;
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

    public List<List<Double>> getJugada()
    {
        return jugada;
    }

    public void setJugada(List<List<Double>> jugada)
    {
        this.jugada = jugada;
    }

    @Override
    public String toString()
    {
        return "MapaCalor{" +
                "team='" + team + '\'' +
                ", player_name='" + player_name + '\'' +
                ", jugada=" + jugada +
                '}';
    }

}
