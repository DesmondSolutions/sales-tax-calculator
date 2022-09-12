package salestaxapplication;


import salestaxapplication.model.Item;
import salestaxapplication.shopping.Cart;

public class MainApp {

    public static void main(String[] args) {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();


        cart1.addItemToCart(new Item(1, "book", 12.49));
        cart1.addItemToCart(new Item(1, "music CD", 14.99));
        cart1.addItemToCart(new Item(1, "chocolate bar", 0.85));

        cart2.addItemToCart(new Item(1, "imported box of chocolates", 10.00));
        cart2.addItemToCart(new Item(1, "imported bottle of perfume", 47.50));

        cart3.addItemToCart(new Item(1, "imported bottle of perfume", 27.99));
        cart3.addItemToCart(new Item(1, "bottle of perfume", 18.99));
        cart3.addItemToCart(new Item(1, "packet of headache pills", 9.75));
        cart3.addItemToCart(new Item(1, "imported box of chocolates", 11.25));

        System.out.println("\ninput 1\n");
        cart1.printInput();
        System.out.println("\ninput 2\n");
        cart2.printInput();
        System.out.println("\ninput 3\n");
        cart3.printInput();

        System.out.println("\noutput 1\n");
        cart1.printReceipt();
        System.out.println("\noutput 2\n");
        cart2.printReceipt();
        System.out.println("\noutput 3\n");
        cart3.printReceipt();
    }
}