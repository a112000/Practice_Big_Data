class CostException extends Exception{
    private int cost;
    public int getCost(){return cost;}
    public CostException(String message, int co){
        super(message);
        cost=co;
    }
}
