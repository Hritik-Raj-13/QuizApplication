package com.hr.quiz_application.service;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService{

    private static final String Image_DIR = "C:\\Users\\Hritik Raj\\Pictures\\Quiz_Applicant_Image_Test\\";

    @Override
    public void saveImage(byte[] imageBytes) {
        try {
            String fileName = "image_" + System.currentTimeMillis() + ".png";
            Files.write(Paths.get(Image_DIR + fileName),imageBytes);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
