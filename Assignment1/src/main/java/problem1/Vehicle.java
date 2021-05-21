package problem1;

import problem1.Owner;

/**
 * Vehicle is an object that has a unique Vehicle Identification Number(VIN), corresponding license plate,
 * and its owner's information.
 *
 * @author Zu Yu Zhang
 */

public class Vehicle {
    private Integer VIN;
    private String licensePlate;
    private Owner owner;

    /**
     * Constructor that creates a new vehicle object with the specified VIN, licence plate, and owner.
     * @param VIN - VIN of the new Vehicle object.
     * @param licensePlate - license plate of the new Vehicle.
     * @param owner - Owner of the Vehicle.
     */
    public Vehicle(Integer VIN, String licensePlate, Owner owner){
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    /**
     * Returns the VIN of the Vehicle.
     * @return the VIN of the Vehicle.
     */
    public Integer getVIN(){
        return this.VIN;
    }

    /**
     * Returns the licensePlate of the Vehicle.
     * @return the licensePlate of the Vehicle.
     */
    public String getLicensePlate(){
        return this.licensePlate;
    }

    /**
     * Returns the Owner of the Vehicle.
     * @return the Owner of the Vehicle.
     */
    public Owner getOwner(){
        return this.owner;
    }

    /**
     * Sets the Vehicle's VIN.
     * @param VIN the new VIN of the Vehicle.
     */
    public void changeVIN(Integer VIN){
        this.VIN = VIN;
    }

    /**
     * Sets the Vehicle's license plate.
     * @param licensePlate the new license plate of the Vehicle.
     */
    public void changeLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    /**
     * Sets the Vehicle's owner.
     * @param owner the new owner of the Vehicle.
     */
    public void changeOwner(Owner owner){
        this.owner = owner;
    }
}
