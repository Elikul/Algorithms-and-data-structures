package Game;

import java.util.Random;

class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();

        Random randomHeal = new Random();
        Random randomDamage = new Random();
        Random randomAddHeal = new Random();


        Hero[] team1 = new Hero[]{new Warrior(randomHeal.nextInt(50) + 200, "Тигрил", randomDamage.nextInt(20) + 50, 0)
                , new Assasin(randomHeal.nextInt(50) + 100, "Акали", randomDamage.nextInt(20) + 70, 0)
                , new Doctor(randomHeal.nextInt(50) + 100, "Жанна", 0, randomAddHeal.nextInt(20) + 40)};


        Hero[] team2 = new Hero[]{new Warrior(randomHeal.nextInt(50) + 200, "Минотавр", randomDamage.nextInt(20) + 50, 0)
                , new Assasin(randomHeal.nextInt(50) + 100, "Джинкс", randomDamage.nextInt(20) + 70, 0)
                , new Doctor(randomHeal.nextInt(50) + 100, "Зои", 0, randomAddHeal.nextInt(20) + 40)};


        int d1, d2;
        do{
            for (int i = 0; i < team1.length; i++) {
                if(randomStep.nextInt(2) == 0) {
                    if(team1[i] instanceof Doctor) {
                        team1[i].healing(team1[randomHealing.nextInt(2)]);
                    } else {
                        team1[i].hit(team2[i]);
                    }
                } else {
                    if(team2[i] instanceof Doctor) {
                        team2[i].healing(team2[randomHealing.nextInt(2)]);
                    } else {
                        team2[i].hit(team1[i]);
                    }
                }
            }
            d1 = 0;
            d2 = 0;
            for (Hero t1: team1) {
                if(t1.isDead()){
                    d1++;
                }
            }

            for (Hero t2: team2) {
                if(t2.isDead()){
                    d2++;
                }
            }
        }while ((d1 != team1.length) || (d2 != team2.length));

        System.out.println("---------------");

        for (Hero t1: team1) {
            t1.info();
        }

        for (Hero t2: team2) {
            t2.info();
        }
    }
}