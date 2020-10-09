

public class MonsterZoo {
	double distance=0.0;//歩いた距離
	int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	double eggDistance[] = new double[9];
	boolean egg[] = new boolean[9];

	//ユーザがGetしたモンスター一覧
	String userMonster[] = new String[100];

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	String monsterZukan[] = new String[22];
	double monsterRare[] = new double[22];

	//呼び出すと1km distanceが増える
	void move(){
		this.distance++;
		cheakEgg();//卵は移動距離が進むと孵化するため，何km移動したかを更新する

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター

		//動物園発見時処理
		seeZooStation(flg1);

		//モンスター発見時処理
		if(!(flg1<=1) && flg1>=7){
			int m = randomMonsterNum();//monsterZukanからランダムにモンスターを出す
			System.out.println(this.monsterZukan[m]+"が現れた！");
			for(int i=0;i<3&&this.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
				attackMonster(m);
				//モンスター遭遇時処理
				boolean flag = false;
				flag = catchMonster(m,r);
				if(flag = true)break;
				escapeMonster(m,r);
			}
		}

		//卵処理and終了処理
		for(int i=0;i<this.egg.length;i++){
			eggSet(i);
		}
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


	public void judgeEggTrue(int i) {
		if(this.egg[i]==true){
			this.eggDistance[i]++;
		}
	}

	public boolean judgeEggFalse(int i) {
		if(this.egg[i]==false){
			this.egg[i]=true;
			this.eggDistance[i]=0.0;
			return true;
		}
		return false;
	}

	public boolean judgeUserMonsterzukan(int j,int m) {
		if(this.userMonster[j]==null){
			this.userMonster[j]=this.monsterZukan[m];
			return true;
		}
		return false;
	}

	public void judgeUserMonsterzukanAll(int m){
		for(int j=0;j<userMonster.length;j++){
			boolean flag = false;
			flag = judgeUserMonsterzukan(j,m);
			if(flag = true)break;
		}
	}

	//cheak

	public void cheakEgg() {
		for(int i=0;i<this.egg.length;i++){//卵は移動距離が進むと孵化するため，何km移動したかを更新する
			judgeEggTrue(i);
		}
	}

	public void cheakEggNum() {
		//egg[]に10個以上卵がない場合は新しい卵データをセットする
		for(int i=0;i<this.eggDistance.length;i++){
			boolean flag = false;
			flag = judgeEggFalse(i);
			if(flag = true)break;
		}
	}

	//if get

	public void ifGetEgg(int e) {
		if(e>=1){//卵を1つ以上Getしたら
			//egg[]に10個以上卵がない場合は新しい卵データをセットする
			cheakEggNum();
		}
	}

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
	public int randomMonsterNum(){
		return (int)(this.monsterZukan.length*Math.random());//monsterZukanからランダムにモンスターを出す
	}

	//卵生まれた際の表示
	public int printEgg(){
		System.out.println("卵が孵った！");
		int m = randomMonsterNum();//monsterZukanからランダムにモンスターを出す
		System.out.println(this.monsterZukan[m]+"が産まれた！");
		return m;
	}

	public void resetEgg(int i){
		this.egg[i]=false;
		this.eggDistance[i]=0.0;
	}

	//Egg系の処理
	public void eggSet(int i){
		if(this.egg[i]==true&&this.eggDistance[i]>=3){
			int m = printEgg();
			judgeUserMonsterzukanAll(m);
			resetEgg(i);
		}
	}

	//monster
	public boolean catchMonster(int m,int r){
		if(this.monsterRare[m]<=r){//monsterRare[m]の値がr以下の場合
			System.out.println(this.monsterZukan[m]+"を捕まえた！");
			judgeUserMonsterzukanAll(m);
			return true;//ボール投げ終了
		}
		return false;
	}

	public void escapeMonster(int m,int r){
		if(!(this.monsterRare[m]<=r)){
			System.out.println(this.monsterZukan[m]+"に逃げられた！");
		}
	}

	public void useBalls(int m){
		System.out.println(this.monsterZukan[m]+"にボールを投げた");
		this.balls--;
	}

	public void attackMonster(int m){
		int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
		useFruit(r);
		useBalls(m);
	}




}
