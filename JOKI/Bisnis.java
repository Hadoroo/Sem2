import java.util.Scanner;
import java.util.ArrayList;

public class Bisnis {
    // Daftar Admin
    static Admin[] admins = new Admin[2];

    // Logged Admin
    static Admin admin;

    // Instance "Ayam"
    static Ayam ayam;

    // Instance "Domba"
    static Domba domba;

    // Instance "Sapi"
    static Sapi sapi;

    // Instance "Cengkeh"
    static Cengkeh cengkeh;

    // Instance "Kepala Sawit"
    static KepalaSawit kepalaSawit;

    // Instance of Booster Ayam
    static Medicine boosterAyam;

    // Instance of Booster Sapi
    static Medicine boosterSapi;

    // Instance of Pestisida Cengkeh
    static Medicine pesticideCengkeh;

    // Instance of Booster Kepala Sawit
    static Medicine boosterKepalaSawit;

    // Uang Kas Kontan
    static double cash;

    // Scanner
    static final Scanner Sc = new Scanner(System.in);

    // Helper for Day Iteration
    static int day = 1;

    // Transaction History
    // It's in ArrayList because it will be easier to maintain rather than fixed-size array
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    

    public static void main(String[] args){
        Helper.initialize();
        // Authentication
        boolean isAuthenticated = false;
        String username, password;
        do {
            System.out.println("Selamat datang pada laman login terminal peternakan dan perkebunan sederhana!");
            System.out.printf("Username\t:");
            username = Sc.nextLine();
            System.out.printf("Password\t:");
            password = Sc.nextLine();
            isAuthenticated = Helper.authentication(username, password);
        } while (!isAuthenticated);

        // Menu terminal
        boolean loopMenu = true;
        do {
            lineBreaker();
            System.out.println("Selamat datang pada aplikasi terminal sederhana!");
            System.out.println("Silakan pilih salah satu menu di bawah ini:");
            System.out.println("1. Menampilkan Informasi Peternakan dan Perkebunan");
            System.out.println("2. Membeli Supply");
            System.out.println("3. Perawatan");
            System.out.println("4. Transaction History");
            System.out.println("5. Next Day");
            System.out.println("6. Terminate Program");

            System.out.print("Masukan Anda: ");
            String choice = Sc.nextLine();
            switch (choice) {
                case "1":
                    showFarmInformation();
                    break;

                case "2":
                    supplyMenu();
                    break;
                
                case "3":
                    treatmentMenu();
                    break;
                
                case "4":
                    transactionHistory();
                    break;

                case "5":
                    nextDay();
                    break;

                case "6":
                    loopMenu = false;
                    Sc.close();
                    break;
                default:
                    System.out.println("Sistem menerima masukan yang tidak valid. Harap coba masukan angka yang tertera");
                    break;
            }
        } while (loopMenu);
    }

    // Menu 1
    // This function print a bunch of information for all instances in this farm.
    // As you can see at docs, you will print all of them with format.
    // And don't forget to print the cash per today
    // P.S: you can following the instruction at toString() function in each instances
    public static void showFarmInformation(){
        ayam.toString();
        domba.toString();
        sapi.toString();
        cengkeh.toString();
        kepalaSawit.toString();
        Bisnis.lineBreaker();
        System.out.println(Bisnis.cash);
        Bisnis.lineBreaker();
    }

