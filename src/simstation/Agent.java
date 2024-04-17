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
        suspended();
        onStart();
        while (!stopped) {
            try {
                update();
                Thread.sleep(20);
                suspended();
            } catch (InterruptedException e) {
                Utilities.error(e);
            }
        }
        onExit();
    }


    public synchronized void start() {
        stopped = false;
        suspended = false;
        //world.populate();
        myThread = new Thread(this);
        myThread.start();
    }
    public synchronized void stop() {
        stopped = true;
        //myThread.interrupt();
    }
    public synchronized void suspend() {
        suspended = true;
    }
    public synchronized void resume() {
        notify();
    }
//    public void move(int steps) {
//        switch (heading) {
//            case NORTH:
//                yc -= steps;
//                break;
//            case SOUTH:
//                yc += steps;
//                break;
//            case EAST:
//                xc += steps;
//                break;
//            case WEST:
//                xc -= steps;
//                break;
//        }
//        world.changed();
//    }
    // Updated move() method so that it is within world.SIZE border
    public void move(int steps) {
    int offset = 3; // half of agent size, rounded up
    switch (heading) {
        case NORTH:
            yc = ((yc - steps + offset + Simulation.SIZE) % Simulation.SIZE) - offset;
            break;
        case SOUTH:
            yc = ((yc + steps + offset) % Simulation.SIZE) - offset;
            break;
        case EAST:
            xc = ((xc + steps + offset) % Simulation.SIZE) - offset;
            break;
        case WEST:
            xc = ((xc - steps + offset + Simulation.SIZE) % Simulation.SIZE) - offset;
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
