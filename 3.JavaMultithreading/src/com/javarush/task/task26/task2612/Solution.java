package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();


    public void someMethod() {
        try {
            if (lock.tryLock()){
                actionIfLockIsFree();

            }else actionIfLockIsBusy();

        } catch (Exception e){lock.unlock();
        }
        // Implement the logic here. Use the lock field
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }

//    public static void main(String[] args) {
//        new Solution().someMethod();
//    }
}
