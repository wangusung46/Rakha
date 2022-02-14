package rakha.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import rakha.connection.Conn;

/**
 *
 * @author Rakha
 */
public class UserJdbcImplement implements UserJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

    public UserJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public Boolean login(String userName, String password) {
        try {
            sql = "SELECT * FROM user WHERE user_name = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultSet.close();
                preparedStatement.close();
                return true;
            } else {
                resultSet.close();
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    @Override
    public Integer role(String userName) {
        try {
            sql = "SELECT role FROM user WHERE user_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer role = resultSet.getInt(1);
                return role;
            }
            resultSet.close();
            preparedStatement.close();
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }

    }

    @Override
    public Boolean supervisor(String password) {
        try {
            sql = "SELECT * FROM user WHERE password = ? AND role = 2";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultSet.close();
                preparedStatement.close();
                return true;
            } else {
                resultSet.close();
                preparedStatement.close();
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}
