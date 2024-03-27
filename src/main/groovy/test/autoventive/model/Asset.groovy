package test.autoventive.model

import test.autoventive.enums.AssetType
import test.autoventive.enums.Orientation

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

    /**
     * The orientation of the asset
     */
    Orientation orientation
}
