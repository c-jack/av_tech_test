package test.autoventive.service

import test.autoventive.dao.BaseDao


/**
 * Interface for Service
 */
interface Service {

    /**
     * DAO Instance for the implementation
     */
    abstract BaseDao getDao()
}