package test.autoventive.service

import test.autoventive.dao.AssetDao
import test.autoventive.dao.BaseDao
import test.autoventive.model.Asset

/**
 * Service layer for the asset
 */
class AssetService implements Service {

    /**
     * Implied by dependency injection
     */
    AssetDao assetDao

    /**
     * Retrieves the assets loaded onto a particular container
     *
     * @param containerId the ID of the container to query
     * @return the list of {@link Asset}s for that container
     */
    List<Asset> getLoadedAssets(final String containerId) {
        return assetDao.getByContainer(containerId)
    }

    @Override
    BaseDao getDao() {
        return null
    }
}
