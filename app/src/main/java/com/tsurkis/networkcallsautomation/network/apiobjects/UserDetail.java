package com.tsurkis.networkcallsautomation.network.apiobjects;

public class UserDetail
{
    private Data data;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "UserDetail [data = "+data+"]";
    }
}
