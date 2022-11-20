import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
    static ArrayList<Inventory> Items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private String Name, serialNum;
    private int Value;

    public Inventory(String Name, String serialNum, int Value){
        this.Name = Name;
        this.serialNum = serialNum;
        this.Value = Value;
    }

    public String getName(){
        return Name;
    }
    public String getSerialNum(){
        return serialNum;
    }
    public int getValue(){
        return Value;
    }
    public void setName(String Name){
        this.Name = Name;
    }

    public void setValue(int Value){
        this.Value = Value;
    }
    public static void addItem(){
        System.out.println("Enter the name: ");
        String Name = sc.next();
        System.out.println("Enter the serial number: ");
        String serialNum = sc.next();
        System.out.println("Enter the value in dollars (whole number): ");
        int Value = sc.nextInt();
        //saves input into ArrayList
        Inventory item = new Inventory(Name, serialNum, Value);
        Items.add(item);
    }
    //method for deleting the item
    public static void deleteItem(){
        System.out.println("Enter the serial number of the item to delete: ");
        String serialNum = sc.next();
        Items.removeIf(i -> i.getSerialNum().contains(serialNum));
    }
    //method for updating the item
    public static void updateItem(){
        System.out.println("Enter the serial number of the item to change: ");
        String serialNum = sc.next();
        for(Inventory i:Items){
            if(i.getSerialNum().contains(serialNum)){
                System.out.println("Enter the new name: ");
                String Name = sc.next();
                System.out.println("Enter the new value in dollars (whole number): ");
                int Value = sc.nextInt();
                i.setName(Name);
                i.setValue(Value);
            }
        }
    }
    //method for showing all items the user input
    public static void showItems(){
        for(Inventory i:Items){
            System.out.println(
                i.getName() + ","
              + i.getSerialNum() + ","
              + i.getValue());
        }
    }


}

class Main {
    public static void main(String[] args) {
        int userInput;
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print(
                    "Press 1 to add an item.\n" 
                  + "Press 2 to delete an item.\n"
                  + "Press 3 to update an item.\n"
                  + "Press 4 to show all the items.\n"
                  + "Press 5 to quit the program.");
            userInput = Integer.parseInt(input.nextLine());
            switch (userInput) {
                case 1:
                    Inventory.addItem();
                    break;
                case 2:
                    Inventory.deleteItem();
                    break;
                case 3:
                    Inventory.updateItem();
                    break;
                case 4:
                    Inventory.showItems();
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }
}