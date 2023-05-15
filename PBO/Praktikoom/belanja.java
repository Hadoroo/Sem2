import java.text.DecimalFormat;

public class belanja {
    public static void main(String[] args) {
        Employee emp = new Employee(112233, "Adi", 2000000);
        emp.buyItem("pocari", 2, 5000);
        emp.buyItem("poca", 3, 2000);
        emp.buyItem("poi", 1, 4000);
        emp.employeeProfile();
    }
}

class Invoice implements Payable{
    public String prodName;
    public int quantity;
    public int price;

    public Invoice(String prodName, int quantity, int price) {
        this.prodName = prodName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getPayableAmount(){
        return 0;
    }

}

class Employee implements Payable{
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
    public int regNum;
    public String name;
    public int salary;
    public Invoice[] invoices = new Invoice[20];
    public int i = 0;
    public int totalPrice;
    public int totalSalary;

    public int getPayableAmount(){
        return totalSalary = salary - totalPrice;
    }

    public Employee(int regNum, String name, int salary){
        this.regNum = regNum;
        this.name = name;
        this.salary = salary;
    }

    public void buyItem(String prodName, int quantity, int price){
        Invoice invoice = new Invoice(prodName, quantity, price);
        invoices[i] = invoice;
        i++;
        totalPrice += quantity * price;
    }

    public void employeeProfile(){
        System.out.println("========================================================");
        System.out.println("\t\t    DATA KARYAWAN");
        System.out.println("========================================================");
        System.out.println("Nama\t\t: " + name);
        System.out.println("Nomor Registrasi: " + regNum);
        System.out.println("Gaji\t\t: Rp." + decimalFormat.format(salary));
        System.out.println();
        System.out.println("========================================================");
        System.out.println("Nama Barang\tHarga Per Barang\tBanyak Pembelian");
        for (int i = 0; i < invoices.length; i++){
            if (invoices[i] != null){
                System.out.println(invoices[i].prodName + "\t\t" + invoices[i].quantity + "\t\t\tRp." + decimalFormat.format(invoices[i].price));

            }
        }
        System.out.println("========================================================");
        System.out.println("Banyaknya Invoice\t: Rp." + decimalFormat.format(totalPrice));
        System.out.println("Total Gaji Bersih\t: Rp."+ decimalFormat.format(getPayableAmount()));
        
    }
}

interface Payable{
    public int getPayableAmount();
}
