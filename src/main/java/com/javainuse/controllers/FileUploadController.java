/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.controllers;

/**
 *
 * @author surajit.samui
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class FileUploadController {

	//destination folder to upload the files
	private static String UPLOAD_FOLDER = "//Users//surajit.samui//Documents//FileUploadTest//";

	@RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("upload");
	}

	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			return new ModelAndView("status", "message", "Please select a file and try again");
		}

		try {
			// read and write the file to the selected location-
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("status", "message", "File Uploaded sucessfully");
	}

}