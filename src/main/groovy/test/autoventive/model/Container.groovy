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
}
