package game.grounds;

/**
 * Generic Activatable object
 *
 * Created by: William-Bata-Kindermann
 * Last Modified By: William Bata-Kindermann
 *
 * @see game.actions.ActivateAction
 */
public interface Activatable {

    /**
     * Activates the instance.
     * @return A description of the outcome of activation.
     */
    String activate();
}