    // Menu 2
    // This function do a loop while the user does not want to exit
    public static void supplyMenu(){
        lineBreaker();
        // Buying menu
        boolean loopMenuPembelian = true;
        do {
            System.out.println("Selamat datang pada menu pembelian supply. Hari ini, Anda akan membeli apa?");
            System.out.println("1. Lahan Kepala Sawit (Rp. 20.000.000/hektar)");
            System.out.println("2. Lahan Cengkeh (Rp. 15.000.000/hektar)");
            System.out.println("3. Ternak Ayam (Rp. 20.000/ekor)");
            System.out.println("4. Ternak Domba (Rp. 1.000.000/ekor)");
            System.out.println("5. Ternak Sapi (Rp. 2.500.000/ekor)");
            System.out.println("6. Kembali ke menu utama");
            
            System.out.print("Masukan Anda: ");
            String choice = Sc.nextLine();

            switch (choice) {
                case "1":
                    buyingConfirmation("Berapa hektar lahan kepala sawit yang hendak Anda beli?", kepalaSawit);
                    break;

                case "2":
                    buyingConfirmation("Berapa hektar lahan cengkeh yang hendak Anda beli?", cengkeh);
                    break;
                
                case "3":
                    buyingConfirmation("Berapa ekor ternak ayam yang hendak Anda beli?", ayam);
                    break;
                
                case "4":
                    buyingConfirmation("Berapa ekor ternak domba yang hendak Anda beli?", domba);
                    break;

                case "5":
                    buyingConfirmation("Berapa ekor ternak sapi yang hendak Anda beli?", sapi);
                    break;

                case "6":
                    loopMenuPembelian = false;
                    break;
                default:
                    System.out.println("Sistem menerima masukan yang tidak valid. Harap coba masukan angka yang tertera");
                    break;
            }
        } while (loopMenuPembelian);

        
        lineBreaker();
    }

    // Menu 3
    // Same as Menu 2, but this time is for medicine instances only
    public static void treatmentMenu(){
        lineBreaker();
        // Buying menu
        boolean loopMenuPembelian = true;
        do {
            System.out.println("Selamat datang pada menu pembelian supply. Hari ini, Anda akan membeli apa?");
            System.out.println("1. Obat Booster Ayam (Rp. 3.000/ekor)");
            System.out.println("2. Obat Booster Sapi (Rp. 50.000/ekor)");
            System.out.println("3. Pestisida Cengkeh (Rp. 500.000/hektar)");
            System.out.println("4. Pupuk Booster Kepala Sawit (Rp. 1.000.000/hektar)");
            System.out.println("5. Kembali ke menu utama");
            
            System.out.print("Masukan Anda: ");
            String choice = Sc.nextLine();
            switch (choice) {
                case "1":
                    buyingConfirmation("Berapa obat booster ayam yang hendak Anda beli", boosterAyam);
                    break;

                case "2":
                    buyingConfirmation("Berapa obat booster sapi yang hendak Anda beli?", boosterSapi);
                    break;
                
                case "3":
                    buyingConfirmation("Berapa pestisida cengkeh yang hendak Anda beli?", pesticideCengkeh);
                    break;
                
                case "4":
                    buyingConfirmation("Berapa obat booster kepala sawit yang hendak Anda beli?", boosterKepalaSawit);
                    break;

                case "5":
                    loopMenuPembelian = false;
                    break;

                default:
                    System.out.println("Sistem menerima masukan yang tidak valid. Harap coba masukan angka yang tertera");
                    break;
            }
        } while (loopMenuPembelian);
        lineBreaker();
    }

    // Menu 4
    // In this function, you print all of the transaction using a simple iteration.
    // If there are no element in "transactions" ArrayList, then you can simply print something like this "Belum ada daftar transaksi"
    // If there are, do the iteration, and print each of those element
    public static void transactionHistory(){
        // Code here
    }

    // Menu 5
    // In this function, you change the day. What you must do in here is
    // 1. Increment for "day" attribute
    // 2. Add the cash (remember, each day, you have daily profit for each instances in this farm)
    // 3. Reduce drug duration (don't forget, to wear off the effect of medicine)
    // 4. Print a message, something like "Hari telah berganti, dan Anda mendapatkan keuntungan sebanyak Rp. x"
    //    where x is the total of daily profit from all instances
    public static void nextDay(){
        // Code here
    }

