package view;

import java.util.Scanner;

public class VInitial {
	private VRegistration registration;
	private VLogin login;

	public VInitial() {
		this.registration = new VRegistration();
		this.login = new VLogin();

	}

	public void show() {
		System.out.println("���� ����� �����ϼ���");
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("�α���(1), ȸ�����(2), ����(0)");
			String input = scanner.next();
			if (input.equals("1")) {
				this.login.show();
				break;
			} else if (input.equals("2")) {
				this.registration.show();
				this.login.show();
				break;
			}else if(input.equals("0")){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}