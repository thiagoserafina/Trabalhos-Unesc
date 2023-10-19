/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.whaise.javafit.Get;

/**
 *
 * @author henry
 */
public class GetUsuario {
    private String nome,login,gen;
    
    public GetUsuario(String gen,String nome,String login){
        this.gen = gen;
        this.nome = nome;
        this.login = login;
    }
    public String GetGen(){
        return gen;
    }
    public String GetNome(){
        return nome;
    }
    public String GetLogin(){
        return login;
    }
}
