package Messenger;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Serv ss = new Serv();

		while (true) {
			int sn = ss.mainmenu();
			if (sn == 111) {
				ss.test();
			} else if (sn == 222) {

			} else if (sn == 1) {
				ss.save();
			} else if (sn == 2) {

				boolean bool = ss.login();
				if (bool == true) {
					ss.friend();
				} 
			}
		}
	}
}
