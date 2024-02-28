package test.autoventive.dao

import test.autoventive.model.Asset

/**
 * Dao Class for Containers
 * (not really implemented; just for arbitrary implementation)
 */
interface AssetDao extends BaseDao {

    List<Asset> getByContainer(final String containerId)
}
