package simstation;

import mvc.Utilities;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
    private String name;
    protected Heading heading;
    protected Simulation world;
    public int xc, yc; // Made public
    private boolean suspended = false;
    private boolean stopped = false;
    transient protected Thread myThread;
    public abstract void update();
    public Agent(String name) {
        this();
        this.name = name;
    }
    public Agent() {
        super();
        suspended = false;
        stopped = false;
        myThread = null;
    }
    public void run() {
        myThread = Thread.currentThread();
        onStart();
        while (!stopped) {
            if (!suspended) {
                update();
            }
            try {
                update();
                Thread.sleep(20);

            } catch (InterruptedException e) {
                onInterrupted();
                stop();
            }
        }
        onExit();
    }


    public synchronized void start() {
        stopped = false;
        suspended = false;
        myThread = new Thread(this);
        myThread.start();
    }
    public synchronized void stop() {
        stopped = true;
        myThread.interrupt();
    }
    public synchronized void suspend() {
        suspended = true;
    }
    public synchronized void resume() {
        suspended = false;
    }
    public void move(int steps) {
        switch (heading) {
            case NORTH:
                yc =  (yc - steps + Simulation.SIZE) % Simulation.SIZE; // added calculation so that agent wraps around the world, not sure if it actually works
                break;
            case SOUTH:
                yc = (yc + steps + Simulation.SIZE) % Simulation.SIZE;
                break;
            case EAST:
                xc = (xc + steps + Simulation.SIZE) % Simulation.SIZE;
                break;
            case WEST:
                xc = (xc - steps + Simulation.SIZE) % Simulation.SIZE;
                break;
        }
        world.changed();
    }

    public synchronized void suspended() {
        try {
            while (!stopped && suspended) {
                onInterrupted();
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            Utilities.error(e);
        }
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
