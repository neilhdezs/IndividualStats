package es.nhs.models.resultado;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 09/01/2023
 */
public class JugadoresInfrautilizados
{

    private String team;

    private String player_name;

    private int tiros;

    private int goles;

    private int efectividad;

    public JugadoresInfrautilizados(String team, String player_name, int tiros, int goles, int efectividad)
    {
        this.team = team;
        this.player_name = player_name;
        this.tiros = tiros;
        this.goles = goles;
        this.efectividad = efectividad;
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

    public int getTiros()
    {
        return tiros;
    }

    public void setTiros(int tiros)
    {
        this.tiros = tiros;
    }

    public int getGoles()
    {
        return goles;
    }

    public void setGoles(int goles)
    {
        this.goles = goles;
    }

    public int getEfectividad()
    {
        return efectividad;
    }

    public void setEfectividad(int efectividad)
    {
        this.efectividad = efectividad;
    }

    @Override
    public String toString()
    {
        return "JugadoresInfrautilizados{" +
                "team='" + team + '\'' +
                ", player_name='" + player_name + '\'' +
                ", tiros=" + tiros +
                ", goles=" + goles +
                ", efectividad=" + efectividad +
                '}';
    }
}
