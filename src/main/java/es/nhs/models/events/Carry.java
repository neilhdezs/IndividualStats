package es.nhs.models.events;

import java.util.List;

public class Carry
{

    private List<Integer> end_location;

    public Carry()
    {

    }

    public List<Integer> getEnd_location()
    {
        return this.end_location;
    }

    public void setEnd_location(List<Integer> end_location)
    {
        this.end_location = end_location;
    }

    @Override
    public String toString()
    {
        return "Carry{" + "end_location=" + end_location + '}';
    }
}
