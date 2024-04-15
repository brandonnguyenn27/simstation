package randomwalk;

import mvc.*;
import simstation.*;
import java.awt.*;
import java.util.Iterator;

public class RandomWalkFactory extends SimStationFactory {
    public Simulation makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
