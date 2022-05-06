package Messenger;

import java.util.Scanner;

class Setting extends RE {
	Scanner sc = new Scanner(System.in);
	Integer mIndex = null;
	String logid = null;
	static int num = -1;

	void test() {
		System.out.println("테스트 모드 실행");
		System.out.println("mlist 출력" + mlist);
	}

	String getid() {
		System.out.print("아이디를 입력 하세요 > ");
		return sc.next();
	}

	String getpw() {
		System.out.print("비밀번호를 입력 하세요 > ");
		return sc.next();
	}

	String getname() {
		System.out.print("이름을 입력 하세요 > ");
		return sc.next();
	}

}

public class Serv extends Setting {

	Integer idc(String id) {
		Integer index = null;
		if (mlist.size() != 0) {
			for (int i = 0; i < mlist.size(); i++) {
				if (id.equals(mlist.get(i).getId())) {
					index = i;
					break;
				}
			}
		}
		return index;
	}

	boolean login() {
		boolean bool = false;
		if (mIndex == null) {
			String id = getid();
			Integer index = idc(id);

			if (index != null) {
				if (getpw().equals(mlist.get(index).getPw())) {
					mIndex = index;
					logid = id;
					System.out.println();
					System.out.println(mlist.get(index).getName() + "님 반갑습니다.");
					System.out.println();
					findfr();
					bool = true;
				} else {
					System.out.println();
					System.out.println("아이디 또는 비밀번호를 확인하세요");
					System.out.println();
				}
			}
		}
		return bool;
	}

	void save() {
		String id = getid();
		if (idc(id) == null) {
			String pw = getpw();
			String name = getname();
			num = ++num;
			MDto mem = new MDto(num, id, pw, name);
			if (addmlist(mem) == true) {
				System.out.println();
				System.out.println("회원 가입이 완료 되었습니다.");
				System.out.println();

			}

		} else {
			System.out.println("중복된 아이디 입니다.");
		}
	}

	void addfr() {
		System.out.println("친구신청 할 아이디를 입력해주세요~");
		String getfr = getid();
		if (idc(getfr) != null) {
			String setfr = mlist.get(mIndex).getId();
			if (!getfr.equals(setfr)) {
				Boolean friend = null;
				FDto fr = new FDto(setfr, getfr, friend);
				if (addflist(fr) == true) {
					System.out.println("친구 신청이 완료 되었습니다.");
				}
			} else {
				System.out.println("본인의 아이디 말고 다른 아이디를 입력해주세요~");
			}
		} else {
			System.out.println("존재하지 않는 친구입니다.");
		}
	}

	void findfr() {
		Integer findex = findfr1(0, logid);
		if (findex != null) {
			System.out.println(flist.get(findex).getGetFr() + "님이 친구 신청 하였습니다. ");
			System.out.println("수락하시겠습니까?");
			System.out.print("1. 수락   2. 거절   3.다음에");
			System.out.print("선택 > ");
			int sn = sc.nextInt();
			if (sn == 1) {
				whatfr(1, findex);
				System.out.println("친구등록이 완료 되었습니다.");
			} else if (sn == 2) {
				whatfr(2, findex);
				System.out.println("친구맺기를 거절하였습니다.");
			} else if (sn == 3) {
				System.out.println("다음번 로그인때 다시 알려드리겠습니다.");
			}
		}

	}

	/*
	 * void myfr(int sn) {
	 * 
	 * if (sn == 2) { findfr1(2, logid); } else if (sn == 3) { findfr1(4, logid); }
	 * else if (sn == 4) { findfr1(3, logid); } }
	 */

	void logout() {
		mIndex = null;
		logid = null;
		System.out.println("로그아웃 되었습니다.");
	}

	void end() {
		System.out.println("프로그램을 종료합니다.");
		mIndex = null;
		logid = null;
	}

	void friend() {
		while (true) {
			System.out.println();
			System.out.println("1. 친구보기   2. 친구신청   3. 로그아웃");
			System.out.print("선택 > ");
			int sn = sc.nextInt();
			System.out.println();
			if (sn == 1) {
				Integer findex = findfr1(0, logid);
				if (findfr1(0, logid) != null) {
					while (true) {
						System.out.println("1. 내 친구   2. 내가 신청한 친구   3. 나를 신청한 친구   4 . 나가기");
						System.out.print("선택 > ");
						sn = sc.nextInt();
						if (sn == 1) {
							findfr1(1, logid);
						} else if (sn == 2) {
							findfr1(2, logid);
						} else if (sn == 3) {
							findfr1(3, logid);
						} else if (sn == 4) {
							break;
						}
					}
				} else {
					System.out.println("아직 친구가 없어요~ 친구 신청을 먼저 해주세요~");
				}
			} else if (sn == 2) {
				addfr();

			} else if (sn == 3) {
				logout();
				break;
			}
		}
	}

	int mainmenu() {
		System.out.println("1. 회원 가입   2. 로그인   3.종료");
		System.out.print("선택 > ");
		int sn = sc.nextInt();
		System.out.println();
		return sn;
	}

}
