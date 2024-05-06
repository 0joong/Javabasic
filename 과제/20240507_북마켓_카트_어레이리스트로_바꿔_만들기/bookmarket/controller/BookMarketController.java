package bookmarket.controller;

import bookmarket.model.Book;
import bookmarket.model.BookStotage;
import bookmarket.model.Cart;
import bookmarket.view.ConsoleView;

public class BookMarketController {
    ConsoleView view;
    BookStotage mBookStorage;//model이란 의미로 접두사 m
    Cart mCart;
    String[] menuList = {
            "0. 종료",
            "1. 도서 정보 보기",
            "2. 장바구니 보기",
            "3. 장바구니 도서 담기",
            "4. 장바구니 비우기"
    };

    public BookMarketController(){}//default constructor
    public BookMarketController(BookStotage bookStotage, Cart cart, ConsoleView view) {
        this.mBookStorage = bookStotage;
        this.mCart = cart;
        this.view = view;
    }

    public void start(){
        view.displayWelcome();

        int menu;

        do{
            menu = view.selectMenu(menuList);

            switch(menu){
                case 1 -> {
                    viewBookInfo();
                    break;
                }
                case 2 ->{
                    viewCart();
                    break;
                }
                case 3 ->{
                    addBook2Cart();
                    break;
                }
                case 4 ->{
                    resetCart();
                    break;
                }
            }
        }while(menu!=0);
        view.showMessage("");
    }

    private void resetCart() {
        view.displayCart(mCart);
        if(!mCart.isEmpty()){
            view.askConfirm(">> 장바구니를 비우려면 yes를 입력하세요");
            mCart.resetCart();
            view.showMessage(">> 장바구니를 비웠습니다.");
        }

    }

    private void addBook2Cart() {
        view.displayBookInfo(mBookStorage);
        int bookID = view.selectBookId(mBookStorage);
        mCart.addItem(mBookStorage.getBookId(bookID));
        view.showMessage(">>장바구니에 도서를 추가하였습니다.  ");
    }

    private void viewCart() {
        view.displayCart(mCart);
    }

    private void viewBookInfo() {
        view.displayBookInfo(mBookStorage);
    }

}
