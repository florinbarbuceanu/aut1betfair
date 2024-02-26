console.log("Hello Javascript");

/* declaration of 
variables */
var x;
x="ana are mere";
console.log(x)

x=1234;
console.log(x);

// declation of constant
const a="ana are mere";
// a=1245; - cannot update content of constant

// let declaration
let y="test let";
console.log(y);

y=789;
console.log(y);

// types of variables
// numbers
let n = 22;
let b = 22.345678;
let h = 22e9;
let m=0b11;
let k=0x10;


console.log(n,b,h,m,k);

//string
var firstName="Florin";
var lastName ="Popescu";

console.log(firstName+" "+lastName);

// boolean
var isRanining=true;
var isHaveMoneyInAccount=false;

if(isRanining){
    console.log("Take an umbrela");
}


//type of operators
// arithmetic operators
console.log("Arithmetic operators");
console.log(2+3);
console.log(2-1);
console.log(4*4);
console.log(4/3);
console.log(4%3);

console.log("Setting values to a variable:")
var nr=10;
var isEven= !(nr%2 === 0);
console.log(isEven);
console.log(!isEven)

// comparators
console.log("Comparators")
console.log(2 == '2'); //compare only values as string
console.log(2 === '2');//compare type and values

console.log(2>3);
console.log(5<=5);
console.log(2>=4);

console.log(3 != '3')

// logic operators
console.log("Logic operators")
console.log(true || false);

console.log(false && true);

// typeof
var ana;
var nr1 = (0/0);
console.log("Type OF:")
console.log(typeof a, typeof isEven, typeof firstName, typeof k, typeof ana);
console.log(nr1, typeof nr1);

const maxNumber = Math.pow(10,10000000000);
console.log(maxNumber, typeof maxNumber)
console.log(Math.log(0));
console.log(-1/0);

var elem=null;
console.log(typeof elem);

// ternary operators
var age=10;
var canDrive= age>18;
var canDriveMessage= canDrive ? 'can drive' : 'cannot drive';

console.log(canDriveMessage);

// control structure
// if if-else if-elseif-else if(if)-else
 if (canDrive === true){
    console.log("Can user drive");
 } else {
    console.log("Cannot drive");
 }

// switch
const one=true;

switch (one) {
    case '1':
        console.log("One is string");
        break;
    case true:
        console.log("One is boolean true");
        break;
    case 1:
        console.log("One is number");
        break;
    default:
        console.log("Undefiend type");
        break;
}


// console.log working with variables
const num1= 6;
const num2 = 5;
console.log(`${num1 } is ${num1 > num2 ? 'greater' : 'smaller'} than ${num2}`);
console.log(num1+" is "+ (num1 > num2 ? 'greater' : 'smaller')+ " than "+ num2);
