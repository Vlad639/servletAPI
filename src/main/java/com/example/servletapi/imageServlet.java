package com.example.servletapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "ImageBlackWhiteServlet", value = "/blackWhiteImage")
@MultipartConfig
public class imageServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger("blackWhiteImageServletLogger");

    public void init(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String logText = "";
        Part filePart = request.getPart("image");
        InputStream inputStream = filePart.getInputStream();

        logText += request + " ";
        logText += filePart.getContentType() + " ";
        logText += filePart.getSubmittedFileName() + " ";
        logText += filePart.getSize();
        logger.info(logText);

        BufferedImage sourceImage = ImageIO.read(inputStream);
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        BufferedImage blackWhiteImage = new BufferedImage(width, height, sourceImage.getType());

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = new Color(sourceImage.getRGB(x, y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int blackWhiteCanal = (int) (red * 0.299 + green * 0.587 + blue * 0.114);

                red = blackWhiteCanal;
                green = blackWhiteCanal;
                blue = blackWhiteCanal;

                Color blackWhiteColor = new Color(red, green, blue);
                blackWhiteImage.setRGB(x, y, blackWhiteColor.getRGB());

            }
        }
        inputStream.close();
        ImageIO.write(blackWhiteImage, "png", response.getOutputStream());
    }

    public void destroy() {
    }
}
