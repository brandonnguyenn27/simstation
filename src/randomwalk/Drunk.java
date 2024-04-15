package randomwalk;

//<<<<<<< HEAD
//import mvc.*;
//import simstation.*;
//import java.awt.*;
//import java.util.Iterator;
//
//public class Drunk extends Agent {
//=======
import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

public class Drunk extends Agent {

    public Drunk() {
        super();
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }
}
