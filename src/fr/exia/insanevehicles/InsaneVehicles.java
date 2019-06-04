package fr.exia.insanevehicles;

import java.io.IOException;

import fr.exia.insanevehicles.controller.IIinsaneVehiclesController;
import fr.exia.insanevehicles.controller.InsaneVehiclesController;
import fr.exia.insanevehicles.model.IInsaneVehiclesModel;
import fr.exia.insanevehicles.model.InsaneVehiclesModel;
import fr.exia.insanevehicles.view.InsaneVehiclesView;

/**
 * <h1>The InsaneVehicles Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class InsaneVehicles {

    /** The Constant startX. */
    private static final int startX = 5;

    /** The Constant startY. */
    private static final int startY = 2;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     *             the interrupted exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IInsaneVehiclesModel model = new InsaneVehiclesModel("road.txt", startX, startY);
        final InsaneVehiclesView view = new InsaneVehiclesView(model.getRoad(), model.getMyVehicle());
        final IIinsaneVehiclesController controller = new InsaneVehiclesController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}
