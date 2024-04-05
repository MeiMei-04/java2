/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.NganhHoc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HieuCute
 */
public class NganhHocDao {
    Connection connection;

    public NganhHocDao() throws Exception {
        connection = ulitiles.DBContext.getConnection();
    }
    public List<NganhHoc> getAllData(){
        List<NganhHoc> lst = new ArrayList<>();
        String sql = "SELECT * FROM NganhHoc";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {                
                String manh = resultSet.getString("manh");
                String tennh = resultSet.getString("tennh");
                NganhHoc nganhHoc= new NganhHoc(manh, tennh);
                lst.add(nganhHoc);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("Mã Lỗi: "+e);
            return null;
        }
    }
    
}