    // Belows are some helper function to provide functionality and according to "DRY" (Don't Repeat Yourself) concept
    // P.S: I think these line of codes not placed at the right place. Bonus challenge if you can place it to its "right place".

    // Function to count total of money
    public static double countSpending(double pricePerUnit, double unit){
        // Code here
        return 0.0;
    }

    // Check whether cash is sufficient or not
    public static boolean isCashSufficient(double amount){
        // Code here
        return false;
    }

    // Confirmation function
    // This function used to print a "conversation" to asking whether user want to buy a supply or a medicine
    // Step:
    // 1. Asking how much resource they want. Something like, "berapa hektar tanah yang akan Anda beli?"
    // 2. Check whether the buyer cash is sufficient enough to buy that said resources; If yes, continue to step 3, if not print a message to tell
    //    them if they don't have a cash, then end the transaction
    // 3. Asking for once more if they want to continue the deal. You can use (y/n) confirmation in this case; If y, continue to step 4, if not print a message
    //    and, then end the transaction
    // 4. Substract the cash, and don't forget to add the resources. For example, if you are buying "Booster Ayam" apply that medicine effect to "Ayam" instance
    //    and another example, if you buy 10 "Sapi" don't forget to add those number to "quantity".
    //    And one note, don't forget to "add" the transaction to "transactions" Arraylist. You can use "add" syntax in this case to add newobject
    // 5. End of transaction
    public static void buyingConfirmation(String redaction, Buyable item){
        // Code here
    }

    // This method will be called if you are buying an instances of Medicine. You can check with "instanceof" syntax to make sure what are you buying is
    // an instance of Medicine
    // The logic behind it is, you check one by one the name of medicine, and apply it to their respective instances
    // For example, if you buy "Booster Sapi", then you must call treatment() function in "Sapi" instances
    // P.S: You can use "switch case" syntax to check the medicine name
    public static void applyMedicine(Medicine medicine){
        // Code here
    }

    // Line Breaker
    // This method simply print a line to make the output is easier to read
    public static void lineBreaker(){
        System.out
                .println("==========================================================================================");
    }

}
///
class Admin {
    private String name;
    private String password;

    public Admin(){
        
    }

    // Constructor
    public Admin(String name, String password){
        setName(name);
        setPassword(password);
    }

    // Basic Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Basic Getters

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // To String return a formattet string of admin
    public String toString() {
        return String.format("Name\t\t: %s \n", getName());
    }

    // Is match with Name and Password
    // Method to check whether the name and password is match with the attribut from the instances
    public boolean isMatch(String name, String password){
        return false;
    }
}

class Transaction{
    private String description;
    private double totalPrice;
    private int date;
    private String actor;

    // Zero constructor
    public Transaction(){

    }

