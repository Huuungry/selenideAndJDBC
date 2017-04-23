package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlJDBC {

	Connection connection = null;

	public void createConnection() throws ClassNotFoundException, SQLException {
		// URL к базе состоит из
		// протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
		String url = "jdbc:mysql://127.0.0.1:3306/yura";
		// Имя пользователя БД
		String name = "root";
		// Пароль
		String password = "Hungry";
		// Загружаем драйвер
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Драйвер подключен");
		// Создаём соединение
		connection = DriverManager.getConnection(url, name, password);
		System.out.println("Соединение установлено");

	}

	public void insertLoginPassword(String login, String password) throws ClassNotFoundException, SQLException {
		if (connection == null) {
			createConnection();
		}
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement("INSERT INTO Emails(Email, password) values(?, ?)");
		preparedStatement.setString(1, login);
		preparedStatement.setString(2, password);

		// метод принимает значение без параметров
		// темже способом можно сделать и UPDATE
		preparedStatement.executeUpdate();

	}

	public void readValues(int fromId, int toId) throws SQLException, ClassNotFoundException {
		if (connection == null) {
			createConnection();
		}

		PreparedStatement preparedStatement = null;
		// ? - место вставки нашего значеня
		preparedStatement = connection.prepareStatement("SELECT * FROM Emails where id >= ? and id <= ?");
		// Устанавливаем в нужную позицию значения определённого типа
		preparedStatement.setInt(1, fromId);
		preparedStatement.setInt(2, toId);
		// выполняем запрос
		ResultSet result2 = preparedStatement.executeQuery();

		System.out.println("Выводим значения");
		while (result2.next()) {
			System.out.println("#" + result2.getRow() + "\t ID = " + result2.getInt("id") + "\t"
					+ result2.getString("Email") + "\t" + result2.getString("Password"));
		}

	}

	public void deleteByID(int fromId, int toId) throws SQLException, ClassNotFoundException {
		if (connection == null) {
			createConnection();
		}
		PreparedStatement preparedStatement = null;
		// ? - место вставки нашего значеня
		preparedStatement = connection.prepareStatement("delete from Emails where id >= ? and id <= ?");
		// Устанавливаем в нужную позицию значения определённого типа
		preparedStatement.setInt(1, fromId);
		preparedStatement.setInt(2, toId);
		// выполняем запрос
		preparedStatement.execute();
	}

	public void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

}
