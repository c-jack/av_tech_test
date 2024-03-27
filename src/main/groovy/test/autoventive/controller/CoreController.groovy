package test.autoventive.controller

import test.autoventive.dao.BaseDao

/**
 * Core functionality for Controllers
 */
trait CoreController<T> {

    /**
     * DAO Instance for the implementation
     */
    abstract BaseDao getDao()

    /**
     * Service Instance for the implementation
     */
    abstract BaseDao getService()

    /**
     * @return all persisted instances of the given type
     */
    List<T> list() {
        getDao().getAll() as List<T>
    }

    /**
     * @return the instance with matching ID
     */
    def get(final String identifier) {
        getDao().getByIdentifier(identifier)
    }

    /**
     * Creates and persist an item
     */
    def create(final T object) {
        getDao().save(object)
    }

    /**
     * Creates and persist an item
     */
    def delete(final String identifier) {
        // TODO implement delete logic
//        containerDao.delete(container)
    }

}