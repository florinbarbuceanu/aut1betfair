class Car {
    // static variables
    static baseStaticField = "baseStaticField";
    // private values
    #model;
    #engineSize;

    // constructor
    constructor(make, model, year, engineSize) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.#engineSize = engineSize;
    }

    getModel() {
        return this.model;
    }

    #startEngine() {
        console.log("Start engine");
    }

    getEngineSize() {
        return this.#engineSize;
    }

    setEngineSize(newSize) {
        this.#engineSize = newSize;
    }

    start() {
        this.#startEngine();
        console.log("Enter to shift 1");
        console.log("Car started");
    }

    static baseStaticMethod() {
        return "I am a static method";
    }
}

// inheritance
class Truk extends Car {

    //overwritting
    start() {
        console.log("Start truk");
    }
    
    //overwritting as overload is not workign in JS
    start(shift) {
        if (arguments.length > 0)
            console.log("Start truk with shift:" + shift);
        else
            console.log("Start truk");
    }
}

const myCar = new Car("Dacia", "Logan", 2023, 1.0);
const myBMW = new Car("BMW", "X5", 2020, 2.0);

console.log(myCar.getModel());
myCar.color = 'red';
console.log(myCar.color);
console.log(myBMW.color);
console.log(myBMW.model);

// myCar.#startEngine();
//console.log(myCar.#engineSize);
console.log(myCar.getEngineSize());
myCar.setEngineSize(3.5);
console.log(myCar.getEngineSize());
myCar.start();

// myCar.baseStaticField="Change this field";
console.log(myCar.baseStaticField);
console.log(myBMW.baseStaticField);
console.log(Car.baseStaticField);
console.log(Car.baseStaticMethod());

const myTruk = new Truk("MAN", "x66", 2020, 5.5);
myTruk.start();
myTruk.start(5);
console.log(myTruk.getEngineSize());
