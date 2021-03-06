package textView;

import java.util.Scanner;
import java.util.Vector;

import constants.Config.FPath;
import control.CLecture;
import valueObject.OIndex;
import valueObject.OLecture;

public class VLecture{
	protected Scanner scanner;
	private CLecture cLecture;
	
	public VLecture() {}
	
	
	public VLecture(Scanner scanner) {
		this.scanner = scanner;
		this.cLecture = new CLecture();
	}

	public OIndex show(String id, String fileName, String message) {
		
		Vector<OLecture> lectures = cLecture.getAll(FPath.lecturesPath + fileName);
		for(OLecture lecture : lectures) {
			System.out.println(lecture.toString());
		}
		OLecture oLecture = new OLecture();
		for(OLecture lecture : lectures) {
			if(lecture.getId().equals(id)) {
				oLecture = lecture;
			}
		}
		
		while (true) {
			System.out.println("즉시 신청(1), 미리 담기(2), 취소(0)");
			String input = scanner.next();
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				// 수강 신청 내역에 추가
				this.cLecture.saveInEnrollmentList(id, oLecture);
				break;
			} else if (input.equals("2")) {
				// 미리 담기 내역에 추가
				this.cLecture.saveInBasket(id, oLecture);
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		return oLecture;
	}
	
	
}
