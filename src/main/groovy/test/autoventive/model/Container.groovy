package test.autoventive.model

import test.autoventive.enums.Status

/**
 * Represents a Container that will be loaded onto the freight for transportation of vehicles
 */
class Container {

    /**
     * The unique reference for a container
     */
    String identifier

    /**
     * The maximum number of vehicles than can be loaded
     */
    int capacity

    /**
     * The status of the container
     */
    Status status

    /**
     * The orientation of the container
     */
    Orientation orientation

    /**
     * The inventory orientation of the container
     */
    Orientation inventoryOrientation

    // Getter and setter for inventoryOrientation
    Orientation getInventoryOrientation() {
        return inventoryOrientation
    }

    void setInventoryOrientation(Orientation inventoryOrientation) {
        this.inventoryOrientation = inventoryOrientation
    }
}
