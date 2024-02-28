package test.autoventive.controller

import spock.lang.Specification
import test.autoventive.dao.AssetDao
import test.autoventive.enums.AssetType
import test.autoventive.enums.Status
import test.autoventive.model.Asset

/**
 * Unit Tests for {@link AssetController}
 */
class AssetControllerTest extends Specification {

    /**
     * Instance of class-under-test
     */
    private AssetController controller

    // Spock Mocks
    private AssetDao mockAssetDao

    /**
     * Pre-test setup
     */
    void setup() {
        mockAssetDao = Mock(AssetDao)
        controller = new AssetController(assetDao: mockAssetDao)
    }

    /**
     * Test for {@link AssetController#list}
     */
    def "list should return all persisted Assets"() {
        given: "I create two distinct assets"
        def asset1 = new Asset(identifier: "Asset1", assetType: AssetType.VEHICLE)
        def asset2 = new Asset(identifier: "Asset2", assetType: AssetType.VEHICLE)

        and: "I stub the getAll DAO method to return the assets"
        mockAssetDao.getAll() >> [asset1, asset2]

        expect: "list to return the value retrieved from the DAO"
        controller.list() == [asset1, asset2]

    }

    /**
     * Test for {@link AssetController#get}
     *
     * This method currently has no validation of the provided string, so we expect all variants of String to work
     */
    def "get should return the result of the DAO getByIdentifier method"() {
        given: "I create a asset"
        def asset = new Asset(identifier: "Asset1", assetType: AssetType.VEHICLE)

        and: "I stub the asset to be returned from the DAO getByIdentifier method"
        1 * mockAssetDao.getByIdentifier(identifier) >> asset

        expect: "list to return the value retrieved from the DAO"
        controller.get(identifier) == asset

        where: "The identifier can be any value"
        identifier << ["Asset1", "Asset2", "", null]

    }

    /**
     * Test for {@link AssetController#create}
     */
    def "get should return the result of the DAO getByIdentifier method"() {
        given: "I create a new asset"
        def asset = new Asset(identifier: "NewAsset", assetType: AssetType.VEHICLE)

        when: "The Asset is passed to the create method"
        controller.create(asset)

        then: "The DAO Save method should be invoked once with the provided object"
        1 * mockAssetDao.save(asset)
    }
}
