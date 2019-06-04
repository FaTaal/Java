package fr.exia.insanevehicles.controller;

import java.io.IOException;

import fr.exia.insanevehicles.model.IInsaneVehiclesModel;
import fr.exia.insanevehicles.view.IInsaneVehiclesView;

/**
 * <h1>The Class InsaneVehiclesController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public class InsaneVehiclesController implements IIinsaneVehiclesController, IOrderPerformer {

    /** The Constant speed. */
    private static final int     speed = 200;

    /** The view. */
    private IInsaneVehiclesView  view;

    /** The model. */
    private IInsaneVehiclesModel model;

    /** The stack order. */
    private UserOrder            stackOrder;

    /**
     * Instantiates a new insane vehicles controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public InsaneVehiclesController(final IInsaneVehiclesView view, final IInsaneVehiclesModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyVehicle().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyVehicle().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyVehicle().moveLeft();
                    break;
                case UP:
                    this.getModel().getMyVehicle().moveUp();
                    break;
                case DOWN:
                    this.getModel().getMyVehicle().moveDown();
                    break;
                case NOP:
                default:
                    this.getModel().getMyVehicle().doNothing();
                    break;
            }
            this.clearStackOrder();
            
        }
        this.getView().displayMessage("CRASH !!!!!!!!!");
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IOrderPerformed#orderPerform(fr.exia.insanevehicles.
     * controller.UserOrder)
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#orderPerform(fr.exia.
     * insanevehicles.controller.UserOrder)
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private IInsaneVehiclesView getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IInsaneVehiclesView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    private IInsaneVehiclesModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IInsaneVehiclesModel model) {
        this.model = model;
    }

    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#getOrderPeformer()
     */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}
