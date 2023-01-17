package es.nhs.utils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import es.nhs.models.events.Event;
import es.nhs.models.resultado.*;
import es.nhs.utils.modelsAux.GoalShot;
import es.nhs.utils.modelsAux.ResultListPosesionFilter;

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
    Map<Integer, ResultListPosesionFilter> mapPossesion;

    public Filtter(List<Event> eventList)
    {
        this.eventList = eventList;
        this.resultado = new Resultado();
        this.mapPossesion = new HashMap<>();
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

        List<JugadaJugadas> jugadas = new ArrayList<>(); // Storage of jugadas
        List<List<JugadaJugadas>> jugadasList = new ArrayList<>();


        for (Event event : this.eventList)
        {
            if (!this.mapPossesion.containsKey(event.getPossession())) // If not exist int map, we storage the new data
            {
                if (event.getLocation() != null && event.getPlayer() != null)
                {
                    this.mapPossesion.put(event.getPossession(), new ResultListPosesionFilter()); // We create the result
                    this.mapPossesion.get(event.getPossession()).getActions().add(event.getType().getName()); // we add the action
                    this.mapPossesion.get(event.getPossession()).setTeam(event.getTeam().getName()); // We add the name of the team
                    this.mapPossesion.get(event.getPossession()).setPosession(event.getPossession()); // We add the number possesion
                    this.mapPossesion.get(event.getPossession()).getLocation().add(event.getLocation()); // We add the location of the event
                    this.mapPossesion.get(event.getPossession()).getPlayer_name().add(event.getPlayer().getName());
                    this.mapPossesion.get(event.getPossession()).getSecond().add(event.getSecond());
                    this.mapPossesion.get(event.getPossession()).getMinute().add(event.getMinute());
                }

            } else
            {
                if (event.getLocation() != null)
                {
                    this.mapPossesion.get(event.getPossession()).getActions().add(event.getType().getName());
                    this.mapPossesion.get(event.getPossession()).getLocation().add(event.getLocation());
                    this.mapPossesion.get(event.getPossession()).getSecond().add(event.getSecond());
                    this.mapPossesion.get(event.getPossession()).getMinute().add(event.getMinute());
                    this.mapPossesion.get(event.getPossession()).getPlayer_name().add(event.getPlayer().getName());
                }
            }
        }

        for (Map.Entry<Integer, ResultListPosesionFilter> entry : mapPossesion.entrySet())
        {

            double posicionAnteriorJugador = entry.getValue().getLocation().get(0).get(0);

            int j = 0;

            if (entry.getValue().getLocation().size() > 2)
            {
                while (j < entry.getValue().getLocation().size())
                {
                    while (posicionAnteriorJugador < entry.getValue().getLocation().get(j).get(0))
                    {
                        jugadas.add(new JugadaJugadas(
                                entry.getValue().getPlayer_name().get(j),
                                entry.getValue().getActions().get(j),
                                entry.getValue().getLocation().get(j)));

                        posicionAnteriorJugador = entry.getValue().getLocation().get(j).get(0);

                        j++;

                        if (j == entry.getValue().getLocation().size())
                        {
                            break;
                        }

                    }

                    if (jugadas.size() > 2)
                    {
                        this.resultado.getJugadas_verticales().add(new JugadasVerticales(entry.getValue().getMinute().get(0), entry.getValue().getSecond().get(0), entry.getValue().getTeam(), new ArrayList<>(jugadas)));
                    }


                    if (j == entry.getValue().getLocation().size())
                    {
                        break;
                    }

                    j++;

                    jugadas.clear();

                }

                jugadas.clear();
            }
        }
    }


    public void jugadorVertical()
    {

        int positionAuxJ = 0;

        String namePlayer = "";

        Double posicionAnteriorJugador = null;

        List<ResultListPosesionFilter> resultListPosesionFilterList = new ArrayList<>();

        List<JugadaJugadores> jugadaJugadoresList = new ArrayList<>();

        for (Map.Entry<Integer, ResultListPosesionFilter> entry : this.mapPossesion.entrySet())
        {
            resultListPosesionFilterList.add(entry.getValue());
        }

        for (int i = 0; i < resultListPosesionFilterList.size(); i++)
        {

            for (int j = 0; j < resultListPosesionFilterList.get(i).getLocation().size(); j++)
            {
                if (posicionAnteriorJugador == null)
                {
                    posicionAnteriorJugador = resultListPosesionFilterList.get(i).getLocation().get(0).get(0);
                    namePlayer = resultListPosesionFilterList.get(i).getPlayer_name().get(0);
                } else
                {
                    if (resultListPosesionFilterList.get(i).getLocation().get(j).get(0) - posicionAnteriorJugador >= 20 && namePlayer.equals(resultListPosesionFilterList.get(i).getPlayer_name().get(j)))
                    {
                        jugadaJugadoresList.add(
                                new JugadaJugadores(
                                resultListPosesionFilterList.get(i).getActions().get(j),
                                resultListPosesionFilterList.get(i).getLocation().get(j)));
                    }
                }
            }

            if (jugadaJugadoresList.size() > 2)
            {
                this.resultado.getJugador_vertical().add(new JugadoresVerticales(resultListPosesionFilterList.get(i).getMinute().get(jugadaJugadoresList.size() - 1), resultListPosesionFilterList.get(i).getSecond().get(jugadaJugadoresList.size() - 1), resultListPosesionFilterList.get(i).getTeam(), resultListPosesionFilterList.get(i).getPlayer_name().get(jugadaJugadoresList.size() - 1), new ArrayList<>(jugadaJugadoresList)));
            }

            posicionAnteriorJugador = resultListPosesionFilterList.get(i).getLocation().get(i).get(0);

            jugadaJugadoresList.clear();

        }

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
