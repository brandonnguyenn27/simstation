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


}
