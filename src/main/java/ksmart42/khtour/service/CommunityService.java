package ksmart42.khtour.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.controller.CommunityController;
import ksmart42.khtour.dto.CommCategory;
import ksmart42.khtour.dto.CommMemberReg;
import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.CommReply;
import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.dto.LikesDislikes;
import ksmart42.khtour.mapper.CommunityMapper;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class CommunityService {
	private CommunityMapper communityMapper;
	private static final Logger log = LoggerFactory.getLogger(CommunityController.class);
	private FileUtil fileUtil;  
	private FileMapper fileMapper;
	
	@Autowired
	public CommunityService(CommunityMapper communityMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.communityMapper = communityMapper;
		 this.fileUtil = fileUtil;
		 this.fileMapper = fileMapper;
	}

	/*
	 * 작성자 : 한경수 입 력 : 출 력 : List<Community> (전체 커뮤니티 리스트) 설 명 : 전체 커뮤니티 찾아서 맴버 숫자들을
	 * 모두 (100K,420,42M) 형식으로 수정후에 반환
	 */
	public List<Community> getCommunityList() {
		List<Community> communityList = communityMapper.getCommunityList();

		// 커뮤니티 리스트안에든 맴버 숫자들을 모두 수정
		for (int i = 0; i < communityList.size(); i++) {
			float memberCnt = Float.parseFloat(communityList.get(i).getMemberCnt());
			communityList.get(i).setMemberCnt(KhtourLibrary.cntConverter(memberCnt));
			;
		}
		return communityList;
	}

	/*
	 * 작성자 : 한경수 입 력 : 출 력 : List<CommPost> (전체 커뮤니티 포스트) 설 명 : 전체 커뮤니티 찾아서 맴버 숫자들을
	 * 모두 (100K,420,42M) 형식으로 수정후에 반환
	 */
	public List<CommPost> getDailyPostList() {
		List<CommPost> dailyPostList = communityMapper.getDailyPostList();

		return dailyPostList;
	}

	/*
	 * 작성자 : 한경수 입 력 : 출 력 : List<CommPost> (전체 포스트 리스트) 설 명 : 전체 포스트 리스트 찾아서 반환
	 */
	public List<CommPost> getPostList(String order) {
		List<CommPost> postList = null;
		
		if (order == null || order.equals("top")) {
			postList = communityMapper.getPostList();
		} else if (order.equals("hot")) {
			postList = communityMapper.getPostListHot();
		} else if (order.equals("new")) {
			postList = communityMapper.getPostListNew();
		}

		for (int i = 0; i < postList.size(); i++) {
			CommPost tempPost = postList.get(i);
			String postCode = tempPost.getPostCode();
			
			tempPost.setFilePath(communityMapper.getFileControllerByPostCode(postCode));
		}
		return postListMod(postList);
	}

	public String updateLikeDislike(String postCode, String likeDislike, String replyCode, HttpSession session) {
		if (likeDislike.equals("like")) {
			if (replyCode == null) {

				communityMapper.updatePostLikeToDislike((String) session.getAttribute("SID"), postCode);
				communityMapper.addPostDislikesCnt(postCode);
				communityMapper.addPostDislikesCnt(postCode);
			} else {
				communityMapper.updateReplyLikeToDislike((String) session.getAttribute("SID"), replyCode);
				communityMapper.addReplyDislikesCnt(replyCode);
				communityMapper.addReplyDislikesCnt(replyCode);
			}
		} else {
			if (replyCode == null) {
				communityMapper.updatePostDislikeToLike((String) session.getAttribute("SID"), postCode);
				communityMapper.addPostLikesCnt(postCode);
				communityMapper.addPostLikesCnt(postCode);
			} else {
				communityMapper.updateReplyDislikeToLike((String) session.getAttribute("SID"), replyCode);
				communityMapper.addReplyLikesCnt(replyCode);
				communityMapper.addReplyLikesCnt(replyCode);
			}
		}
		String result = "";
		if (replyCode == null) {
			result = KhtourLibrary.cntConverter((float) communityMapper.getPostResultCnt(postCode));
		} else {
			result = KhtourLibrary.cntConverter((float) communityMapper.getReplyResultCnt(replyCode));
		}
		return result;
	}

	/*
	 * 작성자 : 한경수 입 력 : String (커뮤니티 이름) 출 력 : List<CommPost> (특정 커뮤니티의 포스트 리스트) 설 명
	 * : 특정 커뮤니티 에 맞는 포스트 리스트 반환
	 */
	public List<CommPost> getPostListByCommCode(String CommCode, String order) {

		List<CommPost> postList = null;
		if (order == null || order.equals("top")) {
			postList = communityMapper.getPostListByCommCode(CommCode);
		} else if (order.equals("hot")) {
			postList = communityMapper.getPostListByCommCodeHot(CommCode);
		} else if (order.equals("new")) {
			postList = communityMapper.getPostListByCommCodeNew(CommCode);
		}
		return postListMod(postList);
	}

	/*
	 * 작성자 : 한경수 입 력 : List<CommPost> (포스트 리스트) 출 력 : List<CommPost> (포스트 리스트) 설 명 :
	 * 포스트 리스트에, 1) 테그리스트에 맞는 커뮤니티 테그클래스 를 찾아서 저장 2) 포스트 리스트에 포스트 마다 코드에 해당하는 파일 컨트롤러들을 넣어준다.
	 */
	public List<CommPost> postListMod(List<CommPost> postList) {
		for (int i = 0; i < postList.size(); i++) {
			String postCode = postList.get(i).getPostCode();
			CommPost commPost = postList.get(i);
			postList.get(i).setFilePath(communityMapper.getFileControllerByPostCode(postCode));
			commPost.setCommTag(communityMapper.getCommTagByTagCode(commPost.getTagCode()));
		}
		return postList;
	}

	/*
	 * 작성자 : 한경수 입 력 : 출 력 : List<CommCategory> (카테고리 리스트) 설 명 : 전체 카테고리 리스트 찾아서 반환
	 */
	public List<CommCategory> getCommCategoryList() {

		List<CommCategory> categoryList = communityMapper.getCommCategoryList();

		// 카테고리 리스트를 수정후에 반환
		return categoryListMod(categoryList);
	}

	/*
	 * 작성자 : 한경수 입 력 : int (랜덤으로 뽑고싶은 카테고리 수) 출 력 : List<CommCategory> (카테고리 리스트) 설
	 * 명 : 전체 카테고리 리스트 중에 입력값 숫자만큼 랜덤으로 뽑아서 반환
	 */
	public List<CommCategory> getCommCategoryList(int randomCnt) {

		List<CommCategory> categoryList = communityMapper.getCommCategoryList();

		// 리스트에 든 카테고리 를 뽑고싶은 숫자가 될때까지 하나씩 제거한다.
		for (int i = categoryList.size(); i > randomCnt; i--) {
			int number = (int) (Math.random() * i);
			categoryList.remove(number);
		}
		// 카테고리 리스트를 수정후에 반환
		return categoryListMod(categoryList);

	}

	/*
	 * 작성자 : 한경수 입 력 : List<CommCategory> 카테고리 리스트 출 력 : List<CommCategory> 카테고리 리스트
	 * 설 명 : 카테고리 리스트에 속한 모든 커뮤니티 리스트의 좋아요 숫자를 모두 합친후에, K/M형식으로 수정후 반환
	 */
	public List<CommCategory> categoryListMod(List<CommCategory> categoryList) {
		for (int i = 0; i < categoryList.size(); i++) {
			String result = "";
			CommCategory category = categoryList.get(i);
			// K/M식으로 변환
			result = KhtourLibrary.cntConverter(Float.parseFloat(categoryList.get(i).getTotalMemberCnt()));
			// 카테고리에 총 결과 저장
			category.setTotalMemberCnt(result);
		}
		return categoryList;
	}

	/*
	 * 작성자 : 한경수 입 력 : int (랜덤 숫자) 출 력 : Map<String,List<Community>> 설 명 : 전체 카테고리
	 * 리스트중에서 입력받은 숫자 만큼의 카테고리를 무작위로 뽑아서 맵으로 만든후 카테고리 이름을 키값으로 반환.
	 */
	public Map<String, List<Community>> getRandomCategoryMap(int randomCnt) {
		// 전체 카테고리 리스트중에서 입력받은 숫자 만큼의 카테고리를 무작위로 뽑아서 리스트로 만듬
		List<CommCategory> randomCategoryList = getCommCategoryList(randomCnt);

		// 각각의 카테고리 이름을 키값으로 하고 카테고리에 맞는 커뮤니티 리스트를 value 값으로 맵을 만듬
		Map<String, List<Community>> randomCategoryMap = new HashMap<>();
		for (int i = 0; i < randomCategoryList.size(); i++) {
			String rCategoryName = randomCategoryList.get(i).getCategoryName();
			String rCategoryCode = randomCategoryList.get(i).getCategoryCode();
			randomCategoryMap.put(rCategoryName, getCommunityListByCategoryCode(rCategoryCode));
		}
		return randomCategoryMap;
	}

	/*
	 * 작성자 : 한경수 입 력 : String (카테고리 이름) 출 력 : List<Community> 커뮤니티 리스트 설 명 : 카테고리에
	 * 따른 커뮤니티 리스트를 찾아서 각각에 맴버를 K/M 형식으로 고친후에 반환
	 */
	public List<Community> getCommunityListByCategoryCode(String categoryCode) {

		List<Community> communityList = communityMapper.getCommunityListByCategoryCode(categoryCode);
		for (int i = 0; i < communityList.size(); i++) {
			float memberCnt = Float.parseFloat(communityList.get(i).getMemberCnt());
			communityList.get(i).setMemberCnt(KhtourLibrary.cntConverter(memberCnt));
		}
		return communityList;
	}

	/*
	 * 작성자 : 한경수 입 력 : List<CommPost> (커뮤니티 포스트 리스트), String(테그코드) 출 력 :
	 * List<CommPost> (커뮤니티 포스트 리스트) 설 명 : 커뮤니티 포스트중에서 입력받은 테그코드와 일치하는 포스트만 남기고 다
	 * 제거후 반환
	 */
	public List<CommPost> getPostByTagCode(List<CommPost> postList, String tagCode) {
		for (int i = 0; i < postList.size(); i++) {
			String postTagCode = postList.get(i).getTagCode();
			if (postTagCode == null || !postTagCode.equals(tagCode)) {
				postList.remove(i);
				i--;
			}
		}
		return postList;
	}

	public List<CommReply> getCommReplyListByPostCode(String postCode, HttpSession session) {

		List<CommReply> replyList = communityMapper.getCommReplyListByPostCode(postCode);

		String memberId = (String) session.getAttribute("SID");
		replyList = replyChildrenSetter(memberId, replyList);
		return replyList;
	}

	public List<CommReply> replyChildrenSetter(String memberId, List<CommReply> replyList) {
		for (int i = 0; i < replyList.size(); i++) {
			CommReply reply = replyList.get(i);

			List<CommReply> childrenList = communityMapper.getChildrenReplyListByReplyCode(reply.getReplyCode());
			if (childrenList == null) {
				return childrenList;
			}

			childrenList = replyChildrenSetter(memberId, childrenList);

			for (int j = 0; j < childrenList.size(); j++) {
				String likeOrDislike = communityMapper.checkLikeDislikeByMemberIdAndReplyCode(memberId,
						childrenList.get(j).getReplyCode());
				childrenList.get(j).setLikeOrDislike(likeOrDislike);
			}

			reply.setChildrenReply(childrenList);
		}
		return replyList;
	}

	/*
	 * 작성자 : 한경수 입 력 : String (커뮤니티 이름) 출 력 : Community (특정 커뮤니티) 설 명 :입력받은 커뮤니티
	 * 이름으로 커뮤니티를 찾아서 좋아요 숫자를 K/M식으로 변환후 반환
	 */
	public Community getCommunityByCommCode(String commCode) {

		Community community = communityMapper.getCommunityByCommCode(commCode);

		float cnt = Float.parseFloat(community.getMemberCnt());
		// K/M 형식으로 변환
		community.setMemberCnt(KhtourLibrary.cntConverter(cnt));
		return community;
	}

	/*
	 * 작성자 : 한경수 입 력 : String(포스트 코드) 출 력 : CommPost(커뮤니티 포스트) 설 명 : 입력받은 포스트로 맞는
	 * 포스트를 찾아서 좋아요 에서 싫어요 숫자를 뺀후 K/M 식으로 변환후에 반환
	 */
	public CommPost getPostByPostCode(String postCode) {
		// 커뮤티니 코드에 맞는 커뮤니티 포스트를 찾아서 저장
		CommPost commPost = communityMapper.getPostByPostCode(postCode);

		// 커뮤니티 포스트 안에든 포스트 코드를 사용하여 포스트 를 찾아서 커뮤니티 포스트에 저장
		commPost.setCommTag(communityMapper.getCommTagByTagCode(commPost.getTagCode()));
		// K/M식으로 변환
		commPost.setLikesCnt(KhtourLibrary.cntConverter(Float.valueOf(commPost.getResultCnt())));
		return commPost;
	}

	/*
	 * 작성자 : 한경수 입 력 : String(커뮤니티 이름) 출 력 : List<Rule> (규칙 리스트) 설 명 : 커뮤니티 이름을 받아서
	 * 맞는 규칙 리스트를 찾아서 반환
	 */
	public List<Rule> getRuleListByCommCode(String commCode) {

		List<Rule> ruleList = communityMapper.getRuleListByCommCode(commCode);
		return ruleList;
	}

	/*
	 * 작성자 : 한경수 입 력 : String(커뮤니티 이름) 출 력 : List<CommTag> (태그 리스트) 설 명 : 커뮤니티 이름을
	 * 받아서 맞는 테그리스트를 찾아서 반환S
	 */
	public List<CommTag> getTagListByCommCode(String commCode) {

		List<CommTag> tagList = communityMapper.getTagListByCommCode(commCode);
		return tagList;
	}

	/*
	 * 작성자 : 한경수 입 력 : Community(커뮤니티) 출 력 : 설 명 : 커뮤니티 등록
	 */
	public void addCommunity(Community community) {

		communityMapper.addCommunity(community);

	}

	/*
	 * 작성자 : 한경수 입 력 : CommPost(커뮤니티포스트) 출 력 : 설 명 : 커뮤니티 포스트 등록
	 */
	public void addCommPost(CommPost commPost) {

		communityMapper.addCommPost(commPost);
	}

	/*
	 * 작성자 : 한경수 입 력 : Rule(규칙) 출 력 : 설 명 : 규칙등록
	 */
	public void addRule(Rule rule) {

		communityMapper.addRule(rule);

	}

	public void addlikesDislikes(LikesDislikes likesDislikes) {

		communityMapper.addlikesDislikes(likesDislikes);

	}

	public void addCommReply(CommReply commReply) {

		addCommentCnt(commReply.getPostCode());

		if (commReply.getParentReplyCode() != null) {
			addCommReplyMod(commReply.getParentReplyCode());
		}
		communityMapper.addCommReply(commReply);

	}
	
	public void addCommentCnt(String postCode) {
		
		communityMapper.addCommentCnt(postCode);
		
	}
	public void addCommentCntOfComments(String replyCode) {
		
		communityMapper.addCommentCntOfComments(replyCode);
		
	}
	public void subtractCommentCnt(String postCode) {
		
		communityMapper.subtractCommentCnt(postCode);
		
	}
	public void subtractCommentCntOfComments(String replyCode) {
		
		
		String parentReplyCode = communityMapper.getCommReplyByReplyCode(replyCode).getParentReplyCode();
		if(parentReplyCode!=null&&parentReplyCode!="")
		{
			communityMapper.subtractCommentCntOfComments(parentReplyCode);
			subtractCommentCntOfComments(parentReplyCode);
		}
	}

	public void addCommReplyMod(String parentReplyCode) {
		addCommentCntOfComments(parentReplyCode);
		CommReply commReply = communityMapper.getCommReplyByReplyCode(parentReplyCode);
		if (commReply.getParentReplyCode() != null) {
			addCommReplyMod(commReply.getParentReplyCode());
		}
	}

	/*
	 * 작성자 : 한경수 입 력 : CommTag(커뮤니티 테그) 출 력 : 설 명 :
	 */
	public void addTag(CommTag commTag) {
		communityMapper.addTag(commTag);
	}

	public void addCommMemberReg(CommMemberReg commMemberReg) {
		communityMapper.addCommMemberReg(commMemberReg);
	}

	public String addLikesDislikes(String postCode, String likeDislike, String replyCode, HttpSession session) {
		LikesDislikes likesDislikes = new LikesDislikes();
		likesDislikes.setMemberId((String) session.getAttribute("SID"));
		likesDislikes.setPostCode(postCode);
		likesDislikes.setReplyCode(replyCode);
		String result = "";
		if (likeDislike.equals("like")) {
			if (replyCode == null) {
				communityMapper.addPostLikesCnt(postCode);
			} else {
				communityMapper.addReplyLikesCnt(replyCode);
			}
			likesDislikes.setLikesDislikesCate("like");
			communityMapper.addlikesDislikes(likesDislikes);
		} else {
			if (replyCode == null) {
				communityMapper.addPostDislikesCnt(postCode);
			} else {
				communityMapper.addReplyDislikesCnt(replyCode);
			}
			likesDislikes.setLikesDislikesCate("dislike");
			communityMapper.addlikesDislikes(likesDislikes);
		}

		if (replyCode == null) {
			result = KhtourLibrary.cntConverter((float) communityMapper.getPostResultCnt(postCode));
		} else {
			result = KhtourLibrary.cntConverter((float) communityMapper.getReplyResultCnt(replyCode));
		}

		log.info("결과 : " + result);
		return result;
	}

	public void updateCommunity(Community community) {
		communityMapper.updateCommunity(community);
	}

	public void updatePost(CommPost commPost) {
		communityMapper.updatePost(commPost);
	}

	public void updateRule(Rule rule) {
		communityMapper.updateRule(rule);
	}

	public void updateTag(CommTag commTag) {
		communityMapper.updateTag(commTag);
	}

	public void updateReply(CommReply commReply) {
		communityMapper.updateReply(commReply);
	}

	public void deleteRule(String ruleCode) {
		communityMapper.deleteRule(ruleCode);
	}

	public void deleteCommReply(String replyCode) {
		List<CommReply> replyListLevel1 = communityMapper.getChildrenReplyListByReplyCode(replyCode);
		List<CommReply> replyListLevel2 = new ArrayList<CommReply>();
		List<CommReply> replyListLevel3 = new ArrayList<CommReply>();
		List<CommReply> replyListLevel4 = new ArrayList<CommReply>();

		String postCode = communityMapper.getCommReplyByReplyCode(replyCode).getPostCode();
		
		if (replyListLevel1.size() > 0) {
			replyListLevel2 = getChildrenReplyByReplyList(replyListLevel1);
		}

		if (replyListLevel2.size() > 0) {
			replyListLevel3 = getChildrenReplyByReplyList(replyListLevel2);
		}

		if (replyListLevel3.size() > 0) {
			replyListLevel4 = getChildrenReplyByReplyList(replyListLevel3);
		}
		 for(int i=0;i<replyListLevel4.size();i++) 
		 {
			 String tempReplyCode = replyListLevel4.get(i).getReplyCode();
			 subtractCommentCntOfComments(tempReplyCode);
			 subtractCommentCnt(postCode);
			 communityMapper.deleteLikesDislikesByReplyCode(tempReplyCode);
			 communityMapper.deleteCommReply(tempReplyCode); 
			 
		 }
		 for(int i=0;i<replyListLevel3.size();i++) 
		 {
			 String tempReplyCode = replyListLevel3.get(i).getReplyCode();
			 subtractCommentCntOfComments(tempReplyCode);
			 subtractCommentCnt(postCode);
			 communityMapper.deleteLikesDislikesByReplyCode(tempReplyCode); 
			 communityMapper.deleteCommReply(tempReplyCode); 
		 }
		 for(int i=0;i<replyListLevel2.size();i++) 
		 {
			 String tempReplyCode = replyListLevel2.get(i).getReplyCode();
			 subtractCommentCntOfComments(tempReplyCode);
			 subtractCommentCnt(postCode);
			 communityMapper.deleteLikesDislikesByReplyCode(tempReplyCode); 
			 communityMapper.deleteCommReply(tempReplyCode); 
		 }
		 for(int i=0;i<replyListLevel1.size();i++) 
		 {
			 String tempReplyCode = replyListLevel1.get(i).getReplyCode();
			 subtractCommentCntOfComments(tempReplyCode);
			 subtractCommentCnt(postCode);
			 communityMapper.deleteLikesDislikesByReplyCode(tempReplyCode); 
			 communityMapper.deleteCommReply(tempReplyCode); 
		 }
		 
		 subtractCommentCntOfComments(replyCode);
		 subtractCommentCnt(postCode);
		 communityMapper.deleteLikesDislikesByReplyCode(replyCode); 
		 communityMapper.deleteCommReply(replyCode);
		 
	}
	public List<CommReply> getChildrenReplyByReplyList(List<CommReply> replyList) {
		List<CommReply> replyNextLevel = new ArrayList<CommReply>();
		for (int i = 0; i < replyList.size(); i++) {
			List<CommReply> placeHolderList = communityMapper
					.getChildrenReplyListByReplyCode(replyList.get(i).getReplyCode());
			for (int j = 0; j < placeHolderList.size(); j++) {
				replyNextLevel.add(placeHolderList.get(j));
			}
		}
		return replyNextLevel;
	}
	
	public void deleteLikesDislikesByReplyCode(String replyCode) {
		
		communityMapper.deleteLikesDislikesByReplyCode(replyCode);
	}

	public void deleteCommPost(String postCode, String fileRootPath) throws IOException {
		
		
		CommPost commPost = communityMapper.getPostByPostCode(postCode);
		String pictureLink = commPost.getPictureLink();
		
		if(pictureLink!=null&&pictureLink!="")
		{
			fileUtil.fileDelete(fileRootPath, pictureLink);
			fileMapper.removeFileByFilePath(pictureLink);
		}
		
		List<String> listOfAdditionalPictureLink = communityMapper.getFileControllerByPostCode(postCode);
		if(listOfAdditionalPictureLink!=null)
		{
			for(int i = 0 ;i<listOfAdditionalPictureLink.size();i++)
			{
				fileUtil.fileDelete(fileRootPath, listOfAdditionalPictureLink.get(i).substring(1));
				fileMapper.removeFileByFilePath(listOfAdditionalPictureLink.get(i).substring(1));
				fileMapper.removeFileControlByFilePath(listOfAdditionalPictureLink.get(i));
			}
		}
		
		List<CommReply> listCommReply = communityMapper.getCommReplyListByPostCode(postCode);
		//1.뎃글지우고
		for(int i =0;i<listCommReply.size();i++)
		{
			deleteCommReply(listCommReply.get(i).getReplyCode());
		}
		//2. 포스트 좋아요 싫어요 지우고
		communityMapper.deleteLikesDislikesByPostCode(postCode);
		//3. 포스트 지우고
		communityMapper.deleteCommPostByPostCode(postCode);
		
	}
	
	public void deleteTag(CommTag commTag, String fileRootPath) throws IOException {
		
		//테그에 관련된 모든 포스트 제거.
		String tagCode = commTag.getTagCode();
		List<String> postCodeList = communityMapper.getPostCodeListByTagCode(tagCode);	
		for(int i =0;i<postCodeList.size();i++)
		{
			deleteCommPost(postCodeList.get(i),fileRootPath);
		}
		
		// 테그삭제
		communityMapper.deleteTag(tagCode);
	}
	public void deleteCommunity(String commCode, String fileRootPath) throws IOException {
		
		//커뮤니티에 관련된 모든 포스트 제거.
		List<String> postCodeList = communityMapper.getPostCodeListByCommCode(commCode);	
		for(int i =0;i<postCodeList.size();i++)
		{
			deleteCommPost(postCodeList.get(i),fileRootPath);
		}
		//커뮤니티에 관련된 모든 커뮤니티 회원 가입 정보 삭제.
		communityMapper.deleteCommMemberRegByCommCode(commCode);
		// 커뮤니티에 관련된 모든 테그삭제
		communityMapper.deleteTagByCommCode(commCode);
		// 커뮤니티에 관련된 모든 규칙 삭제
		communityMapper.deleteRuleByCommCode(commCode);
		//커뮤니티 삭제
		communityMapper.deleteCommunityByCommCode(commCode);

	}
	
	

}
