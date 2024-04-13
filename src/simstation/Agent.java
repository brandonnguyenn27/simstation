package simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    private String name;
    private Heading heading;
    private Simulation world;
    public int xc, yc; // Made public
    private boolean suspended = false;
    private boolean stopped = false;
    transient protected Thread myThread;
    public abstract void update();
    public Agent(String name) {
        this.name = name;
        heading = heading.random(); // Will set heading to random direction
    }
    public void run() {
        while (!stopped) {
            onStart();
            if (!suspended) {
                update();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                onInterrupted();
                stop();
            }
        }
        onExit();
    }
    public void start() {
        stopped = false;
        suspended = false;
        myThread = new Thread(this);
        myThread.start();
    }
    public void stop() {
        stopped = true;
        myThread.interrupt();
    }
    public void suspend() {
        suspended = true;
    }
    public void resume() {
        suspended = false;
    }
    public void move(int steps) {
        switch (heading) {
            case NORTH:
                yc -= steps;
                break;
            case SOUTH:
                yc += steps;
                break;
            case EAST:
                xc += steps;
                break;
            case WEST:
                xc -= steps;
                break;
        }
        world.changed();
    }
    public void setHeading(Heading heading) {
        this.heading = heading;
    }
    public void setXc(int xc) {
        this.xc = xc;
    }
    public void setYc(int yc) {
        this.yc = yc;
    }
    public void setSimulation(Simulation world) {
        this.world = world;
    }
    public Heading getHeading() {
        return heading;
    }
    public int getXc() {
        return this.xc;
    }
    public int getYc() {
        return this.yc;
    }
    // Pythagorean theorem to calculate distance between two agents
    public double distance(Agent other) {
        int deltaX = this.xc - other.xc;
        int deltaY = this.yc - other.yc;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
    // Empty methods to be called by run() but overridden by subclasses
    public void onStart() {

    }
    public void onInterrupted() {

    }
    public void onExit() {

    }
}
