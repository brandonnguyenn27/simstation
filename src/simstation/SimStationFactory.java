package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class SimStationFactory implements AppFactory {

    public Model makeModel() {
        return new Simulation();
    }

    public View makeView(Model model) {
        return new SimulationView(model);
    }

    public String getTitle() {
        return "SimStation";
    }

    public String[] getHelp() {
        return new String[]{"Help"};
    }

    public String about() {
        return "SimStation Simulation";
    }

    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if ("Start".equals(type)) {
            return new StartCommand(model);
        } else if ("Suspend".equals(type)) {
            return new SuspendCommand(model);
        } else if ("Resume".equals(type)) {
            return new ResumeCommand(model);
        } else if ("Stop".equals(type)) {
            return new StopCommand(model);
        } else if ("Stats".equals(type)) {
            return new StatsCommand(model);
        } else {
            return null;
        }
    }
}
