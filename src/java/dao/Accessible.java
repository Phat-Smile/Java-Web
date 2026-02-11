/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author ACER
 */
public interface Accessible<T> {

    //Create
    int insert(T obj);

    //Read
    List<T> listAll();

    //Update
    int update(T obj);

    //Delete
    int delete(T obj);

    T searchById(String id);
}
