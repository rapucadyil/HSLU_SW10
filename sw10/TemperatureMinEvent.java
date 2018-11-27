import java.util.EventObject;

public class TemperatureMinEvent extends EventObject {

    private Object value;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperatureMinEvent(Object source, Object value) {
        super(source);
        this.value = value;
    }

    public Object getSource() {
        return super.getSource();
    }

    public Object getValue() {
        return value;
    }

}
