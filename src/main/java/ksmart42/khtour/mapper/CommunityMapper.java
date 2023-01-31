package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.CommCategory;
import ksmart42.khtour.dto.CommMemberReg;
import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.CommReply;
import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.dto.LikesDislikes;

@Mapper
public interface CommunityMapper {

	// 1  : 커뮤니티 전체리스트 반환
	public List<Community> getCommunityList();
	public List<Community> getCommunityListByCommCodeList(List<String> commCodeList);
	// 2  : 커뮤니티 포스트 전체리스트 반환
	public List<CommPost> getPostList();
	public List<CommPost> getPostListHot();
	public List<CommPost> getPostListNew();
	// 3 : 커뮤니티 포스트 전체 리스트 반환
	public List<CommPost> getDailyPostList();
	
	public String checkLikeDislikeByMemberIdAndPostCode(String memberId, String postCode);
	public String checkLikeDislikeByMemberIdAndReplyCode(String memberId, String replyCode);
	
	public void updatePostLikeToDislike(String memberId, String postCode);
	public void updatePostDislikeToLike(String memberId, String postCode);
	
	public void updateReplyLikeToDislike(String memberId, String replyCode);
	public void updateReplyDislikeToLike(String memberId, String replyCode);
	
	public List<CommCategory> getCommCategoryList();
	
	public List<CommPost> getPostListByCommCode(String commCode);
	public List<CommPost> getPostListByCommCodeHot(String commCode);
	public List<CommPost> getPostListByCommCodeNew(String commCode);
	public List<String> getPostCodeListByTagCode(String tagCode);
	public List<String> getPostCodeListByCommCode(String commCode);
	
	
	
	public List<Community> getCommunityListByCategoryCode(String categoryCode);
	
	public List<CommReply> getCommReplyListByPostCode(String postCode);
	
	public List<CommReply> getChildrenReplyListByReplyCode(String replyCode);

	public void addCommMemberReg(CommMemberReg commMemberReg);
	public List<String> getCommCodeListByMemberId(String memberId);

	// 4 : 커뮤니티 이름으로 커뮤니티  찾아서 반환 
	public Community getCommunityByCommCode(String commCode);
	
	// 5 : 포스트코드로 포스트 찾아서 반환 
	public CommPost getPostByPostCode(String postCode);
	
	public void addCommentCnt(String postCode);
	public void addCommentCntOfComments(String replyCode);
	public void subtractCommentCnt(String postCode);
	public void subtractCommentCntOfComments(String replyCode);
	
	
	
	public void addCommunityMemberCnt(String commCode);
	public void addCategoryMemberCnt(String categoryCode);
	
	public void addPostLikesCnt(String postCode);
	public void addPostDislikesCnt(String postCode);
	
	public void addReplyLikesCnt(String replyCode);
	public void addReplyDislikesCnt(String replyCode);
	
	public int getPostResultCnt(String postCode);
	public int getReplyResultCnt(String replyCode);
	
	public CommReply getCommReplyByReplyCode(String replyCode);
	
	// 6 : 커뮤니티 이름으로 규칙 리스트 찾아서 반환 
	public List<Rule> getRuleListByCommCode(String commCode);
	
	public Rule getRuleByRuleCode(String ruleCode);
	
	// 7 : 커뮤니티 이름으로 커뮤니티 테그 찾아서 반환 
	public List<CommTag> getTagListByCommCode(String commCode);
	
	public CommTag getCommTagByTagCode(String tagCode);
	
	// 8 : 커뮤니티 추가
	public void addCommunity(Community community);
	
	public void updateCommunity(Community community);
	public void updatePost(CommPost commPost);
	public void updateTag(CommTag commTag);
	public void updateReply(CommReply commReply);
	
	public void deleteRule(String ruleCode);
	public void deleteRuleByCommCode(String commCode);
	public void deleteCommMemberRegByCommCode(String commCode);
	public void deleteTag(String tagCode);
	public void deleteTagByCommCode(String commCode);
	public void deleteCommReply(String replyCode);
	public void deleteLikesDislikesByReplyCode(String replyCode);
	public void deleteLikesDislikesByPostCode(String postCode);
	public void deleteCommPostByPostCode(String postCode);
	public void deleteCommunityByCommCode(String commCode);
	
	
	public void resetDailyLikeCnt();
	
	// 9 : 커뮤니티 포스트 추가
	public void addCommPost(CommPost commpost);
	// 10 : 커뮤니티 규칙 추가
	public void addRule(Rule rule);
	
	public void updateRule(Rule rule);
	
	// 11 : 커뮤니티 테그 추가
	public void addTag(CommTag commTag);
	
	public void addCommReply(CommReply commReply);
	
	public void addlikesDislikes(LikesDislikes likesDislikes);
	
	// 12 : 커뮤니티 이름 중복 체크
	public boolean commNameCheck(String commName);
	
	public String getNextPostCode();
	public String getNextCommCode();
	
	public List<String> getFileControllerByPostCode(String postCode);
	
	
	
	
}
