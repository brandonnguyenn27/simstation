package mvc;


public abstract class Command {
    protected Model model;
    public Command(Model m){
        model=m;
    }
    public Model getModel(){
        return model;
    }
    protected void setModel(Model m)
    {
        model = m;
    }
    public abstract void execute();
}
