import java.io.*;

public class Game {
    static String black   = "\u001b[30m";
    static String red     = "\u001b[31m";
    static String green   = "\u001b[32m";
    static String yellow  = "\u001b[33m";
    static String blue    = "\u001b[34m";
    static String magenta = "\u001b[35m";
    static String cyan    = "\u001b[36m";
    static String white   = "\u001b[37m";
    static String reset   = "\u001b[0m";

    static int turn=0;
    static Robot robot[];
    static Robot enemy[];

    public static void main (String[] args){
        init();

        while (true) {
          System.out.printf("\033[2J");
          System.out.println(reset+"\u001b[5;1H");
          move();

          drawFrame();
          drawInfo();

          turn++;

          // try{
          //   Thread.sleep(1000);
          // }catch(InterruptedException e){}
          try{
            InputStreamReader reader = new InputStreamReader(System.in);
            int key = reader.read();
          }catch(Exception e){
            e.printStackTrace();
          }
        }
    }

    private static void init(){
        robot=new Robot[3];
        enemy=new Robot[3];

        for(int i=0;i<3;i++){
          enemy[i]=new Zako("ザコ"+(i+1));
          robot[i]=new Zako("味方"+(i+1)); 
        }
        for(int i=0;i<3;i++){
          if(enemy[i]!=null){
            enemy[i].setTarget(robot);
          }
          if(robot[i]!=null){
            robot[i].setTarget(enemy);
          }
        }      
    }

    private static void move(){
      if(turn/3%2==1){
        if(enemy[turn%3]!=null)enemy[turn%3].attack();
      }else{
        if(robot[turn%3]!=null)robot[turn%3].attack();                
      }      
    }

    private static void drawFrame(){
      System.out.println("\u001b[0;0H");
      System.out.println(cyan+"┏━敵━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
      System.out.println(cyan+"┃                   ┃                  ┃                  ┃");
      System.out.println(cyan+"┃                   ┃                  ┃                  ┃");
      System.out.println(cyan+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");      

      System.out.println("\u001b[15;0H");
      System.out.println(blue+"┏━味方━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
      System.out.println(blue+"┃                   ┃                  ┃                  ┃");
      System.out.println(blue+"┃                   ┃                  ┃                  ┃");
      System.out.println(blue+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");      
    }

    private static void drawInfo(){
      String c=white;
      for(int i=0;i<3;i++){
        if(enemy[i]!=null){
          c= enemy[i].getHp()==0 ?red:white;
          System.out.println("\u001b[3;"+(i*20+3)+"H"+c+enemy[i].getName());
          System.out.println("\u001b[4;"+(i*20+3)+"H"+green+enemy[i].getInfo());
        }

        if(robot[i]!=null){
          c= robot[i].getHp()==0 ?red:white;
          System.out.println("\u001b[17;"+(i*20+3)+"H"+c+robot[i].getName());
          System.out.println("\u001b[18;"+(i*20+3)+"H"+green+robot[i].getInfo());
        }
      }      
    }
}