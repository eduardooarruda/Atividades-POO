import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class UsedProduct extends Product{
    private Date manufactureDate;

    public UsedProduct(String name, double price, String data) throws ParseException{
        super(name, price);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        this.manufactureDate = formato.parse(data);        
    }

    public String getManufactureDate() {
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
		
        return f.format(this.manufactureDate);
    }

    @Override
    public String priceTag(){
        return super.priceTag() +
               "Manufacture Data: " + getManufactureDate() + "\n";
    }

}
