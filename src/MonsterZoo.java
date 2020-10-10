

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.omg.CORBA.StringHolder;

public class MonsterZoo {
	double distance=0.0;//歩いた距離
	int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//ユーザがGetしたモンスター一覧
	//String userMonster[] = new String[100];
	List<String> userMonster = new ArrayList<String>();

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	//String monsterZukan[] = new String[22];
	List<String> monsterZukan = new monsterZukan<String>();
	//double monsterRare[] = new double[22];
	List<double> monsterRare = new monsterRare<double>();

	//呼び出すと1km distanceが増える
	void move(){
		this.distance++;
		cheakEgg();//卵は移動距離が進むと孵化するため，何km移動したかを更新する
		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		//動物園発見時処理
		seeZooStation(flg1);
		//モンスター発見時処理
		discoveryMonster(flg1);
		//卵処理and終了処理
		discoveryEgg();
	}

	public double getDistance() {
		return distance;
	}

	public int getBalls() {
		return balls;
	}

	public int getFruits() {
		return fruits;
	}

	public String[] getUserMonster() {
		return userMonster;
	}

	public void setMonsterZukan(String[] monsterZukan) {
		this.monsterZukan = monsterZukan;
	}

	public void setMonsterRare(double[] monsterRare) {
		this.monsterRare = monsterRare;
	}

	// judge







	public boolean judgeUserMonsterzukan(int j,int m) {
		if(this.userMonster.get(j)==null){
			this.userMonster.set(j,this.monsterZukan.get(m));
			return true;
		}
		return false;
	}

	public void judgeUserMonsterzukanAll(int m){
		for(int j=0;j<this.userMonster.size();j++){
			boolean flag = false;
			flag = judgeUserMonsterzukan(j,m);
			if(flag = true)break;
		}
	}

	//cheak



	//if get

	public void addBalls(int b) {
		this.balls=this.balls+b;
	}

	public void addFruits(int f) {
		this.fruits=this.fruits+f;
	}

	public void addAll(int b,int f,int e) {
		addBalls(b);
		addFruits(f);
		ifGetEgg(e);
	};

	//use

	public void useFruit(int r){
		if(this.fruits>0){
			System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
			this.fruits--;
			r = r * 2;
		}
	}

	//set number
	public void setNumber() {
		int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
		int f=(int)(Math.random()*2);
		int e=(int)(Math.random()*2);
		System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
		addAll(b,f,e);
	}

	//seeZOO
	public void seeZooStation(int flg1){
		if(flg1<=1){
			System.out.println("ズーstationを見つけた！");
			setNumber();
		}
	}

	//randomCreate




	public void useBalls(int m){
		System.out.println(this.monsterZukan.get(m)+"にボールを投げた");
		this.balls--;
	}







}
