package Messenger1;

import java.util.List;
import java.util.Scanner;

class set extends Re {
	Scanner sc = new Scanner(System.in);

	String getid() {
		System.out.print("아이디를 입력하세요 > ");
		return sc.next();
	}

	String getname() {
		System.out.print("이름을 입력하세요 > ");
		return sc.next();
	}

	String getpw() {
		System.out.print("비밀번호를 입력하세요 > ");
		return sc.next();
	}
	
	

}


/////////////////////////////////////////////////////////////////////////

public class Ms extends set {

	Integer logindex;
	String logid;
	
	
	void save() {
		String id = getid();
		Integer index = idc(id);
		if (index == null) {
			MDto mem = new MDto(id, getpw(), getname());
			if (save1(mem) == true) {
				System.out.println("가입을 축하 합니다.");
			} else {
				System.out.println("가입이 거절 되었습니다.");
			}
		} else {
			System.out.println("중복된 아이디입니다.");
		}
	}



	void login() {
		String id = getid();
	 Integer index=idc(id);
	 if(index!=null) {
		 if(getpw().equals(mlist.get(index).getPw())){
			 System.out.println(mlist.get(index).getName()+"님 반갑습니다.");
			 logindex=index;
			 logid=id;
	 }else {
		 System.out.println("아이디 또는 비밀번호를 확인해주세요.");
	 }
 }else {
	 System.out.println("존재 하지 않는 아이디 입니다.");
 }
	 
 }
	void logout() {
		logindex=null;
		logid=null;
	}
	
	void loginmenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 친구 확인   2. 친구 신청   3. 메시지함   4. 나가기");
			System.out.print("선택 > ");
			int sn=sc.nextInt();
			if(sn==1) {
				
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////
	
	void plz() {
		String yesfr=getid();
		if(yesfr!=null) {
			FDto mem = new FDto(logid,yesfr,null);
			if(addflist(mem)==true) {
				System.out.println("친구 신청이 완료 되었습니다.");
			}
		}else {
			System.out.println("존재 하지 않는 친구입니다.");
		}
	}
	
	void frc(int sn){
		List<FDto> result = null;
		if(sn==0) {
			result=frc(sn,logid);
		}else if (sn==1) {
			result=frc(sn,logid);
		}else if (sn==2) {
			result=frc(sn,logid);
		}
		for(FDto a: result) {
			System.out.println(a);
		}
	}
	
	void yes() {
		frc(7,logid);
	}
	void no() {
		frc(8,logid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}