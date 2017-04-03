public class Zako extends Robot{
  Zako(String name){
    super(name);
    hp=30;
    atk=5;
  }

  @Override
  public void attack(){
    if(hp==0){
      System.out.println(name+"は死んでいる。");
      return;
    }

    int n=rnd.nextInt(3);
    if(target[n]==null){
      System.out.println(name+"は様子を見ている。");
    }else{
      System.out.println(name+"は"+target[n].getName()+"に攻撃した。");
      target[n].damage(atk);
    }
  }
}