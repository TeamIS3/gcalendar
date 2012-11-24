/**
 * Stores information regarding an appointment/event.
 */

public class Repetition {
    private String frequency;   // Daily, Weekly, etc.
    private int quantity;

    public Repetition(String freq, int quant) {
        frequency = freq;
        quantity = quant;
    }

    public Repetition(){
        frequency = "";
        quantity = 0;
    }

    public String getFrequency() { return frequency; }
    public int getQuantity() { return quantity; }

    public void setFrequency(String freq) { frequency = freq; }
    public void setQuantity(int quant) { quantity = quant; }

    /*public String toString2() {
        StringBuilder str = new StringBuilder();
        
        str.append(String.format("Frequency : "+frequency+"%n"));
        str.append(String.format("Quantity : "+quantity+"%n"));

        return str.toString();
    }*/
	
    public String toString(){
	return frequency+" "+quantity;
    }

}
