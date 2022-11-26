package RestaurantFinder;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private final List<Item> menu = new ArrayList<>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        //default menu items
        this.menu.add(new Item("Lemon Rice",73));
        this.menu.add(new Item("curd Rice",45));
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime time = LocalTime.now();
        int isStillOpen = time.compareTo(closingTime);
        int isOpen = time.compareTo(openingTime);
        return isStillOpen < 0 && isOpen >= 0;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    //public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return this.menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    public int getOrderValue(List<Item> item){
        int totalValue = 0;
        for (Item myItem : item) {
            totalValue += myItem.getPrice();
        }
        return totalValue;
    }

}
