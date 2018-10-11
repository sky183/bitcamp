package jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@WebServlet("/DBCPInit")
public class DBCPInit extends HttpServlet {
       
   public void init() throws ServletException {
      //1. �����ͺ��̽� ����̹� �ε�
      loadJDBCDriver();
      
      //2. pool ����̹� �ε�
      initConnectionPool();
   }

   private void loadJDBCDriver() {
      
      try {
         
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("�����ͺ��̽� ����̹� �ε� ����");
         
      } catch (ClassNotFoundException e) {
         
         e.printStackTrace();
      }
   }

   private void initConnectionPool() {
      
      String jdbcDriver = "jdbc:oracle:thin:@localhost:1522:orcl";
      String username = "scott";
      String pw = "tiger";
      
      try{
      ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcDriver, username, pw);
      
      PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
      //Ŀ�ؼ��� ��ȿ���� ���θ� �˻��� �� ����ϴ� ������ �����Ѵ�.
      poolableConnFactory.setValidationQuery("select 1");
      //Ŀ�ؼ� Ǯ�� ���� ������ �����Ѵ�.
      GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
      //���� Ŀ�ؼ� �˻� �ֱ�
      poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
      //Ǯ�� �������� Ŀ�ؼ��� ��ȿ���� �˻����� ���� ����
      poolConfig.setTestWhileIdle(true);
      
      //Ŀ�ؼ� �ּ� ����
      poolConfig.setMinIdle(4);
      //Ŀ�ؼ� �ִ� ����
      poolConfig.setMaxTotal(50);
      //Ŀ�ؼ� Ǯ�� ����. �����ڴ� PoolabeConnectionFactory�� GenericObjectPoolConfig�� ���
      GenericObjectPool<PoolableConnection> connectionPool =
      new GenericObjectPool<>(poolableConnFactory, poolConfig);
      //PoolabeConnectionFactory���� Ŀ�ؼ� Ǯ�� ����
      poolableConnFactory.setPool(connectionPool);
      //Ŀ�ؼ� Ǯ�� �����ϴ� jdbc ����̹��� ���.
      Class.forName("org.apache.commons.dbcp2.PoolingDriver");
      PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
      
      //������ Ŀ�ؼ� Ǯ ����̹��� ������ Ŀ�ؼ� Ǯ�� ����Ѵ�. �̸��� chap14 �̴�.
      driver.registerPool("open", connectionPool);
      System.out.println("POOLING ��� ����");
      } catch(Exception e) {
         
      }
   }

}