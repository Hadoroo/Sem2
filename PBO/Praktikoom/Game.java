// import java.util.*;

// public class Game {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner (System.in);     
//         int t = sc.nextInt();
//         Character character = new Character();
//         Monster monster = new Monster();
//         for (int i = 0; i < t; i++){
//             character.addChar();
//             monster.addMons();
//             character.addAddon();
//             character.upgrade();
//             character.attack(monster);
//             character.print(monster);

//         }       
//     }
// }
// class Character{
//     Scanner sc = new Scanner (System.in);
//     public long hc;
//     public long dc;
//     public long coin;
//     public long dmgUp;
//     public long hpUp;

//     public void addChar(){
//         this.hc = sc.nextLong();
//         this.dc = sc.nextLong();
//     }
//     public void addAddon(){
//         this.coin = sc.nextLong();
//         this.dmgUp = sc.nextLong();
//         this.hpUp = sc.nextLong();
//     }
//     public void upgrade(){
//         if (this.coin%2 == 0){
//             long up = this.coin/2;
//             hc += hpUp*up;
//             dc += dmgUp+up;
//         }else if (this.coin%2 == 1){
//             long up1 = (this.coin-1)/2;
//             long up2 = up1 + 1;
//             hc += hpUp*up1;
//             dc += dmgUp*up2;
//         }
//     }
//     public void attack(Monster monster){
//         while (hc>0){
//         monster.hm -= dc;
//         this.hc -= monster.dm;
//         }
//     }
//     public void print(Monster monster){
//         if (this.hc > monster.hm){
//             System.out.println("YES");
//         }else{
//             System.out.println("NO");
//         }
//     }
    
// }
// class Monster{
//     Scanner sc = new Scanner (System.in);
//     public long hm;
//     public long dm;
    
//     public void addMons(){
//         this.hm = sc.nextLong();
//         this.dm = sc.nextLong();
//     }
// }