class GradeException extends Exception{
    private int grade;
    public int getGrade(){return grade;}
    public GradeException(String message, int gr){
        super(message);
        grade=gr;
    }
}
