package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bit.model.StudentReport;

@Controller
public class FileUploadController {

	@RequestMapping("/test")
	public String form() {
		return "report/uploadForm";
	}

	// @Requestparam 어노테이션을 이용한 업로드 파일 접근
	// – 업로드한 파일을 전달 받는 방법은 @requestParam 어노테이션이 적용된 MultipartFile 타입의 파라미터를 사용.
	// – MultipartFile인터페이스는 스프링에서 업로드 한 파일을 표현 할 때 사용되는 인터페이 스 –
	// MultipartFile인터페이스를 이용해서 업로드 한 파일의 이름, 실제 데이터, 파일의 크기 등을 구할 수 있다
	// MultipartFile 인터페이스를 사용
//	/ MultipartFile 인터페이스는 업로드 한 파일 정보 및 파일 데이터를 표현하기 위한 용도 로 사용.
	@RequestMapping(value = "/submitReport1", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report, Model model) {

		String fileName = report.getOriginalFilename();
		long fileSize = report.getSize();

		model.addAttribute("sno", studentNumber);
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		printInfo(studentNumber, report);

		return "report/uploadOk";
	}
	

	// MultipartHttpServletRequest 이용한 업로드 파일 접근
	// MultipartHttpServletRequest 인터페이스를 사용.
	// – MultipartHttpServletRequest 인터페이스는 스프링이 제공하는 인터페이스로, Multipart 요청이 들어올 때
	// 내부적으로 원본 HttpServletRequest 대신 사용되는 인터 페이스. – 웹 요청 정보를 구하기 위한 gstParameter()나
	// getHeader()와 같은 메서드를 사용, 추 가로 MultipartRequest 인터페이스가 제공한 Multipart 관련 메서드를
	// 사용할 수 있다.
	@RequestMapping(value = "/submitReport2", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request, Model model) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		String fileName = report.getOriginalFilename();
		long fileSize = report.getSize();

		model.addAttribute("sno", studentNumber);
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);

		return "report/uploadOk";
	}

	// 커맨드 객체를 통한 업로드 파일 접근
	// 커맨드 클래스에 파라미터와 동일한 이름의 MultipartFile 타입 프로퍼티를 추가해 주 어야 함.
	@RequestMapping(value = "/submitReport3", method = RequestMethod.POST)
	public String submitReport3(StudentReport studentReport, Model model) {
		System.out.println(studentReport.getStudentNumber());
		System.out.println(studentReport.getReport());

		String studentNumber = studentReport.getStudentNumber();
		String fileName = studentReport.getReport().getName();
		long fileSize = studentReport.getReport().getSize();

		model.addAttribute("sno", studentNumber);
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);

		return "report/uploadOk";
	}

	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());
	}

}
