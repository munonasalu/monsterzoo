import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.omg.CORBA.StringHolder;

public class Egg{

  //卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
  //移動するたびに,eggDistanceに1.0kmずつ加算される．
  //3km移動するとランダムでモンスターが孵る
  //double eggDistance[] = new double[9];
  List<double> eggDistance = new ArrayList<double>();
  //boolean egg[] = new boolean[9];
  List<boolean> egg = new ArrayList<boolean>();

  public void judgeEggTrue(int i) {
    if(this.egg.get(i)==true){
      this.eggDistance.set(i,this.eggDistance.get(i)+1)
    }
  }

  public boolean judgeEggFalse(int i) {
    if(this.egg.get(i)==false){
      this.egg.get(i)=true;
      this.eggDistance.get(i)=0.0;
      return true;
    }
    return false;
  }

  public void cheakEgg() {
		for(int i=0;i<this.egg.size();i++){//卵は移動距離が進むと孵化するため，何km移動したかを更新する
			judgeEggTrue(i);
		}
	}

	public void cheakEggNum() {
		//egg[]に10個以上卵がない場合は新しい卵データをセットする
		for(int i=0;i<this.eggDistance.size();i++){
			boolean flag = false;
			flag = judgeEggFalse(i);
			if(flag = true)break;
		}
	}

  public void ifGetEgg(int e) {
    if(e>=1){//卵を1つ以上Getしたら
      //egg[]に10個以上卵がない場合は新しい卵データをセットする
      cheakEggNum();
    }
  }

  //卵生まれた際の表示

  public void resetEgg(int i){
    this.egg.set(i,false);
    this.eggDistance.set(i,0.0)=0.0;
  }

  //Egg系の処理
  public void eggSet(int i){
    if(this.egg.get(i)==true&&this.eggDistance.get(i)>=3){
      int m = printEgg();
      judgeUserMonsterzukanAll(m);
      resetEgg(i);
    }
  }

  public void discoveryEgg(){
    for(int i=0;i<this.egg.size();i++){
      eggSet(i);
    }
  }




}
