package textView;

import java.util.Scanner;

import valueObject.OMember;

public class VInitial {
	private Scanner scanner;
	private VRegistration registration;
	private VLogin login;
	private VLectureSearch lectureSearch;

	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.registration = new VRegistration(scanner);
		this.login = new VLogin(scanner);

	}

	public void show() {
		System.out.println("���� ����� �����ϼ���");
		
		while (true) {
			System.out.println("�α���(1), ȸ�����(2), ����(0)");
			String input = this.scanner.next();
			if (input.equals("1")) {
				OMember oMember = this.login.show();
				if(oMember != null) {
					this.lectureSearch = new VLectureSearch(this.scanner);
					this.lectureSearch.show(oMember);
				}
				break;
			} else if (input.equals("2")) {
				this.registration.show();
			}else if(input.equals("0")){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}