class SettedRankException extends Exception{
    private int grade;
    public int getGrade(){return grade;}
    public SettedRankException(String message, int gr){
        super(message);
        grade=gr;
    }
}
