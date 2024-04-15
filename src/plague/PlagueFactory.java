package plague;
import mvc.AppFactory;
import simstation.*;
import mvc.*;
public class PlagueFactory extends SimStationFactory {
    @Override
    public Simulation makeModel() {
        return new PlagueSimulation();
    }
    @Override
    public PlagueView makeView(Model m) {
        return new PlagueView(m);
    }
//    @Override
//    public Model makeModel() {
//        return new PlagueSimulation();
//    }
    public String getTitle() { return "Plague";}
}
