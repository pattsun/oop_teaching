import java.util.Random;
public abstract class Robot{
  protected String name;
  protected int hp,atk;
  protected Robot target[];
  protected static Random rnd=new Random();

  Robot(String name){
    this.name=name;
    target=new Robot[3];
  }

  public String getName(){
    return name;
  }
  public String getInfo(){
    return "HP:"+hp+" 攻撃:"+atk;
  }
  public int getHp(){
    return hp;
  }
  public int getAtk(){
    return atk;
  }

  public void setTarget(Robot[] robot){
    target=robot;
  }
  public void damage(int pow){
    hp-=pow;
    if(hp<0)hp=0;
  }
  public abstract void attack();
}