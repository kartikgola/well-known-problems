enum VehicleType
    Car
    Motorcycle

interface Vehicle
    number
    model
    color
    park()

abstract class Vehicle

class Car
    park()

class Motorcycle
    park()

class ParkingLot <- Main class
    MAX_LEVELS
    levels[]
    isFull()
    isEmpty()
    findSpot()
    assignSpot()
    main()

class Level
    number
    MAX_SPOTS
    
enum SpotType
    Car
    Motorcycle

interface Spot
    isOccupied
    vehicle
    freeSpot()
    occupySpot()

class CarSpot
    freeSpot()
    occupySpot()

class MotorcycleSpot
    freeSpot()
    occupySpot()