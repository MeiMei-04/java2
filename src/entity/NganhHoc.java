/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HieuCute
 */
public class NganhHoc {
    private String manh;
    private String tennh;

    public NganhHoc() {
    }

    public NganhHoc(String manh, String tennh) {
        this.manh = manh;
        this.tennh = tennh;
    }

    public String getManh() {
        return manh;
    }

    public void setManh(String manh) {
        this.manh = manh;
    }

    public String getTennh() {
        return tennh;
    }

    public void setTennh(String tennh) {
        this.tennh = tennh;
    }
    
}