    // With params constructor
    public Transaction(String description, double totalPrice, int date, String actor){
        setDescription(description);
        setTotalPrice(totalPrice);
        setDate(date);
        setActor(actor);
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public void setDate(int date){
        this.date = date;
    }

    public void setActor(String actor){
        this.actor = actor;
    }

    public String getDescription(){
        return description;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public int getDate(){
        return date;
    }

    public String getActor(){
        return actor;
    }

    // To String return a formatted string of ayam consisted of
    // Its name, quantitiy, and expese per day (you can get this with "super")
    // Ex:
    //  Description : Booster Ayam
    //  Nominal     : Rp. 1,500,000
    //  Hari Beli   : Hari 6
    //  Pembeli     : Pak Joko
    @Override public String toString(){
        return String.format("Description\t: %s \nNominal\t\t: Rp. %,.2f \nHari Beli\t: Hari %d \nPembeli\t\t: %s \n", getDescription(), getTotalPrice(), getDate(), getActor());
    }
}

class Helper {
    // Helper function to initialize variable that used in runtime environment
    static void initialize(){

        // Code Here
        // P.S: I think something is wrong with Initialize function

        // Initilaize Admin Instances
        Bisnis.admins[0] = new Admin();
        Bisnis.admins[1] = new Admin();

        // Initialize Hewan Instances
        Bisnis.ayam = new Ayam();
        Bisnis.domba = new Domba();
        Bisnis.sapi = new Sapi();

        // Initialize Tanaman Instances
        Bisnis.cengkeh = new Cengkeh();
        Bisnis.kepalaSawit = new KepalaSawit();

        // Initialize Medicine instances
        Bisnis.boosterAyam = new Medicine();
        Bisnis.boosterSapi = new Medicine();
        Bisnis.pesticideCengkeh = new Medicine();
        Bisnis.boosterKepalaSawit = new Medicine();

        // Uang Kas 100000000
        Bisnis.cash = 0;
    }

    // Helper function to authentication
    // PS: Doing an iteration to check one by one admin instances
    static boolean authentication(String username, String password) {
        if (username = getUser)
        return false;
    }

    // PS: You can add new helper function below this comment if you want
}
///

///
interface Buyable{
    public String getName();
    public double getPricePerUnit();
    public void addResources(int resource);
}

interface Treatment{
    public void treatment(Medicine medicine);
    public void reduceDrugDUration();
}
///

///
class Medicine{
    private String name;
    private double price;
    private int duration;

    public String toString(){

    }
    public void reduceDuration(){

    }
    public boolean isInEffect(){

    }
}
///

///
abstract class Tanaman implements Buyable{
    private String name;
    private double area;
    private double expensePerDay; // Harga pengeluaran untuk satu hektar per harinya
    private double pricePerUnit; // Harga per hektar

    // Zero Constructor
    public Tanaman(){

    }

    // Constructor
    public Tanaman(String name, double area, double expensePerDay, double pricePerUnit){
        setName(name);
        setArea(area);
        setExpensePerDay(expensePerDay);
        setPricePerUnit(pricePerUnit);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setArea(double area){
        this.area = area;
    }

    public void setExpensePerDay(double expensePerDay){
        this.expensePerDay = expensePerDay;
    }

    public void setPricePerUnit(double pricePerHectare){
        this.pricePerUnit = pricePerHectare;
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

    public double getExpensePerDay(){
        return expensePerDay;
    }

    public double getPricePerUnit(){
        return pricePerUnit;
    }

    // Method to return the total expense for an animal instance
    // It can be written as following:
    // quantity * expensePerDay
    public double getTotalExpense(){
        // Cone here
        return 0.0;
    }

    // Method to add resource to existing
    // Example, if you buy 1 hectar of Kepala Sawit, then you add it to "area" attribute
    public void addResource(int quantityAdd){
        // Code here
    }

    // To String return a formatted string of hewan consisted of
    // Its name, quantitiy, and expese per day
    // Ex:
    //  Nama        : Cenkgeh
    //  Luas        : 50 hektar
    //  Pengeluaran : Rp. 2.000.000 (per hari)
    @Override public String toString(){
        // Code here
        return "";
    }

    // Abstract Methods
    public abstract double dailySell();
    public abstract double dailyProfit();
}

class Cengkeh extends Tanaman implements Treatment{
    private double resultInKgPerDay;

    private Medicine medicine = new Medicine();

    private double cengkehPrice;

    public Cengkeh(){

    }

    public Cengkeh(double area, double expensePerDay, double resultInKgPerDay, double cengkehPrice, double pricePerUnit){
        super("Cengkeh", area, expensePerDay, pricePerUnit);
        setResultInKgPerDay(resultInKgPerDay);
        setCengkehPrice(cengkehPrice);
    }

    public void setResultInKgPerDay(double resultInKgPerDay){
        this.resultInKgPerDay = resultInKgPerDay;
    }

    public void setCengkehPrice(double cengkehPrice){
        this.cengkehPrice = cengkehPrice;
    }

    public void setMedicine(Medicine medicine){
        // Roundabout way to clone
        Medicine newMedicine = medicine;
        this.medicine = newMedicine;
    }

    public double getResultInKgPerDay(){
        return resultInKgPerDay;
    }

    public double getCengkehPrice(){
        return cengkehPrice;
    }

    public Medicine getMedicine(){
        return medicine;
    }

    // Method to return if "Cengkeh" instance in drug effect (pesticide)
    // PS: If medicine is null, return false. If it exist, return the status from medicine instances
    public boolean alreadyPesticide(){
        // Code here
        return false;
    }

    // Method to return string if it pesticide
    // If this instance is already pesticide, return "Pesticide"
    // If not, return "Normal"
    public String getStatus(){
        // Code here
        return "";
    }

    // Method to return total of daily sell
    // For "Cengkeh" instance, it can be written as following:
    // total of cengkeh per day (of all hectare) * cengkeh price
    public double dailySell(){
        // Code here
        return 0.0;
    }

    // Method to return total of profit for "Cengkeh" instance
    // It can be written as following:
    // the total of daily sell - the total of expense
    public double dailyProfit(){
        // Code here
        return 0.0;
    }

    // Method to apply drug to this instance
    public void treatment(Medicine medicine){
        setMedicine(medicine);
    }

    // Method to apply reduce duration
    public void reduceDrugDuration(){
        if (alreadyPesticide()) {
            this.medicine.reduceDuration();
        }
    }

    // To String return a formatted string of hewan consisted of
    // Its name, quantitiy, and expese per day
    // Ex:
    //  Nama         : Cenkgeh
    //  Luas         : 50 hektar
    //  Pengeluaran  : Rp. 5.000.000 (per hari)
    //  Cengkeh/hari : 10 kg (per hektar)
    //  Harga pasar  : Rp. 30,000 (per kg)
    //  Penjualan    : Rp. 15,000,000 (per hari)
    //  Profit       : Rp. 10,000,000 (per hari)
    //  Status       : Pesticide / Normal
    //  (Status depends whether the instance got medicine or not)
    @Override public String toString(){
        return "";
    }

    @Override
    public void addResources(int resource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addResources'");
    }

    @Override
    public void reduceDrugDUration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reduceDrugDUration'");
    }

    // P.S: As per description at docs, if this instances not in state of "Pesticide", the price of 
    // crops will drop randomly. Bonus challenge if you can define the method
    // For easy solustion, maybe you can try use random function in java
}

class KepalaSawit extends Tanaman implements Treatment{
    private double oilInLitrePerDay;
    private double oilPrice;
    private Medicine medicine;

    public KepalaSawit(){

    }

    public KepalaSawit(double area, double expensePerDay, double oilInLitrePerDay, double oilPrice, double pricePerUnit){
        super("Kepala Sawit", area, expensePerDay, pricePerUnit);
        setOilInLitrePerDay(oilInLitrePerDay);
        setOilPrice(oilPrice);
    }

    public void setOilInLitrePerDay(double oilInLitrePerDay){
        this.oilInLitrePerDay = oilInLitrePerDay;
    }

    public void setOilPrice(double oilPrice){
        this.oilPrice = oilPrice;
    }

    public void setMedicine(Medicine medicine){
        // Roundabout way to clone
        Medicine newMedicine = medicine;
        this.medicine = newMedicine;
    }

    public double getOilInLitrePerDay(){
        return isFertilized()? 1.25 * oilInLitrePerDay : oilInLitrePerDay;
    }

    public double getOilPrice(){
        return oilPrice;
    }

    public Medicine getMedicine(){
        return medicine;
    }

    // Method to return if "Kepala Sawit" instance in drug effect (booster)
    // PS: If medicine is null, return false. If it exist, return the status from medicine instances
    public boolean isFertilized(){
        // Code here
        return false;
    }

    // Method to return string if it fertilized
    // In this case, if this instance is fertilized, return "Fertilized"
    // If not, return "Normal"
    public String getStatus(){
        // Code here
        return "";
    }

    // Method to return total of daily sell
    // For "Kepala Sawit" instance, it can be written as following:
    // the total of palm oil (of all hectare) * palm oil price
    public double dailySell(){
        // Code here
        return 0.0;
    }

    // Method to return total of profit for "Cengkeh" instance
    // It can be written as following:
    // total of cengkeh per day (of all hectare) * cengkeh price
    public double dailyProfit(){
        // Code here
        return 0.0;
    }

    // Method to apply drug to this instance
    public void treatment(Medicine medicine){
        setMedicine(medicine);
    }

    // Method to apply reduce duration
    public void reduceDrugDuration(){
        if (isFertilized()) {
            this.medicine.reduceDuration();
        }
    }

    // To String return a formatted string of hewan consisted of
    // Its name, quantitiy, and expese per day
    // Ex:
    //  Nama         : Kepala Sawit
    //  Luas         : 40 hektar
    //  Pengeluaran  : Rp. 8.000.000 (per hari)
    //  Minyak/hari  : 25 liter (per hektar)
    //  Harga pasar  : Rp. 25,000 (per kg)
    //  Penjualan    : Rp. 25,000,000 (per hari)
    //  Profit       : Rp. 17,000,000 (per hari)
    //  Status       : Fertilized / Normal
    //  (Status depends whether the instance got medicine or not)
    @Override public String toString(){
        // Code here
        return "";
    }

    @Override
    public void addResources(int resource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addResources'");
    }

    @Override
    public void reduceDrugDUration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reduceDrugDUration'");
    }
}
///

///
abstract class Hewan implements Buyable{
    private String name;
    private int quantity;
    private double expensePerDay;
    private double pricePerUnit;

    // Zero Constructor
    public Hewan(){

    }

    // Constructor
    public Hewan(String name, int quantity, double expensePerDay, double pricePerUnit){
        setName(name);
        setQuantity(quantity);
        setExpensePerDay(expensePerDay);
        setPricePerUnit(pricePerUnit);
    }


    // Setter Getter
    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setExpensePerDay(double expensePerDay){
        this.expensePerDay = expensePerDay;
    }

    public void setPricePerUnit(double pricePerUnit){
        this.pricePerUnit = pricePerUnit;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getExpensePerDay(){
        return expensePerDay;
    }

    public double getPricePerUnit(){
        return pricePerUnit;
    }

    // Method to return the total expense for an animal instance
    // It can be written as following:
    // quantity * expensePerDay
    public double getTotalExpense(){
        // Code in here
        return 0.0;
    }

    // Method to add resource to existing
    // Example, if you buy 1 chicken, then you add it to "quantity" attribute
    public void addResource(int quantityAdd){
        // Code here
    }

    // To String return a formatted string of hewan consisted of
    // Its name, quantitiy, and expese per day
    // Ex:
    //  Nama        : Ayam
    //  Jumlah      : 500 ekor
    //  Pengeluaran : Rp. 500,000 (per hari)
    // Take Note: "Pengeluaran" is the value of total expense of the day, you can use getTotalExpense() method for this
    @Override public String toString(){
        // Code here
        return "";
    }


    // Abstract Methods
    public abstract double dailySell();
    public abstract double dailyProfit();
}

class Ayam extends Hewan implements Treatment {
    private int eggPerDay; // Telur yang dihasilkan oleh satu ayam
    private double eggPrice; // Harga satu butir telur
    private Medicine medicine;

    public Ayam(){

    }

    public Ayam(int quantitiy, double expensePerDay, int eggPerDay, double eggPrice, double pricePerUnit){
        super("Ayam", quantitiy, expensePerDay, pricePerUnit);
        setEggPerDay(eggPerDay);
        setEggPrice(eggPrice);
    }


    public void setEggPerDay(int eggPerDay){
        this.eggPerDay = eggPerDay;
    }

    public void setEggPrice(double eggPrice){
        this.eggPrice = eggPrice;
    }

    public void setMedicine(Medicine medicine){
        // Roundabout way to clone
        Medicine newMedicine = medicine;
        this.medicine = newMedicine;
    }

    public int getEggPerDay(){
        return isBoosted()? 2 * eggPerDay : eggPerDay;
    }

    public double getEggPrice(){
        return eggPrice;
    }

    public Medicine getMedicine(){
        return medicine;
    }

    // Method to return total of daily sell
    // For "Ayam" instance, it can be written as following:
    // the total of egg per day (of all chickens) * the price of per egg
    public double dailySell(){
        // Code here
        return 0.0;
    }

    // Method to return total of profit for "Ayam" instance
    // It can be written as following:
    // the total of daily sell - the total of expense
    public double dailyProfit(){
        // Code here
        return 0.0;
    }

    // Method to return if "Ayam" instance in drug effect (booster)
    // PS: If medicine is null, return false. If it exist, return the status from medicine instances
    public boolean isBoosted(){
        // Code here
        return false;
    }

    // Method to return string if it boosted
    // In this case, if this instance is boosted return "Booster"
    // If not, return "Normal"
    public String getStatus(){
        // Code here
        return "";
    }

    // Method to apply drug to this instance
    public void treatment(Medicine medicine){
        setMedicine(medicine);
    }

    // Method to apply reduce duration
    public void reduceDrugDuration(){
        if (isBoosted()) {
            this.medicine.reduceDuration();
        }
    }

    // To String return a formatted string of ayam consisted of
    // Its name, quantitiy, and expese per day (you can get this with "super")
    // Ex:
    //  Nama        : Ayam
    //  Jumlah      : 500 ekor
    //  Pengeluaran : Rp. 500,000 (per hari)
    //  Telur/hari  : 3 butir (per ekor)
    //  Harga telur : Rp. 3,000 (per butir)
    //  Penjualan   : Rp. 4,500,000 (per hari)
    //  Profit      : Rp. 4,000,000 (per hari)
    //  Status      : Boosted / Normal
    //  (Status depends whether the instance got medicine or not)
    @Override public String toString(){
        System.out.println("Nama\t\t: Ayam");
        System.out.println("Jumlah\t\t: " + getQuantity() + " ekor");
        System.out.println("Pengeluaran\t: Rp. " + getExpensePerDay() + "(per hari)");
        System.out.println("Telur/hari\t: " + getEggPerDay() + " butir (per ekor)");
        return "";
    }

    @Override
    public void addResources(int resource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addResources'");
    }

    @Override
    public void reduceDrugDUration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reduceDrugDUration'");
    }
}

class Domba extends Hewan implements Treatment {
    private double woolInKgPerDay;
    private double woolPrice; // Harga satu kg wool

    public Domba(){

    }

    public Domba(int quantitiy, double expensePerDay, double woolInKgPerDay, double woolPrice, double pricePerUnit){
        super("Domba", quantitiy, expensePerDay, pricePerUnit);
        setWoolInKgPerDay(woolInKgPerDay);
        setWoolPrice(woolPrice);
    }

    public void setWoolInKgPerDay(double woolInKgPerDay){
        this.woolInKgPerDay = woolInKgPerDay;
    }

    public void setWoolPrice(double woolPrice){
        this.woolPrice = woolPrice;
    }

    public double getWoolInKgPerDay(){
        return woolInKgPerDay;    
    }

    public double getWoolPrice(){
        return woolPrice;
    }

    // Method to return total of daily sell
    // For "Domba" instance, it can be written as following:
    // the total of wool per day (of all sheeps) * wool price
    public double dailySell(){
        // Code here
        return 0.0;
    }

    // Method to return total of profit for "Domba" instance
    // It can be written as following:
    // the total of daily sell - the total of expense
    public double dailyProfit(){
        // Code here
        return 0.0;
    }

    // To String return a formatted string of Domba consisted of
    // Its name, quantitiy, and expese per day (you can get this with "super")
    // Ex:
    //  Nama        : Domba
    //  Jumlah      : 100 ekor
    //  Pengeluaran : Rp. 1.000.000 (per hari)
    //  Wool/hari   : 2,5 kg (per ekor)
    //  Harga wool  : Rp. 10,000 (per kg)
    //  Penjualan   : Rp. 2,500,000 (per hari)
    //  Profit      : Rp. 1,500,000 (per hari)
    @Override public String toString(){
        // Code here
        return "";
    }

    @Override
    public void addResources(int resource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addResources'");
    }

    @Override
    public void treatment(Medicine medicine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'treatment'");
    }

    @Override
    public void reduceDrugDUration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reduceDrugDUration'");
    }
}

class Sapi extends Hewan implements Treatment{
    private double milkInLiterPerDay;
    private double milkPrice;
    private Medicine medicine;

