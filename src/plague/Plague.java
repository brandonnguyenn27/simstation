package plague;

import mvc.Utilities;
import prisoner.Prisoner;
import simstation.Agent;
import simstation.Heading;

public class Plague extends Agent{
    private boolean infected;
    public Plague() {
        super();
        infected = false;
    }
    public boolean isInfected() {
        return infected;
    }
    public void setInfected(boolean infected) {
        this.infected = infected;
    }
    // Unfinished update()
    @Override
    public void update() {
        this.heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
        Plague neighbor = (Plague) world.getNeighbor(this, 10);
        if (neighbor != null) {
            PlagueSimulation Pworld = (PlagueSimulation) world;
            Pworld.infectNeighbor(this, neighbor);
        }
    }
}
