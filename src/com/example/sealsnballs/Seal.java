package com.example.sealsnballs;


public class Seal {
    private int x, y, val;
    private Boolean is_hit;
    
    Seal(int x, int y, int val, Boolean is_hit){
    	this.x = x;
    	this.y = y;
    	this.val = val;
    	this.is_hit = false;
    }
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public void setVal(int val) { this.val = val; }  
    public void setHitStatus(Boolean is_hit){ this.is_hit = is_hit; }
    
    
    public int getX(){ return x; }
    public int getY(){ return y; }
    public int getVal(){ return val; }
    public Boolean getHitStatus(){ return is_hit; }
    	
}

