package sw10;

public interface Switchable {

    /** Schaltet das Switchable an
     @return:void
     */
    void switchOn();
    /** Schaltet das Switchable aus
     @return:void
     */
    void switchOff();

    /** Gibt zurück ob das Switchable in eine angeschaltete zustand ist
     @return:boolean
     */
    boolean isSwitchedOn();
    /** Gibt zurück ob das Switchable in eine ausgeschaltete zustand ist
     @return:boolean
     */
    boolean isSwitchedOff();
}
