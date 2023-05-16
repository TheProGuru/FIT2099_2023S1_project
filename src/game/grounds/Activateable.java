package game.grounds;

/**
 * Generic Activateable object
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see game.actions.ActivateAction
 */
public interface Activateable {

    /**
     * Activates the instance.
     * @return A description of the outcome of activation.
     */
    String activate();
}
