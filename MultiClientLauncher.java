public class MultiClientLauncher {

    public static void main(String[] args) {

        int clientCount = 20;

        for (int i = 0; i < clientCount; i++) {

            new Thread(() -> {
                try {
                    ProxyClient.main(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
