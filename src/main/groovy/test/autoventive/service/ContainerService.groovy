package test.autoventive.service

import test.autoventive.dao.BaseDao
import test.autoventive.dao.ContainerDao
import test.autoventive.enums.Status
import test.autoventive.model.Container
import test.autoventive.enums.Orientation
import test.autoventive.model.Asset

/**
 * Service layer for the container
 */
class ContainerService implements Service {

    ContainerDao containerDao

    AssetService assetService


    boolean hasRoom(String c) {
        // get the container using the identifier
        Container c2 = containerDao.getByIdentifier(c)

        // so this bit will get the inventory already loaded onto the inventory so we can see what is already loaded
        def assetl = assetService.getLoadedAssets(c2.identifier)

        // get the capacity for a container
        def cap = c2.capacity
        // get the total permissable capacity
        def n = assetl.size()

        // does the capacity have more items than the capacity of the container has stored
        boolean b = n+1 == cap || !(n==cap)

        return b
    }

    void loadAssetOnToContainer(String containerIdentifier, Asset asset) {

        Container container = containerDao.getByIdentifier(containerIdentifier)

        setInventoryOrientationIfFirstAsset(container, asset)

        asset.setContainerId(container.identifier)
    }

    void setInventoryOrientationIfFirstAsset(Container container, Asset asset){

        if(isContainerEmpty(container)){
            setInventoryOrientation(container,asset)
        }
    }

    boolean isContainerEmpty(Container container) {
        // so this bit will get the inventory already loaded onto the inventory
        def assetl = assetService.getLoadedAssets(container.identifier)

        // check if there are any assets already loaded
        return assetl.size() == 0
    }


    void setInventoryOrientation (Container container, Asset asset){
        if((container.orientation == Orientation.BACKWARD && asset.orientation == Orientation.FORWARD)
                || (container.orientation == Orientation.FORWARD && asset.orientation == Orientation.BACKWARD)){
            container.inventoryOrientation = container.orientation
        } else if (container.orientation == Orientation.BACKWARD && asset.orientation == Orientation.BACKWARD){
            container.inventoryOrientation = Orientation.BACKWARD
        } else if (container.orientation == Orientation.FORWARD && asset.orientation == Orientation.FORWARD){
            container.inventoryOrientation = Orientation.FORWARD
        }
    }

    @Override
    BaseDao getDao() {
        return this.containerDao
    }

    List<Container> getContainersByStatus(Status status) {
        return containerDao.getContainersByStatus(status)
    }

}
