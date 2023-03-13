public class Window {
    private int width, height, length;
    private boolean closed;
    public Window(int p_width, int p_height, int p_length, boolean p_closed) {
        width = p_width;
        height = p_height;
        length = p_length;
        closed = p_closed;
    }
    public Window() {
        width = 10;
        height = 10;
        length = 10;
        closed = false;
    }
    @Override
    public String toString() {
        return "Window{"
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
    public boolean equals(Window window) {
        if (this == window) return true;
        if (window == null || getClass() != window.getClass()) return false;
        if (this.width == window.width & this.height == window.height & this.length == window.length & this.closed == window.closed) {
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
