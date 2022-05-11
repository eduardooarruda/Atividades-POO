public class ImportedProduct extends Product{
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee ){
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee(){
        return customsFee;
    }

    public double totalPrice(){
        return this.getPrice() + this.getPrice() * (getCustomsFee()/100);
    }

    @Override
    public String priceTag(){
        return super.priceTag() +
               "Customs Fee: " + getCustomsFee() + "%" +
               "\nTotal Price: " + totalPrice() + "\n";
    }

}