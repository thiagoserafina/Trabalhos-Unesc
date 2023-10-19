/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.whaise.javafit.Get;

/**
 *
 * @author henry
 */
public class GetLocalidade {
    private String gen,bairro,cidade,estado,uf,pais;
    
    public GetLocalidade(String gen,String bairro,String cidade, String estado, String uf, String pais){
        this.gen = gen;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.uf = uf;
        this.pais = pais;
    }
    public String GetGen(){
        return gen;
    }
    public String GetBairro(){
        return bairro;
    }
    public String GetCidade(){
        return cidade;
    }
    public String GetEstado(){
        return estado;
    }
    public String GetUF(){
        return uf;
    }
    public String GetPais(){
        return pais;
    }
}
