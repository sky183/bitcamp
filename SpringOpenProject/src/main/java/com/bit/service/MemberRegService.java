package com.bit.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MemberInfoDao;
import com.bit.model.MemberInfo;

@Repository
public class MemberRegService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MemberInfoDao memberDao;

	@Transactional
	public void memberReg(MemberInfo memberInfo, HttpServletRequest request) throws Exception {
		
		memberDao = sessionTemplate.getMapper(MemberInfoDao.class);

		// DB저장용 파일 이름, 물리적 저장할 때의 이름
		String imgName = "";

		// 물리적 저장 경로
//		String uploadUri = "/uploadfile/userphoto";

		// uploadUri 경로의 시스템 경로
//		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
//		String dir = "C:/OpenProject";
		String dir = "/upload/file/photo";
//		String dir = "/home/ec2-user/file/photo";
		

		if (!memberInfo.getPhotoFile().isEmpty()) {

			imgName = memberInfo.getUserId() + "_" + memberInfo.getPhotoFile().getOriginalFilename();

			// DB에 저장할 이름 SET
			memberInfo.setUserPhoto(imgName);
		} else {
			memberInfo.setUserPhoto("None Image");
		}

		memberDao.insert(memberInfo);

		if (imgName != null && !imgName.equals("")) {

			// 물리적 저장
			memberInfo.getPhotoFile().transferTo(new File(dir, imgName));
		}


	}

}
