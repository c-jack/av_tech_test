package test.autoventive.controller

import spock.lang.Specification
import test.autoventive.dao.ContainerDao
import test.autoventive.enums.Status
import test.autoventive.model.Container

/**
 * Unit Tests for {@link ContainerController}
 */
class ContainerControllerTest extends Specification {

    /**
     * Instance of class-under-test
     */
    private ContainerController controller

    // Spock Mocks
    private ContainerDao mockContainerDao

    /**
     * Pre-test setup
     */
    void setup() {
        mockContainerDao = Mock(ContainerDao)
        controller = new ContainerController(containerDao: mockContainerDao)
    }

    /**
    * Test for {@link ContainerController#list}
    */
    def "list should return all persisted Containers"() {
        given: "I create two distinct containers with different statuses"
        def container1 = new Container(identifier: "Container1", capacity: 10, status: Status.AVAILABLE)
        def container2 = new Container(identifier: "Container2", capacity: 10, status: Status.OUT_OF_SERVICE)

        and: "I stub the getAll DAO method to return the containers"
        mockContainerDao.getAll() >> [container1, container2]

        expect: "list to return all containers when no status is provided"
        controller.list(null) == [container1, container2]

        and: "I stub the getAll DAO method to return only containers with status AVAILABLE"
        mockContainerDao.getAll() >> [container1]

        expect: "list to return containers with status AVAILABLE when status AVAILABLE is provided"
        controller.list(Status.AVAILABLE) == [container1]

        and: "I stub the getAll DAO method to return only containers with status OUT_OF_SERVICE"
        mockContainerDao.getAll() >> [container2]

        expect: "list to return containers with status OUT_OF_SERVICE when status OUT_OF_SERVICE is provided"
        controller.list(Status.OUT_OF_SERVICE) == [container2]
    }

    /**
     * Test for {@link ContainerController#get}
     *
     * This method currently has no validation of the provided string, so we expect all variants of String to work
     */
    def "get should return the result of the DAO getByIdentifier method"() {
        given: "I create a container"
        def container = new Container(identifier: "Container1", capacity: 10, status: Status.AVAILABLE)

        and: "I stub the container to be returned from the DAO getByIdentifier method"
        1 * mockContainerDao.getByIdentifier(identifier) >> container

        expect: "list to return the value retrieved from the DAO"
        controller.get(identifier) == container

        where: "The identifier can be any value"
        identifier << ["Container1", "Container2", "", null]

    }

    /**
     * Test for {@link ContainerController#create}
     */
    def "get should return the result of the DAO getByIdentifier method"() {
        given: "I create a new container"
        def container = new Container(identifier: "NewContainer", capacity: 123, status: Status.AVAILABLE)

        when: "The Container is passed to the create method"
        controller.create(container)

        then: "The DAO Save method should be invoked once with the provided object"
        1 * mockContainerDao.save(container)
    }

    /**
     * Test for {@link ContainerController#delete}
     */
    def "delete should delete the container when it exists"() {
        given: "a container with the specified identifier exists"
        def identifier = "Container"
        

        when: "delete method is called with the existing identifier"
        controller.delete(identifier)

        then: "The DAO Delete method should be invoked once with the provided object"
        1 * mockContainerDao.delete(identifier)
    }
}
