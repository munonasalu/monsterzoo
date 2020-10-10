public class Event{

  	//ユーザがGetしたモンスター一覧
  	//String userMonster[] = new String[100];
  	List<String> userMonster = new ArrayList<String>();

  	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
  	//レア度が高いほうが捕まえにくい
  	//String monsterZukan[] = new String[22];
  	List<String> monsterZukan = new monsterZukan<String>();
  	//double monsterRare[] = new double[22];
  	List<double> monsterRare = new monsterRare<double>();

    public void discoveryMonster(int flg1){
  		if(!(flg1<=1) && flg1>=7){
  			int m = randomMonsterNumber();//monsterZukanからランダムにモンスターを出す
  			printMonster(m);
  			challengeMonster(m);
  		}
  	}

    public void challengeMonster(int m){
      for(int i=0;i<3&&this.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
        int r = attackMonster(m);
        //モンスター遭遇時処理
        boolean flag = false;
        flag = catchMonster(m,r);
        if(flag = true)break;
        escapeMonster(m,r);
      }
    }

    public int attackMonster(int m){
      int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
      useFruit(r);
      useBalls(m);
      return r;
    }

    public void printMonster(int m){
      System.out.println(this.monsterZukan.get(i)+"が現れた！");
    }

    //monster
    public boolean catchMonster(int m,int r){
      if(this.monsterRare.get(i)<=r){//monsterRare[m]の値がr以下の場合
        System.out.println(this.monsterZukan.get(i)+"を捕まえた！");
        judgeUserMonsterzukanAll(m);
        return true;//ボール投げ終了
      }
      return false;
    }

    public void escapeMonster(int m,int r){
      if(!(this.monsterRare.get(i)<=r)){
        System.out.println(this.monsterZukan.get(i)+"に逃げられた！");
      }
    }

    public int randomMonsterNumber(){
      return (int)(this.monsterZukan.size()*Math.random());//monsterZukanからランダムにモンスターを出す
    }

    //set number
  	public void setItemEgg() {
  		int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
  		int f=(int)(Math.random()*2);
  		int e=(int)(Math.random()*2);
  		System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
  		addItemAll(b,f);
  		ifGetEgg(e);
  	}




}
