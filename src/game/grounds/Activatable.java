package game.grounds;

/**
 * Generic Activatable object
 *
 * @author William Bata-Kindermann
 * @see game.actions.ActivateAction
 */
public interface Activatable {

    /**
     * Activates the instance.
     * @return A description of the outcome of activation.
     */
    String activate();
}
