import java.util.ArrayList;
import java.util.Scanner;

class Inventory {

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
}

class Main {
    static ArrayList<Inventory> Items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int userInput;
    public static void main(String[] args) {
        while(true){
            System.out.println(
                    "Press 1 to add an item.\n"
                  + "Press 2 to delete an item.\n"
                  + "Press 3 to update an item.\n"
                  + "Press 4 to show all the items.\n"
                  + "Press 5 to quit the program.");
            userInput = Integer.parseInt(sc.nextLine());
            switch (userInput) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    showItems();
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }
    public static void addItem(){
        System.out.println("Enter the name:");
        String Name = sc.nextLine();
        System.out.println("Enter the serial number:");
        String serialNum = sc.nextLine();
        System.out.println("Enter the value in dollars (whole number):");
        int Value = Integer.parseInt(sc.nextLine());
        //saves input into ArrayList
        Inventory item = new Inventory(Name, serialNum, Value);
        Items.add(item);
    }
    //method for deleting the item
    public static void deleteItem(){
        System.out.println("Enter the serial number of the item to delete:");
        String serialNum = sc.next();
        Items.removeIf(i -> i.getSerialNum().contains(serialNum));
    }
    //method for updating the item
    public static void updateItem(){
        System.out.println("Enter the serial number of the item to change:");
        String serialNum = sc.nextLine();
        for(Inventory i:Items){
            if(i.getSerialNum().contains(serialNum)){
                System.out.println("Enter the new name:");
                String Name = sc.nextLine();
                System.out.println("Enter the new value in dollars (whole number):");
                int Value = Integer.parseInt(sc.nextLine());
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