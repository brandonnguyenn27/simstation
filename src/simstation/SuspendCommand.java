package simstation;
import mvc.*;
public class SuspendCommand extends Command {
    public SuspendCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simulation simulation = (Simulation)model;
        if (!simulation.running()) {
            Utilities.inform("Simulation is not running");
        }
        else if (simulation.suspended()) {
            Utilities.inform("Simulation is already suspended");
        }
        else {
            simulation.suspend();
        }

    }
}
