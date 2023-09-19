package handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.boardController;

public class fileHandler {
	private static final Logger log = LoggerFactory.getLogger(fileHandler.class);
	
	//파일 이름과 경로를 받아서 파일을 삭제하는 메서드
	//리턴타입 boolean(isDel) => 잘 삭제했는지 체크하기 위한 변수
	public int deleteFile(String imageFileName, String savePath) {
		boolean isDel = true; //삭제가 잘 이루어졌는지 체크하는 변수
		log.info("imageFileName >> "+imageFileName);
		
		File fileDir = new File(savePath);
		File removeFile = new File(fileDir+File.separator+imageFileName);
		File removeThFile = new File(fileDir+File.separator+"_th_"+imageFileName);
		
		//현재 시점에서 삭제하고자 하는 파일이 있어야(존재해야) 삭제
		if(removeFile.exists() || removeThFile.exists()) { //exists 있으면 true, 없으면false를 반환
			isDel = removeFile.delete(); //boolean 형태로 리턴
			log.info(">>>>>>del : "+(isDel?"OK":"FAIL"));
			if(isDel) {
				isDel = removeThFile.delete(); //파일이 잘 지워졌다면 썸네일파일도 지워줌
				log.info(">>>>>>thFile del : "+(isDel?"OK":"FAIL"));
			}
		}
		log.info("remove File Ok");
		
		return isDel? 1:0;
		
	}
}
