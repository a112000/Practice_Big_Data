public class Theater extends Public_building{
    String schedule_of_exhibitions = "1 апреля: Мастер и Маргарита; 2 арпеля: Борис Годунов", address = "Taganskaya";
    @Override
    String getSchedule() {
        return schedule_of_exhibitions;
    }
    @Override
    public String getAddress() {
        return address;
    }
}
