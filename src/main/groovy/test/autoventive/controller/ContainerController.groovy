package test.autoventive.controller

import test.autoventive.dao.BaseDao
import test.autoventive.dao.ContainerDao

/**
 * Controller for Container-based activities
 */
class ContainerController implements CoreController {

    /**
     * Implied by dependency injection
     */
    ContainerDao containerDao

    ContainerService containerService

    /**
     * Loads an Asset into a Container
     *
     * @param containerId the ID of the container to load into
     * @param assetId the ID of the asset to load into the container
     */
    def load(final String containerId, final String assetId) {

        // Retrieve container and asset objects using their IDs
        Container container = containerDao.getByIdentifier(containerId)
        Asset asset = assetDao.getByIdentifier(assetId)
        
        // Check if both the container and asset exist
        if (container && asset) {
            // Check if the container has room to load the asset
            if (containerService.hasRoom(containerId)) {
                asset.containerId = containerId
                container.capacity -= 1
                // Save changes to the database
                assetDao.save(asset)
                containerDao.save(container)
            } else {
                println("Container does not have enough room to load the asset.")
            }
        } else {
            println("Container or asset not found.")
        }
    }

    /**
     * @return the DAO instance
     */
    @Override
    ContainerDao getDao() {
        return this.containerDao
    }

    @Override
    BaseDao getService() {
        return null
    }

    /**
     * @param status filter by status
     * @return all persisted instances of containers filtered by status
     */
    List<Container> list(Status status) {
        def containers = getDao().getAll() as List<Container>
        switch(status) {
            case Status.AVAILABLE:
                containers = containers.findAll{ it.status == Status.AVAILABLE }
                break
            case Status.OUT_OF_SERVICE:
                containers = containers.findAll{ it.status == Status.OUT_OF_SERVICE }
                break
            default:
                println("Cannot find Status")
                break
        }
        return containers
    }
}
