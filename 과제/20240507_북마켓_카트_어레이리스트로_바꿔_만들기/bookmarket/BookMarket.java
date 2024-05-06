package bookmarket;

import bookmarket.controller.BookMarketController;
import bookmarket.model.BookStotage;
import bookmarket.model.Cart;
import bookmarket.view.ConsoleView;

public class BookMarket {

    public static void main(String[] args){
        //model 생성
        BookStotage bookStotage = new BookStotage();
        Cart cart = new Cart();

        //view 생성
        ConsoleView view = new ConsoleView();

        //controller 생성(model, view)
        BookMarketController controller = new BookMarketController(bookStotage, cart, view);

        controller.start();
    }

}
