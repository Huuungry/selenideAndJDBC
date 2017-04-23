package connection;
import java.sql.*;
import java.util.logging.*;


public class Sendbox {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		MySqlJDBC test = new MySqlJDBC();
		
		test.createConnection();
		test.readValues(0, 1000);
		test.insertLoginPassword("Test@test.com", "testpwd");
		test.closeConnection();

//		Connection connection = null;
//        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
//        String url = "jdbc:mysql://127.0.0.1:3306/yura";
//        //Имя пользователя БД
//        String name = "root";
//        //Пароль
//        String password = "Hungry";
//        try {
//            //Загружаем драйвер
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Драйвер подключен");
//            //Создаём соединение
//            connection = DriverManager.getConnection(url, name, password);
//            System.out.println("Соединение установлено");
//            //Для использования SQL запросов существуют 3 типа объектов:
//            //1.Statement: используется для простых случаев без параметров
//            Statement statement = null;
//
//            statement = connection.createStatement();
//            //Выполним запрос
//            ResultSet result1 = statement.executeQuery(
//                    "SELECT * FROM Emails");
//            //result это указатель на первую строку с выборки
//            //чтобы вывести данные мы будем использовать 
//            //метод next() , с помощью которого переходим к следующему элементу
//            System.out.println("Выводим statement");
//            while (result1.next()) {
//                System.out.println("#" + result1.getRow()
//                        + "\t ID = " + result1.getInt("id")
//                        + "\t" + result1.getString("Email")
//                        + "\t" + result1.getString("Password"));
//            }
//            // Вставить запись
//            statement.executeUpdate(
//                    "INSERT INTO Emails(Email, password) values('testEmail', 'testpassword')");
//            //Обновить запись
//            statement.executeUpdate(
//                    "UPDATE users SET username = 'admin' where id = 1");
            
//            
//
//            //2.PreparedStatement: предварительно компилирует запросы, 
//            //которые могут содержать входные параметры
//            PreparedStatement preparedStatement = null;
//            // ? - место вставки нашего значеня
//            preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM users where id > ? and id < ?");
//            //Устанавливаем в нужную позицию значения определённого типа
//            preparedStatement.setInt(1, 0);
//            preparedStatement.setInt(2, 10);
//            //выполняем запрос
//            ResultSet result2 = preparedStatement.executeQuery();
//            
//            System.out.println("Выводим PreparedStatement");
//            while (result2.next()) {
//                System.out.println("Номер в выборке #" + result2.getRow()
//                        + "\t Номер в базе #" + result2.getInt("id")
//                        + "\t" + result2.getString("username"));
//            }
//            
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO Emails(Email, password) values(?, ?)");
//            preparedStatement.setString(1, "user_name");
//            preparedStatement.setString(2, "password");
//
//            //метод принимает значение без параметров
//            //темже способом можно сделать и UPDATE
//            preparedStatement.executeUpdate();
//            
//            
//
//            //3.CallableStatement: используется для вызова хранимых функций,
//            // которые могут содержать входные и выходные параметры
//            CallableStatement callableStatement = null;
//            //Вызываем функцию myFunc (хранится в БД)
//            callableStatement = connection.prepareCall(
//                    " { call myfunc(?,?) } ");
//            //Задаём входные параметры
//            callableStatement.setString(1, "Dima");
//            callableStatement.setString(2, "Alex");
//            //Выполняем запрос
//            ResultSet result3 = callableStatement.executeQuery();
//            //Если CallableStatement возвращает несколько объектов ResultSet,
//            //то нужно выводить данные в цикле с помощью метода next
//            //у меня функция возвращает один объект
//            result3.next();
//            System.out.println(result3.getString("MESSAGE"));
//            //если функция вставляет или обновляет, то используется метод executeUpdate()

//        } catch (Exception ex) {
//            //выводим наиболее значимые сообщения
//            Logger.getLogger(Sendbox.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Sendbox.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }

    
		
		
		
	}

}
