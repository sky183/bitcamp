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
public class MemberModifyService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MemberInfoDao memberDao;
	
	@Transactional
	public int memberModify(MemberInfo memberInfo, HttpServletRequest request) throws Exception {
		
		int resultCnt = 0;
		
		memberDao = sessionTemplate.getMapper(MemberInfoDao.class);

		// DB저장용 파일 이름, 물리적 저장할 때의 이름
		String imgName = "";

		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";

		// 파라미터값(이전 사진파일)
		String preUserPhoto = request.getParameter("preUserPhoto");

		// uploadUri 경로의 시스템 경로6
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		if (!memberInfo.getPhotoFile().isEmpty()) {

			imgName = memberInfo.getUserId() + "_" + memberInfo.getPhotoFile().getOriginalFilename();

			// DB에 저장할 이름 SET
			memberInfo.setUserPhoto(imgName);

		} else {

			memberInfo.setUserPhoto(preUserPhoto);
		}

		resultCnt = memberDao.update(memberInfo);

		// 물리적 저장
		memberInfo.getPhotoFile().transferTo(new File(dir, imgName));

		// 이전 파일과 새로운 파일이 다르면 기존 파일 삭제
		if (!imgName.equals(preUserPhoto)) {
			new File(dir, preUserPhoto).delete();
		}

		return resultCnt;
	}
}
