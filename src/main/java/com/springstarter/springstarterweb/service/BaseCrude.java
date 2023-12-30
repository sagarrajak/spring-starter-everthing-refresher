package com.springstarter.springstarterweb.service;

public interface BaseCrude<T, R> {
    public void save();

    public void findAll();

    public void findOne();

    public void updateOne();
}
