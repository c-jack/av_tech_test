package test.autoventive.controller

import test.autoventive.dao.AssetDao
import test.autoventive.dao.BaseDao

/**
 * Controller for Asset-based activities
 */
class AssetController implements CoreController {

    /**
     * (Implied by dependency injection)
     */
    AssetDao assetDao

    /**
     * @return the DAO instance
     */
    @Override
    AssetDao getDao() {
        return this.assetDao
    }

    @Override
    BaseDao getService() {
        return null
    }
}
