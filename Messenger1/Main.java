package Messenger1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ms ms = new Ms();
		while(true) {
			System.out.println();
			System.out.println("1. 회원가입   2. 로그인   3.종료");
			System.out.print("선택 > ");
			int sn=sc.nextInt();
			if(sn==111) {
				
			}else if(sn==222) {
				
			}else if(sn==1) {
				ms.save();
			}else if(sn==2) {
				ms.login();
				
			}else if(sn==3) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}

}
