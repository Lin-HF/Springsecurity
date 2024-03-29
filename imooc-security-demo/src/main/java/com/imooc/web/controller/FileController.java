/**
 * 
 */
package com.imooc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.dto.FileInfo;

/**
 * @author linhaifeng1
 *
 */
@RestController
@RequestMapping("/file")
public class FileController {

	private String folder = "/Users/linhaifeng1/Documents/workspace-sts-3.9.9.RELEASE/imooc-security-demo/src/main/java/com/imooc/web/controller";
	@PostMapping
	public FileInfo upload(MultipartFile file) throws Exception {
		System.out.println(file.getName()); //"file"
		System.out.println(file.getOriginalFilename()); //"test.txt"
		System.out.println(file.getSize());//size of the file
		
		
		File localFile = new File(folder, new Date().getTime() + ".txt");
		
		file.transferTo(localFile);
		
		return new FileInfo(localFile.getAbsolutePath());
	}
	
	@GetMapping("/{id:\\d+}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try ( //自动关闭流
			InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
			OutputStream outputStream = response.getOutputStream();) {
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		} 
	}
}
