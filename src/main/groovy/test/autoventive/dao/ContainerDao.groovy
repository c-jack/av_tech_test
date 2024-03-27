package test.autoventive.dao

import test.autoventive.enums.Status
import test.autoventive.model.Container

/**
 * Dao Class for Containers
 * (not really implemented; just for arbitrary implementation)
 */
interface ContainerDao extends BaseDao {
    List<Container> getContainersByStatus(Status status)
}
