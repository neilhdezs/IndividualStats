package es.nhs.models.resultado;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 03/12/2022
 */
public class Resultado
{

    private List<JugadasVerticales> jugadas_verticales;

    private List<JugadoresVerticales> jugador_vertical;

    private List<MapaCalor> mapa_calor;

    private List<JugadoresInfrautilizados> jugador_infrautilizado;

    public Resultado()
    {
        this.jugadas_verticales = new ArrayList<>();
        this.jugador_vertical = new ArrayList<>();
        this.mapa_calor =  new ArrayList<>();
        this.jugador_infrautilizado =  new ArrayList<>();
    }

    public List<JugadasVerticales> getJugadas_verticales()
    {
        return jugadas_verticales;
    }

    public void setJugadas_verticales(List<JugadasVerticales> jugadas_verticales)
    {
        this.jugadas_verticales = jugadas_verticales;
    }

    public List<JugadoresVerticales> getJugador_vertical()
    {
        return jugador_vertical;
    }

    public void setJugador_vertical(List<JugadoresVerticales> jugador_vertical)
    {
        this.jugador_vertical = jugador_vertical;
    }

    public List<MapaCalor> getMapa_calor()
    {
        return mapa_calor;
    }

    public void setMapa_calor(List<MapaCalor> mapa_calor)
    {
        this.mapa_calor = mapa_calor;
    }

    public List<JugadoresInfrautilizados> getJugador_infrautilizado()
    {
        return jugador_infrautilizado;
    }

    public void setJugador_infrautilizado(List<JugadoresInfrautilizados> jugador_infrautilizado)
    {
        this.jugador_infrautilizado = jugador_infrautilizado;
    }

    @Override
    public String toString()
    {
        return "Resultado{" +
                "jugadas_verticales=" + jugadas_verticales +
                ", jugador_vertical=" + jugador_vertical +
                ", mapa_calor=" + mapa_calor +
                ", jugador_infrautilizado=" + jugador_infrautilizado +
                '}';
    }
}
