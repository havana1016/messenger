package Messenger;

public class FDto {
	String getFr;//친구신청한 아이디
	String setFr;//신청받은 아이디
	Boolean friend;//친구 성립 여부
	public FDto(String getFr, String setFr, Boolean friend) {
		super();
		this.getFr = getFr;
		this.setFr = setFr;
		this.friend = friend;
	}
	public String getGetFr() {
		return getFr;
	}
	public void setGetFr(String getFr) {
		this.getFr = getFr;
	}
	public String getSetFr() {
		return setFr;
	}
	public void setSetFr(String setFr) {
		this.setFr = setFr;
	}
	public Boolean getFriend() {
		return friend;
	}
	public void setFriend(Boolean friend) {
		this.friend = friend;
	}
	@Override
	public String toString() {
		return "FDto [getFr=" + getFr + ", setFr=" + setFr + ", friend=" + friend + "]";
	}
	
	
	
}
