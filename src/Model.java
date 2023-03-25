public class Model extends SiemensMobile{
    int prod_year, num_of_buttons;
    @Override
    public int getYearOfCreation() {
        return prod_year;
    }
    @Override
    int getNumberOfPhisicalButtons() {
        return num_of_buttons;
    }
}
