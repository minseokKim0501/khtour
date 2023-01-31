package ksmart42.khtour.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ksmart42.khtour.mapper.CommunityMapper;

@Component
public class CommonScheduler {

	private CommunityMapper communityMapper;
	
	public CommonScheduler(CommunityMapper communityMapper) {
		this.communityMapper =communityMapper;
	}
	
	
	//새벽 12 시 마다 하루 좋아요 카운트 리셋
	@Scheduled(cron = "0 0 0 * * ?")
	public void test() {
		communityMapper.resetDailyLikeCnt();
	}
}
