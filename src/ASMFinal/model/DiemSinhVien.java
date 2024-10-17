/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASMFinal.model;

/**
 *
 * @author ADMIN
 */
public class DiemSinhVien {

    public int ID = 1;
    public String MaSV = "";
    public String HoTen = "";
    public int TiengAnh = 0;
    public int TinHoc = 0;
    public int GDTC = 0;
    public double DiemTB = 0;

    public DiemSinhVien(int ID, String MaSV, String HoTen, int TiengAnh, int TinHoc, int GDTC, double DiemTB) {
        this.ID = ID;
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
        this.DiemTB = DiemTB;
    }

}
