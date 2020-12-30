package egovframework.thymleaf.Jw.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.thymleaf.Jw.service.Servicej;

@Service("Servicej")
public class ServiceImplj  extends EgovAbstractServiceImpl implements Servicej {
	
	private Logger logger = LoggerFactory.getLogger(ServiceImplj.class);
	
	@Resource(name = "Mapperj")
	private Mapperj Mapperj;

	@Override
	public List<Map<String, Object>> selectNotice(Map<String, String> param) {
		return Mapperj.selectNotice(param);
	}

	@Override
	public int deleteNotice(Map<String, String> map) {
		return Mapperj.deleteNotice(map);
	}

	@Override
	public Map<String, Object> selectNoticeDetail(String param) {
		return Mapperj.selectNoticeDetail(param);
	}

	@Override
	public int updateNotice(Map<String, String> param) {
		return Mapperj.updateNotice(param);
	}

	@Override
	public int insertNotice(Map<String, String> param) {
		return Mapperj.insertNotice(param);
	}
	
	

}
