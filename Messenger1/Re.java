package Messenger1;

import java.util.ArrayList;
import java.util.List;

public class Re {
	
	static List<MDto>mlist=new ArrayList<>();
	static List<FDto>flist=new ArrayList<>();
	static List<TDto>tlist=new ArrayList<>();
	boolean save1(MDto mem) {
		return mlist.add(mem);
	}
	
	boolean addflist(FDto mem) {
		return flist.add(mem);
	}
	
	
	
	Integer idc(String id) {
		Integer index=null;
		for (int i =0 ;i<mlist.size();i++) {
			if(id.equals(mlist.get(i).getId())) {
				index=i;
				break;
			}
		}return index;
	}
	
	
	List<FDto> frc(int sn,String id) {
		List<FDto> result =new ArrayList<>();
		result=null;
		for (int i=0;i<flist.size();i++) {
			String plz=flist.get(i).getPlzfr();
			String yes=flist.get(i).getYesfr();
			Boolean bool=flist.get(i).getFr();
			if(sn==0) {
			if((id.equals(plz) || id.equals(yes)) && bool==true) {
				result.add(flist.get(i));
			}}else if(sn==1) {
				if(id.equals(plz) && bool==null) {
					result.add(flist.get(i));
				}
			}else if(sn==2) {
				if(id.equals(yes) && bool==null) {
					result.add(flist.get(i));
				}
			}else if(sn==7) {
				if(id.equals(yes) && bool==null) {
					flist.get(i).setFr(true);
				}
			}else if(sn==8) {
				if(id.equals(yes) && bool==null) {
					flist.get(i).setFr(false);
				}
			}
		}return result;
	}
	
	void yes(String id){
		
	}
	
	
	
}
