/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SinhVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuCute
 */
public class SinhVienDao {

    Connection connection;

    public SinhVienDao() throws Exception {
        connection = ulitiles.DBContext.getConnection();
    }

    public List<SinhVien> getAllData() {
        List<SinhVien> lst = new ArrayList<>();
        String sql = "SELECT masv,tensv,diem,tennh FROM SinhVien\n"
                + "JOIN NganhHoc on SinhVien.manh = NganhHoc.manh";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                String masv = resultSet.getString("masv");
                String manh = resultSet.getString("tennh");
                String tensv = resultSet.getString("tensv");
                double diem = resultSet.getDouble("diem");
                SinhVien sv = new SinhVien(masv, manh, tensv, diem);
                lst.add(sv);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return null;
        }
    }
    public boolean addSinhVien(SinhVien sinhVien){
        System.out.println("Mã sv: "+sinhVien.getMasv());
        String sql = "INSERT INTO SinhVien (masv, manh, tensv, diem) VALUES\n"
                +"(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sinhVien.getMasv());
            preparedStatement.setString(2,sinhVien.getManh());
            preparedStatement.setString(3,sinhVien.getTensv());
            preparedStatement.setDouble(4,sinhVien.getDiem());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Mã Lỗi: "+e);
            return false;
        }
    }
    public boolean updateSinhVien(SinhVien sinhVien){
        String sql = "UPDATE SinhVien SET manh =?,tensv=?,diem=? where masv = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(4,sinhVien.getMasv());
            preparedStatement.setString(1,sinhVien.getManh());
            preparedStatement.setString(2,sinhVien.getTensv());
            preparedStatement.setDouble(3,sinhVien.getDiem());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Mã Lỗi: "+e);
            return false;
        }
    }
    public boolean deletedSinhVien(SinhVien sinhVien){
        String sql = "Delete SinhVien Where masv = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sinhVien.getMasv());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Mã Lỗi: "+e);
            return false;
        }
    }
}
