package Messenger;

import java.util.ArrayList;
import java.util.List;

public class RE {

	static int num = 0;

	static List<MDto> mlist = new ArrayList<>();
	static List<FDto> flist = new ArrayList<>();

	boolean addmlist(MDto mem) {
		return mlist.add(mem);
	}

	boolean addflist(FDto mem) {
		return flist.add(mem);
	}

	Integer findfr1(int sn, String id) {
		List<FDto> rlist = new ArrayList<>();
		Integer findex = null;
		System.out.println("flist size : "+flist.size());

		for (int i = 0; i < flist.size(); i++) {
			String sfr = flist.get(i).getSetFr();
			String gfr = flist.get(i).getGetFr();
			Boolean bool = flist.get(i).getFriend();
			if (flist.size() == 0 || (!id.equals(sfr) && !id.equals(gfr))) {
				
			} else {
				if (sn == 0 && id.equals(sfr) || id.equals(gfr)) {
					findex = i;
				} else if (sn == 1 && (id.equals(sfr) || id.equals(gfr)) && bool == true) {
					System.out.println(flist.get(i));
				} else if (sn == 2 && id.equals(sfr) && bool == null) {
					System.out.println(flist.get(i));
				} else if (sn == 2 && id.equals(gfr) && bool == null) {
					System.out.println(flist.get(i));
				}

			}
		}
		return findex;
	}
	/*
	 * else if(sn != 1) { System.out.println("아직 친구가 없습니다."); }
	 */

	void whatfr(int sn, int findex) {
		if (sn == 1) {
			flist.get(findex).setFriend(true);
		} else if (sn == 2) {
			flist.get(findex).setFriend(false);
		}
	}

}