public class Original extends Robot{
    Original(String name){
    super(name);
    hp=300;
    atk=50;
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


