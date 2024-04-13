package simstation;
import mvc.*;
public class ResumeCommand extends Command {
    public ResumeCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simulation simulation = (Simulation)model;
        if (!simulation.running()) {
            Utilities.inform("Simulation is not running yet");
        }
        else if (simulation.suspended()) {
            simulation.resume();
        }
        else {
            Utilities.inform("The simulation has resumed already");
        }
    }
}
