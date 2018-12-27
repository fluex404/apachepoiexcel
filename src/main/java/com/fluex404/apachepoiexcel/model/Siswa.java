package com.fluex404.apachepoiexcel.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Siswa {
    private int id;
    private String name;
    private String kelas;
    private String jurusan;

    public Siswa(){

    }

}
