/**
 * 
 */
package com.nagarro.fotonet.utils;

import com.nagarro.fotonet.common.Constants;
import com.nagarro.fotonet.entity.Photo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author shalini1814
 * 
 */
public class PhotoUploadUtil {

	public static void sendPhotoToServer(Photo photo) {
		String imagePath = Constants.STORAGE_PATH + "\\"
				+ "111";
		saveToServer(photo, imagePath);
	}

	private static void saveToServer(Photo photo, String imagePath) {
		try {
			MultipartFile file = photo.getFileData();

			File fileDir = new File(imagePath);
			boolean isDirCreated = fileDir.mkdir();
			if (isDirCreated) {
				System.out.println("Directory created successfully");
			} else {
				System.out
						.println("Directory not created for user with subscriptionId : "
								+ "111");
			}

			String fileName = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				fileName = imagePath + "\\" + file.getOriginalFilename();
				outputStream = new FileOutputStream(fileName);
				System.out.println("FileName:" + file.getOriginalFilename()
						+ " Size::" + file.getSize());

				int readBytes = 0;
				byte[] buffer = new byte[10000];

				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
