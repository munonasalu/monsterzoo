public class Item{

  int balls=10;//モンスターを捕まえられるボールの数
  int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

  public void addBalls(int b) {
		this.balls=this.balls+b;
	}

	public void addFruits(int f) {
		this.fruits=this.fruits+f;
	}

  public void useFruit(int r){
    if(this.fruits>0){
      System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
      this.fruits--;
      r = r * 2;
    }
  }

  public void useBalls(int m){
    System.out.println(this.monsterZukan.get(m)+"にボールを投げた");
    this.balls--;
  }

  public void addItemAll(int b,int f,int e) {
    addBalls(b);
    addFruits(f);
  };

}
