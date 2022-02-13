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
public class SellJdbcImplement implements SellJdbc {

    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String sql;

    public SellJdbcImplement() {
        connection = Conn.getConnection();
    }

    @Override
    public List<Sell> selectSells() {
        List<Sell> sells = new ArrayList<>();
        try {
            sql = "SELECT a.id, b.name, a.sell_amount, b.sell_price, a.cash "
                    + "FROM sell a LEFT JOIN buy b ON a.id_buy = b.id "
                    + "ORDER BY a.id DESC";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sell sell = new Sell();
                sell.setId(resultSet.getLong(1));
                sell.setName(resultSet.getString(2));
                sell.setSellAmount(resultSet.getInt(3));
                sell.setSellPrice(resultSet.getBigDecimal(4));
                sell.setCash(resultSet.getBigDecimal(5));
                sells.add(sell);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return sells;
    }

    @Override
    public void insertSell(Sell sell) {
        try {
            sql = "INSERT INTO sell VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, sell.getId());
            preparedStatement.setLong(2, sell.getIdBuy());
            preparedStatement.setLong(3, sell.getSellAmount());
            preparedStatement.setBigDecimal(4, sell.getCash());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateSell(Sell sell) {
        try {
            sql = "UPDATE sell SET "
                    + "id_buy = ?, "
                    + "sell_amount = ?, "
                    + "cash = ? "
                    + "WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, sell.getIdBuy());
            preparedStatement.setInt(2, sell.getSellAmount());
            preparedStatement.setBigDecimal(3, sell.getCash());
            preparedStatement.setLong(4, sell.getId());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteSell(Long id) {
        try {
            sql = "DELETE FROM sell WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
