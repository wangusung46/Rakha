package rakha.model.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rakha.connection.Conn;

/**
 *
 * @author Khanza
 */
public class BuyJdbcImplement implements BuyJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

    public BuyJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<Buy> selectBuys() {
        List<Buy> buys = new ArrayList<>();
        try {
            sql = "SELECT * FROM buy ORDER BY id DESC";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Buy buy = new Buy();
                buy.setId(resultSet.getLong(1));
                buy.setNameitem(resultSet.getString(2));
                buy.setCountItem(resultSet.getInt(3));
                buy.setSellPrice(resultSet.getBigDecimal(4));
                buys.add(buy);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return buys;
    }

    @Override
    public Buy selectBuy(Long id) {
        Buy buy = new Buy();
        try {
            sql = "SELECT a.amount_item - IFNULL(SUM(b.sell_amount), 0), a.sell_price FROM buy a LEFT JOIN sell b ON a.id = b.id_buy WHERE a.id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                buy.setCountItem(resultSet.getInt(1));
                buy.setSellPrice(resultSet.getBigDecimal(2));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return buy;
    }

}
