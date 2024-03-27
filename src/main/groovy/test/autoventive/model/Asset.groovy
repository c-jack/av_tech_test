package test.autoventive.model

import test.autoventive.enums.AssetType

/**
 * Represents an Asset (e.g. a vehicle or other item to be shipped)
 */
class Asset {

    /**
     * The unique reference for an asset
     */
    String identifier

    /**
     * The type of Asset
     */
    AssetType assetType

    /**
     * The Identifier of the container that the asset is loaded on
     * (OR null if not loaded)
     */
    String containerId
}
