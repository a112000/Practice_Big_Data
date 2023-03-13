public class House {
    private int door_num, window_num;
    private Door[] doors = new Door[door_num];
    private Window[] windows = new Window[window_num];
    public House(int doors_n, int windows_n) {
        door_num = doors_n;
        window_num = windows_n;
        for (int i = 0; i < door_num; i++) {
            doors[i] = new Door();
        }
        for (int i = 0; i < window_num; i++) {
            windows[i] = new Window();
        }
    }
    public House() {
        door_num = 0;
        window_num = 0;
    }
    public int getDoor_num() {
        return door_num;
    }
    public int getWindow_num() {
        return window_num;
    }
    public void setDoor_num(int door_num) {
        this.door_num = door_num;
    }
    public void setWindow_num(int window_num) {
        this.window_num = window_num;
    }
    public void lockDoor(int door_to_change) {
        this.doors[door_to_change].setClosed(true);
    }
    public void lockWindow(int window_to_change) {
        this.windows[window_to_change].setClosed(true);
    }
    @Override
    public String toString() {
        String result_string = "";
        for (int i = 0; i < door_num; i++) {
            result_string = result_string + doors[i].toString();
        }
        for (int i = 0; i < window_num; i++) {
            result_string = result_string + windows[i].toString();
        }
        return result_string;
    }
    public boolean equals(House house) {
        if (this == house) return true;
        if (house == null || getClass() != house.getClass()) return false;
        Boolean result = true;
        if (this.window_num == house.window_num & this.door_num == house.door_num) {
            for (int i = 0; i < door_num; i++) {
                if (!this.doors[i].equals(house.doors[i])) {
                    result = false;
                }
            }
            for (int i = 0; i < window_num; i++) {
                if (!this.windows[i].equals(house.windows[i])) {
                    result = false;
                }
            }
            return result;
        }
        else {
            return false;
        }
    }
    public int hashCode() {
        int result = window_num + door_num;
        for (int i = 0; i < window_num; i++) {
            result = result + windows[i].hashCode();
        }
        for (int i = 0; i < door_num; i++) {
            result = result + doors[i].hashCode();
        }
        return result;
    }
}
