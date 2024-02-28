

* Implement the 'delete' method for the `ContainerController`
* Add an optional filter to the `list` method of `ContainerController` to filter by status
* Implement the logic for loading an Asset into a Container
* Add an `orientation` attribute to a `Container`
    * The orientation is used to determine which way a Container is facing, as a Container has a defined 'forwards' and 'backward'
* Add an `inventoryOrientation` attribute to the `Container` and the logic to set this value
    * The `inventoryOrientation` will be defined by the first asset being loaded
    * The inventory will always be loaded from the back into the first position, 
        * e.g. if a Container is facing forwards, the assets will be loaded front-facing into the container from its back, and the `inventoryOrientation` will therefore be forwards too.
        * OR if the Container is facing backwards, the assets will be loaded front-facing into the container from its front, thus the `inventoryOrientation` will be backwards
* Modify the get methods for Container to return a comma-separated String of Identifiers for any inventory loaded
