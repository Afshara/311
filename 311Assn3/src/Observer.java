import java.util.List;

public abstract class Observer {
    private List<Observer> changeObservers;

    protected void announceChangeEvent(Observer changedObserver) {
        for(Observer o : changeObservers) {
            o.notify(changedObserver);
        }
    }

    public void registerWithChangeEvent(Object o) {
        changeObservers.add(o);
    }

}
