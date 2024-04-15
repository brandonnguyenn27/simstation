package randomwalk;

import mvc.Model;
import simstation.SimStationFactory;

class RandomWalkFactory extends SimStationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