    public Sapi(){

    }

    public Sapi(int quantitiy, double expensePerDay, double milkInLiterPerDay, double milkPrice, double pricePerUnit){
        super("Sapi", quantitiy, expensePerDay, pricePerUnit);
        this.milkInLiterPerDay = milkInLiterPerDay;
        this.milkPrice = milkPrice;
    }

    public void setMilkInLiterPerDay(double milkInLiterPerDay){
        this.milkInLiterPerDay = milkInLiterPerDay;
    }

    public void setMedicine(Medicine medicine){
        // Roundabout way to clone
        Medicine newMedicine = medicine;
        this.medicine = newMedicine;
    }

    public void setMilkPrice(double milkPrice){
        this.milkPrice = milkPrice;
    }

    public double getMilkInLitrePerDay(){
        return isBoosted()? 1.5 * milkInLiterPerDay : milkInLiterPerDay;
    }

    public double getMilkPrice(){
        return milkPrice;
    }

    public Medicine getMedicine(){
        return medicine;
    }

    // Method to return if "Sapi" instance in drug effect (booster)
    // PS: If medicine is null, return false. If it exist, return the status from medicine instances
    public boolean isBoosted(){
        // Code here
        return false;
    }

    // Method to return string if it boosted
    // In this case, if this instance is boosted return "Booster"
    // If not, return "Normal"
    public String getStatus(){
        // Code here
        return "";
    }

