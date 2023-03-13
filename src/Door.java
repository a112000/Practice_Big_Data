public class Door {
    private int width, height, length;
    private boolean closed;
    public Door(int p_width, int p_height, int p_length, boolean p_closed) {
        width = p_width;
        height = p_height;
        length = p_length;
        closed = p_closed;
    }
    public Door() {
        width = 10;
        height = 10;
        length = 10;
        closed = false;
    }
    @Override
    public String toString() {
        return "Door{"
                + " width " + width
                + " height " + height
                + " length " + length
                + " closed " + closed
                + "}";
    }
    public int getHeight() {
        return height;
    }
    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }
    public boolean isClosed() {
        return closed;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    public boolean equals(Door door) {
        if (this == door) return true;
        if (door == null || getClass() != door.getClass()) return false;
        if (this.width == door.width & this.height == door.height & this.length == door.length & this.closed == door.closed) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        int closed_int;
        if (closed == false) {
            closed_int = 1;
        }
        else {
            closed_int = 2;
        }
        int result = width + height + length + closed_int;
        return result;
    }
}
