package test.autoventive.controller

import test.autoventive.dao.BaseDao
import test.autoventive.dao.ContainerDao
import test.autoventive.enums.Status
import test.autoventive.model.Container

/**
 * Controller for Container-based activities
 */
class ContainerController implements CoreController {

    /**
     * Implied by dependency injection
     */
    ContainerDao containerDao

    /**
     * Loads an Asset into a Container
     *
     * @param container the ID of the container to load into
     * @param asset the ID of the asset to load into the container
     */
    def load(final String container, final String asset) {
        // TODO implement logic to load a container
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

    List<Container> getContainersByStatus(Status status) {
        return getDao().getAll().find({it.status == status})
    }
}