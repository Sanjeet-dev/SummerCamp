package HandsOn1;

class T1H1_25lmcs1008 {
    static class Vehicle{

        // encapsulation of data members
        private String registrationNumber;
        private double baseRatePerDay;
        
        // constructor to initialize the data members
        public Vehicle(String registrationNumber, double baseRatePerDay) {
            this.registrationNumber = registrationNumber;
            this.baseRatePerDay = baseRatePerDay;
        }

        // getter and setter methods to access the private data members in subclasses

        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public void setBaseRatePerDay(double baseRatePerDay) {
            this.baseRatePerDay = baseRatePerDay;
        }

        public String getRegistrationNumber(){
            return registrationNumber;
        }
        public double getBaseRatePerDay(){
            return baseRatePerDay;
        }

        // default method to calculate rental cost based on number of days
        public double calculateRentalCost(int days){
            return baseRatePerDay*days;
        }
    }
    static class Car extends Vehicle{

        // additional function check in car class to check if the car has AC or not
        private boolean hasAC;

        public Car(String registrationNumber, double baseRatePerDay, boolean hasAC){
            super(registrationNumber, baseRatePerDay);
            this.hasAC = hasAC;
        }
        @Override
        public double calculateRentalCost(int days){
            double total = super.calculateRentalCost(days);
            int luxuryFee = 15;
            if(hasAC){
                total = total + luxuryFee*days;
            }
            return total;
        }

    }
    static class Truck extends Vehicle{
        public Truck(String registrationNumber, double baseRatePerDay){
            super(registrationNumber, baseRatePerDay);
        }
        @Override
        public double calculateRentalCost(int days){
            double total = super.calculateRentalCost(days);
            int heavyDutyTax = 50;
            total += heavyDutyTax;
            return total;
        }

    }
    public static void main(String[] args){
        Vehicle vehicle1  = new Vehicle("ABC123", 100.0);
        System.out.println("Vehicle rental for 3 days: $" + vehicle1.calculateRentalCost(3));

        Car car1 = new Car("NYC1256", 200.0, true);
        System.out.println("Car for 3 days: $" + car1.calculateRentalCost(3));
        
        Truck truck1 = new Truck("TRK900", 300.0);
        System.out.println("Truck for 2 days: $" + truck1.calculateRentalCost(2));

        // demonstrate getters/setters
        car1.setRegistrationNumber("NYC777");
        car1.setBaseRatePerDay(220.0);
        System.out.println("Updated car (2 days): $" + car1.calculateRentalCost(2));
    }
    
}
