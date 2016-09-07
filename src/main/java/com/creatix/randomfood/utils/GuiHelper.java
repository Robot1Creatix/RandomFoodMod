package com.creatix.randomfood.utils;

/**
 * Created by Root on 9/7/2016.
 */
public class GuiHelper {

        /**
         * ps: Скопипижжено с GuideApi
         * @param mouseX - Position of the mouse on the x-axiq
         * @param mouseY - Position of the mouse on the y-axis
         * @param x      - Starting x for the rectangle
         * @param y      - Starting y for the rectangle
         * @param width  - Width of the rectangle
         * @param height - Height of the rectangle
         * @return whether or not the mouse is in the rectangle
         */
        public static boolean isMouseBetween(int mouseX, int mouseY, int x, int y, int width, int height) {
            int xSize = x + width;
            int ySize = y + height;
            return (mouseX >= x && mouseX <= xSize && mouseY >= y && mouseY <= ySize);
        }


}
