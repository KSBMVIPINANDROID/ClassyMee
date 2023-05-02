package com.ksbm.ontu.foundation.drawing.util;

public class Events {

    // Event used to send message from color data notify.
    public static class ColorNotify {
        private int color;

        public ColorNotify(int color) {
            this.color = color;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }

}
