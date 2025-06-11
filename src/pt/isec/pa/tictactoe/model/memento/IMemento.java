package pt.isec.pa.tictactoe.model.memento;

public interface IMemento {
    default  Object getSnapshot() { return null; }
}
