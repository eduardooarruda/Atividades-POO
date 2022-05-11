import java.util.Scanner;
import java.util.ArrayList;
import java.text.ParseException;

public class App{
    
    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();

        while(true){
            App.menu();
            System.out.print("--> ");
            int option = sc.nextInt();

            switch(option){
                case 1:
                    String name;
                    double price;
                    double customsFee;
                    String data;
                    int productOption;

                    App.menuProduts();
                    System.out.print("--> ");

                    while(true){
                        productOption = sc.nextInt();
                        if(productOption == 1 || productOption == 2 || productOption == 3){
                            break;
                        }else{
                            System.out.println("Invalid option!");
                            App.menuProduts();
                            System.out.print("--> ");
                        }
                    }
                    

                    System.out.println("Enter the product name:");
                    System.out.print("--> ");
                    name = sc.next();

                    System.out.println("Enter the product price:");
                    System.out.print("--> ");
                    price = sc.nextDouble();

                    switch(productOption){
                        case 1: 
                            products.add(new Product(name, price));
                            break;
                            
                        case 2: 
                            System.out.println("Enter the product's customs fee:");
                            System.out.println("NOTE: The customs fee must be in percentage!");
                            System.out.print("--> ");
                            customsFee = sc.nextDouble();

                            products.add(new ImportedProduct(name, price, customsFee));
                            break;
                            
                        case 3:
                            System.out.println("Enter the date of manufacture of the product: ");
                            System.out.println("NOTE: Required format is day/month/year!");
                            System.out.print("--> ");
                            data = sc.next();

                            products.add(new UsedProduct(name, price, data));
                            break;
                    }
                    break;

                case 2:
                    int id = 1;

                    System.out.println("Program closed!\n");
                    System.out.println("All the products:\n");

                    for (Product product : products) {
                        System.out.println("Product: " + id);
                        System.out.println(product.priceTag());
                        id++;
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
                    
            }

            if(option == 2){
                sc.close();
                break;
            }

        }
    }
    
    static void menu(){
        System.out.println("___________________________________________________\n" +
                           "|                                                 |\n"+
                           "| 1 - Insert Product.                             |\n"+ 
                           "| 2 - terminate program.                          |\n" +
                           "|_________________________________________________|\n");
    }

    static void menuProduts(){
        System.out.println("---------------What type of product?---------------\n" +
                           "|                                                 |\n"+
                           "| 1 - Product.                                    |\n"+ 
                           "| 2 - Imported Product                            |\n" +
                           "| 3 - Used Product                                |\n" +
                           "|_________________________________________________|\n");

    }
}