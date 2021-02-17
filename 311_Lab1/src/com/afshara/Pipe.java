package com.afshara;
interface Pipe{
    public boolean put(Object obj);
    public Object get() throws InterruptedException;
}

