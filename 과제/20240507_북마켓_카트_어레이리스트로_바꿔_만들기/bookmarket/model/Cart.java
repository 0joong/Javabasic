package bookmarket.model;

import java.util.ArrayList;

public class Cart {
    //CartItem[] itemList = new CartItem[64];
    private ArrayList<CartItem> itemList;

//    int numItems = 0;

    public Cart(){
        itemList = new ArrayList<>(64);
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public int getNumItems() {
        return itemList.size();
    }

//    public void setNumItems(int numItems) {
//        this.numItems = numItems;
//    }

    public ArrayList<CartItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<CartItem> itemList) {
        this.itemList = itemList;
    }

    public String getItemInfo(int index) {
        return itemList.get(index).toString();
    }

    public void addItem(Book book) {
        CartItem item = getCartItem(book);
        if (item == null) {
            itemList.add(new CartItem(book));
//            numItems++;
        } else {
            item.addQuantity(1);
        }
    }
    private CartItem getCartItem(Book book) {
        for (int i = 0 ; i<itemList.size() ; i++) {
            if (itemList.get(i).getBook() == book) {
                return itemList.get(i);
            }
        }
        return null;
    }
    public void resetCart() {
        itemList.clear();
//        this.itemList = new CartItem[64];
    }
}
