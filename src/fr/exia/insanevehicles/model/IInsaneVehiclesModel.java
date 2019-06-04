package fr.exia.insanevehicles.model;

import fr.exia.insanevehicles.model.element.mobile.IMobile;

/**
 * <h1>The Interface IInsaneVehiclesModel.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IInsaneVehiclesModel {

    /**
     * Gets the road.
     *
     * @return the road
     */
    IRoad getRoad();

    /**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    IMobile getMyVehicle();

}
