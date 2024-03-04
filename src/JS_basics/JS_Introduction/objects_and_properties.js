var elev = {
    nume: "Popescu",
    prenume: "Ion",
    medie: 9.85,
};

console.log("Nume:" + elev.nume + ", prenume:" + elev['prenume']);
console.log(elev.medie)

// nested objects
const myHonda = {
    color: 'red',
    wheels: 4,
    engine: {
        cylinders: 4,
        size: 2.0,
        fuel: "gas",
    },
};

console.log(myHonda.engine.cylinders);

// seting new values
myHonda.color = "green";
console.log("New color:" + myHonda.color);

myHonda.engine.fuel = "gas/gpl";
console.log(myHonda.engine.fuel);

// adding methodes 
const book = {
    author: "Ion Creanga",
    title: "Amintiri din Copilarie",
    
    getTitle: function(){
        return this.title;
    },

    // java style
    getAuthor(){
        return this.author;
    }
};

console.log(book.getTitle());
console.log(book.getAuthor());

//delete obj property
delete book.author; 
console.log("author" in book);
// add property
book.numeAuthor="Ion Creanga";
console.log(book.numeAuthor);

//constructors
function Person(name,age,sex){
    this.name=name;
    this.age=age;
    this.sex=sex;
}
// instantiate obj
const person1= new Person("Vasile",12, "Male");
const person2= new Person("Ioana",25,"Female");
console.log(person1);

// add methods to a define class
Person.prototype.displayName = function(){
    return this.name;
}

console.log(person2.displayName());

// another way to create methodes
const Manager = {
    name: "Karina",
    age: 50,
    job: "Engineer",
};

const InternalWorker={
    name : "Marian",
    age: 21,
    job: "Internal Tester",
}

function sayHello(){
    console.log("My name is:"+ this.name);
}

//add method to objects
Manager.sayHello=sayHello;
InternalWorker.sayHello = sayHello; 

Manager.sayHello();
InternalWorker.sayHello();