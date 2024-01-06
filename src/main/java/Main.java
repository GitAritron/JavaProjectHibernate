import configuration.SessionFactoryUtil;

public class Main {
        public static void main(String[] args) {

            System.out.println("Hello world!");
            SessionFactoryUtil.getSessionFactory().openSession();


//TODO need Data Access Objects (DAOs) and DTOs for read-only operations
    }
}


//Hibernate.isInitialized(orderDetailSet); is used to test if a "LazyLoad" object is loaded