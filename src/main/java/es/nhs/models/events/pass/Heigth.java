package es.nhs.models.events.pass;

public class Heigth
{
    private int id; // id
    private String name; // name of the Heigth

    public Heigth()
    {

    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Heigth{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
