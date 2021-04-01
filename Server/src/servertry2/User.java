/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertry2;

/**
 *
 * @author ELROWAD
 */
public class User {
   int id;
   String name;
   ChatHandler ch;
   String symbol;
   int score;
   
   public  User(int id,String name,ChatHandler ch,int score){
       this.id    = id;
       this.name  = name;
       this.ch    = ch;
       this.score = score;
   }
}
