package org.oversky.dreamland.component;

import org.oversky.util.number.DoubleUtils;

public class CalcActorData {

	private CalcActorData() {}
	
	public void calcATK(InitData id, int level) {
		double min = id.getAtk() + 20*(level-1)/25;
		double max = id.getAtk() + 100*(level-1)/25;
		System.out.println("atk = [ " + min + " - " + max + "]");
	}
	
	public void calcDEF(InitData id, int level) {
		double min = id.getDef() + 20*(level-1)*0.2/100 + 50*(level-1)*0.8/100;
		double max = id.getDef() + 100*(level-1)*0.2/100 + 100*(level-1)*0.8/100;
		System.out.println("def = [ " + min + " - " + max + "]");
	}
	
	public void calcMAG(InitData id, int level) {
		double min = id.getMag() + 20*(level-1)/25;
		double max = id.getMag() + 100*(level-1)/25;
		System.out.println("mag = [ " + min + " - " + max + "]");
	}
	
	public void calcMDF(InitData id, int level) {
		double min = id.getMdf() + 20*(level-1)*0.2/100 + 50*(level-1)*0.8/100;
		double max = id.getMdf() + 100*(level-1)*0.2/100 + 100*(level-1)*0.8/100;
		System.out.println("mdf = [ " + min + " - " + max + "]");
	}
	
	public void calcSPD(InitData id, int level) {
		double min = id.getSpd()+ 20*(level-1)/100;
		double max = id.getSpd()+ 100*(level-1)/100;
		System.out.println("spd = [ " + min + " - " + max + "]");
	}
	
	public void calcCRIT(InitData id, int level) {
		double min = id.getCrit()+ DoubleUtils.round(20*0.06*(level-1)/100, 0)*0.05;
		double max = id.getCrit()+ DoubleUtils.round(100*0.06*(level-1)/100, 0)*0.05;
		System.out.println("crit = [ " + DoubleUtils.round(min,2) + " - " + DoubleUtils.round(max,2) + "]");
	}
	
	public void calcAGL(InitData id, int level) {
		double min = id.getAgl()+ DoubleUtils.round(20*0.06*(level-1)/100, 0)*0.05;
		double max = id.getAgl()+ DoubleUtils.round(100*0.06*(level-1)/100, 0)*0.05;
		System.out.println("agl = [ " + DoubleUtils.round(min,2) + " - " + DoubleUtils.round(max,2) + "]");
	}
	
	public void calcHP(InitData id, int level) {
		double min = id.getHp() + 50*(level-1)/2;
		double max = id.getHp() + 100*(level-1)/2;
		System.out.println("hp = [ " + min + " - " + max + "]");
	}
	
	public void calcMP(InitData id, int level) {
		double min = id.getMp() + 50*(level-1)/4;
		double max = id.getMp() + 100*(level-1)/4;
		System.out.println("mp = [ " + min + " - " + max + "]");
	}
	
	public void calcAll(InitData id, int level) {
		System.out.println("=============" + level + "===========");
		this.calcATK(id, level);
		this.calcDEF(id, level);
		this.calcMAG(id, level);
		this.calcMDF(id, level);
		this.calcSPD(id, level);
		this.calcCRIT(id, level);
		this.calcAGL(id, level);
		this.calcHP(id, level);
		this.calcMP(id, level);
	}
	
	public static void main(String[] args) {
		InitData id = new InitData();
		id.setAtk(50);
		id.setMag(50);
		id.setDef(25);
		id.setMdf(25);
		id.setSpd(50);
		id.setAgl(0.1);
		id.setCrit(0.1);
		id.setHp(200);
		id.setMp(100);
		
		CalcActorData cad = new CalcActorData();
		cad.calcAll(id, 1);
		cad.calcAll(id, 2);
		cad.calcAll(id, 3);
		cad.calcAll(id, 6);
		cad.calcAll(id, 11);
		cad.calcAll(id, 21);
		cad.calcAll(id, 51);
		cad.calcAll(id, 101);
	}
	
	static class InitData {
		int atk;
		int def;
		int mag;
		int mdf;
		int spd;
		double crit; //暴击
		double agl; //闪避
		int hp;
		int mp;
		public int getAtk() {
			return atk;
		}
		public void setAtk(int atk) {
			this.atk = atk;
		}
		public int getDef() {
			return def;
		}
		public void setDef(int def) {
			this.def = def;
		}
		public int getMag() {
			return mag;
		}
		public void setMag(int mag) {
			this.mag = mag;
		}
		public int getMdf() {
			return mdf;
		}
		public void setMdf(int mdf) {
			this.mdf = mdf;
		}
		public int getSpd() {
			return spd;
		}
		public void setSpd(int spd) {
			this.spd = spd;
		}
		public double getCrit() {
			return crit;
		}
		public void setCrit(double crit) {
			this.crit = crit;
		}
		public double getAgl() {
			return agl;
		}
		public void setAgl(double agl) {
			this.agl = agl;
		}
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		public int getMp() {
			return mp;
		}
		public void setMp(int mp) {
			this.mp = mp;
		}
		
		
	}
}
