package test.autoventive.dao

/**
 * Base Dao Class
 * (not really implemented; just for arbitrary implementation)
 */
interface BaseDao<T> {

    def getAll()

    // returns the object with matching id
    def getByIdentifier(String identifier)

    int save(final T object)

    void delete(final T container)
}
