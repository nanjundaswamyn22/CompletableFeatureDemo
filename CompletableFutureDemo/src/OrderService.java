import java.util.concurrent.CompletableFuture;

public class OrderService {

    public void placeOrder(){
        System.out.println("Order placed");

       CompletableFuture.supplyAsync(this::processPayment)
               .thenAccept(this::saveOrder)
               .thenRun(this::sendEmail).join();
      //  System.out.println(completableFuture);
//        Thread thread = new Thread(()->{
//                String paymentResult = processPayment();
//        System.out.println(paymentResult);
//        });
//           thread.start();
//        String paymentResult = processPayment();
//       System.out.println(paymentResult);
//
//       saveOrder(paymentResult);


        System.out.println("Order Completed.");
    }

    private String processPayment(){
        sleep(3000);
        return "Payment processed successfully.";
}
    private void saveOrder(String status){
        System.out.println("Order saved."+status);
    }

    private void sendEmail(){
        System.out.println("Email sent.");
    }

    private void sleep(long ms){
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
}
