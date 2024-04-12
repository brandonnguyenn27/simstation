package simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    private String name;
    private Heading heading;
    private Simulation world;
    private int xc, yc;
    private boolean suspended = false;
    private boolean stopped = false;
    transient protected Thread myThread;

    public Agent(String name) {
        this.name = name;
    }

    // Pythagorean theorem to calculate distance between two agents
    public double distance(Agent other) {
        int deltaX = this.xc - other.xc;
        int deltaY = this.yc - other.yc;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


}
