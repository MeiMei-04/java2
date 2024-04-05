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
                String tennh = resultSet.getString("tennh");
                String tensv = resultSet.getString("tensv");
                double diem = resultSet.getDouble("diem");
                SinhVien sv = new SinhVien(masv, tennh, tensv, diem);
                lst.add(sv);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return null;
        }
    }
}
