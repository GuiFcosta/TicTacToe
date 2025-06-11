package pt.isec.pa.tictactoe.model.memento;

public interface IOriginator {
    IMemento save();
    void restore(IMemento memento);
}
