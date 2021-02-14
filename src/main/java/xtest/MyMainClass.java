package xtest;

class MyMainClass {
    // My main class
    public static void main(String[] args) {
        Programmer myVariable = new Programmer();
        System.out.println("My salary is " + myVariable.salary);
        System.out.println("My bonus is " + myVariable.bonus);
    }
}

class Employee {
    float salary = 100; // property of the parent class
}

// child class
class Programmer extends Employee {
    float bonus = 30;
}


