import java.util.EventObject;

public class TemperatureMaxEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    private Object value;
    public TemperatureMaxEvent(Object source, Object value) {
        super(source);
        this.value = value;
    }

    public Object getSource() {
        return super.getSource();
    }

    public Object getValue() {
        return this.value;
    }


}
