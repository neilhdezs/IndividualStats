package es.nhs.utils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import es.nhs.models.events.Event;
import es.nhs.models.resultado.*;
import es.nhs.utils.modelsAux.GoalShot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Neil Hdez
 * @version 1.0.0
 * @since 03/12/2022
 */
public class Filtter
{

    List<Event> eventList;
    Resultado resultado;

    public Filtter(List<Event> eventList)
    {
        this.eventList = eventList;
        this.resultado = new Resultado();
    }

    public List<Event> getEventList()
    {
        return eventList;
    }

    public void setEventList(List<Event> eventList)
    {
        this.eventList = eventList;
    }

    public void filtradoCompleto() throws IOException
    {
        jugadasVerticales();
        jugadorVertical();
        mapasDeCalor();
        jugadorInfrautilizado();
        escribirResultadoJson();
        System.out.println(this.resultado.toString());
    }

    public void jugadasVerticales()
    {

    }

    public void jugadorVertical()
    {

    }

    public void mapasDeCalor()
    {
        Map<String, MapaCalor> mapaCalorMap = new HashMap<>();
        for (Event event : this.eventList)
        {
            if (event.getPlayer() != null && event.getLocation() != null)
            {
                if (!mapaCalorMap.containsKey(event.getPlayer().getName()))
                {
                    mapaCalorMap.put(event.getPlayer().getName(), new MapaCalor(event.getTeam().getName(), event.getPlayer().getName(), new ArrayList<List<Double>>()));
                    mapaCalorMap.get(event.getPlayer().getName()).getJugada().add(event.getLocation());
                }
                else
                {
                    mapaCalorMap.get(event.getPlayer().getName()).getJugada().add(event.getLocation());
                }
            }
        }

        for (Map.Entry<String, MapaCalor> entry : mapaCalorMap.entrySet())
        {
            this.resultado.getMapa_calor().add(new MapaCalor(entry.getValue().getTeam(), entry.getValue().getPlayer_name(), entry.getValue().getJugada()));
        }

    }

    public void jugadorInfrautilizado()
    {
        Map<String, GoalShot> jugadoresGoleadores = new HashMap<>();
        for (Event event : this.eventList)
        {
            if (event.getShot() != null)
            {
                if (!jugadoresGoleadores.containsKey(event.getPlayer().getName()))
                {
                    if (event.getShot().getOutcome().getName().equalsIgnoreCase("Goal"))
                    {
                        jugadoresGoleadores.put(event.getPlayer().getName(), new GoalShot(1,1, event.getTeam().getName()));
                    }
                    else
                    {
                        jugadoresGoleadores.put(event.getPlayer().getName(), new GoalShot(1,0, event.getTeam().getName()));
                    }
                }
                else
                {
                    if (event.getShot().getOutcome().getName().equalsIgnoreCase("Goal"))
                    {
                        jugadoresGoleadores.get(event.getPlayer().getName()).setShot(jugadoresGoleadores.get(event.getPlayer().getName()).getShot() + 1);
                        jugadoresGoleadores.get(event.getPlayer().getName()).setGoal(jugadoresGoleadores.get(event.getPlayer().getName()).getGoal() + 1);
                    }
                    else
                    {
                        jugadoresGoleadores.get(event.getPlayer().getName()).setShot(jugadoresGoleadores.get(event.getPlayer().getName()).getShot() + 1);
                    }
                }
            }
        }

        for (Map.Entry<String,GoalShot> entry : jugadoresGoleadores.entrySet())
        {
            if ((entry.getValue().getGoal()*100)/entry.getValue().getShot() >= 33)
            {
                this.resultado.getJugador_infrautilizado().add(new JugadoresInfrautilizados(entry.getValue().getTeam(), entry.getKey(), entry.getValue().getShot(), entry.getValue().getGoal(), (entry.getValue().getGoal()*100)/entry.getValue().getShot()));
            }
        }

    }

    public void escribirResultadoJson() throws IOException
    {
        ObjectWriter writer = Json.mapper().writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("src/main/resources/estadisticas.json"), this.resultado);
    }

}
