public class Event{

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
      System.out.println(this.monsterZukan[m]+"が現れた！");
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

    public int randomMonsterNumber(){
      return (int)(this.monsterZukan.size()*Math.random());//monsterZukanからランダムにモンスターを出す
    }





}
