package ksmart42.khtour.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.mapper.MusMapper;

@Service
@Transactional
public class MusService {
	//DI 의존성 주입
	private MusMapper musMapper;
	
	public MusService(MusMapper musMapper) {
		this.musMapper = musMapper;
	}
	
	/**
	 * 코드에 따른 박물관 조회
	 */
	public Mus getMusByCode(String musCode) {
		return musMapper.getMusByCode(musCode);
	}
	/**
	 * 박물관등록
	 */
	public void addMus(Mus mus) {
		musMapper.addMus(mus);
	}
	
	/**
	 * 박물관 목록 조회
	 */
	public List<Mus> getMusList(){
		List<Mus> musList = musMapper.getMusList();
		 
		return musList;
	}

	/**
	 * 박물관 정보 수정
	 */
	public int modifyMus(Mus mus) {
		return musMapper.modifyMus(mus);
	}
	
	/**
	 * 박물관 정보 삭제
	 */
	public int removeMus(String musCode) {
		int result = musMapper.removeMus(musCode);
		
		result += musMapper.removeMus(musCode);
		
		return result;
	}
}
