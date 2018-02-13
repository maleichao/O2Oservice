package com.tykj.util;

//线程池中工作的线程
public class AccessDBThread implements Runnable {

  private String msg;
   
  public AccessDBThread() {
      super();
  }

  public AccessDBThread(String msg) {
      this.msg = msg;
  }

  public String getMsg() {
      return msg;
  }

  public void setMsg(String msg) {
      this.msg = msg;
  }

public void run() {
	System.out.println("Added the message: "+msg+" into the Database");
	
}



}
