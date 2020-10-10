public class Printer{
  public int printEgg(){
    System.out.println("卵が孵った！");
    int m = randomMonsterNum();//monsterZukanからランダムにモンスターを出す
    System.out.println(this.monsterZukan[m]+"が産まれた！");
    return m;
  }
}
