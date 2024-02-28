function IsPositive(number){
    if(number>0)
        return true;
    else
        return false;
}

function checkNumber(numberToBeVerified){
    if(IsPositive(numberToBeVerified)){
        console.log("S-a introdus o valoare positiva");
    } else {
        console.log("S-a introdus o valoare negativa");
    }
}

function divide(x,y){
    if(y===0)   {
        console.log("Operatie imposibilia, impartitorul este 0");
    } else {
        return x/y;
    }
    return null;
}

// optional params
function add(a,b=0,c=0){
    return a+b+c;
}

// params as list on js
function multiplication(a,b){
    console.log(arguments)
    if(arguments.length>2)
        return a*b*arguments[2]*arguments[3];
    else
        return a*b;
}


var nr=100;
checkNumber(nr);
checkNumber(-12);
var a = divide(3,0);
console.log(a)

// optional params
console.log(add(2))
console.log(add(2,3,4))

// params as list
console.log(multiplication(1,2,3,4));

// function expresion
const addiction = function (a , b ){
   const sum = a + b;
    return sum;
};
console.log("Expresion function:"+addiction(2,3));

// arrow function
const addArrow = (a,b) => a+b;
console.log("Arrow function:"+addArrow(9,3));

// callback function
function onlyPositive(a,b, funcName){
    if(IsPositive(a)&&IsPositive(b)){
       return funcName(a,b);
    }
    return null;
}

console.log("Callback function(add)"+onlyPositive(2,3,add));
console.log("Callback function(multiplication):"+onlyPositive(2,3,multiplication));

// arrays
console.log("Arrays:")
const animals = ["cat","dog","lion","parrot"];
const mixedList =[1,2,3,"dog","cat"]

console.log(animals[2]);
console.log("Number of animals:"+animals.length)
animals.push("mouse");
console.log(animals);
animals.pop(1);
console.log(animals);
animals.splice(2,0,"test");
console.log(animals);
animals.splice(0,1);
console.log(animals);

// interation over arrays
console.log("Iterate over array with while:")
var i=0;
while(i<mixedList.length){
    const elem=mixedList[i];
    console.log("Element value:"+elem+" type of elem:"+ typeof elem);
    i++;
}

console.log("Iterate over array with do while")
i=0;

do{
    const elem=mixedList[i];
    console.log("Element value:"+elem+" type of elem:"+ typeof elem);
    i++;
} while (i<mixedList.length);

// iterate with for
console.log("Iterate over list with for:")
for(let i=0;i<mixedList.length;i++){
    const elem=mixedList[i];
    console.log("Element value:"+elem+" type of elem:"+ typeof elem);
}

// iterate with foreach
for(const animal of animals){
    console.log(animal);
}
