package es.nhs.models.events.tactics;

import es.nhs.models.Player;
import es.nhs.models.Position;

public class Lineup
{

    private Player player;
    private Position position;
    private int jersey_number;


    public Lineup()
    {

    }

    public Player getPlayer()
    {
        return this.player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public int getJersey_number()
    {
        return jersey_number;
    }

    public void setJersey_number(int jersey_number)
    {
        this.jersey_number = jersey_number;
    }

    @Override
    public String toString()
    {
        return "Lineup{" + "player=" + player + ", position=" + position + '}';
    }
}