    // Method to return total of daily sell
    // For "Sapi" instance, it can be written as following:
    // the total milk in litre in day (of all cows) * milkPrice
    public double dailySell(){
        return 0.0;
    }

    // Method to return total of profit for "Sapi" instance
    // It can be written as following:
    // the total of daily sell - the total of expense
    public double dailyProfit(){
        return 0.0;
    }

    // Method to apply drug to this instance
    public void treatment(Medicine medicine){
        setMedicine(medicine);
    }

    // Method to apply reduce duration
    public void reduceDrugDuration(){
        if (isBoosted()) {
            this.medicine.reduceDuration();
        }
    }

    // To String return a formatted string of Sapi consisted of
    // Its name, quantitiy, and expese per day (you can get this with "super")
    // Ex:
    //  Nama        : Sapi
    //  Jumlah      : 50 ekor
    //  Pengeluaran : Rp. 4,000,000 (per hari)
    //  Susu/hari   : 7.5 liter (per ekor)
    //  Harga susu  : Rp. 25,000 (per liter)
    //  Penjualan   : Rp. 9,375,000  (per hari)
    //  Profit      : Rp. 5,375,000 (per hari)
    //  Status      : Boosted / Normal
    //  (Status depends whether the instance got medicine or not)
    @Override public String toString(){
        // Code Here
        return "";
    }

    @Override
    public void addResources(int resource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addResources'");
    }

    @Override
    public void reduceDrugDUration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reduceDrugDUration'");
    }
}
///
